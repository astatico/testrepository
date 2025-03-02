package testcode.api;

import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AdvancedApiExamplesTest {

    //BitBucket API

    @Test
    public void testQueryParameters() {
        given().
                auth().preemptive().basic("username", "password").
                queryParam("pagelen", 5).
                log().all().
                when().
                get("https://api.bitbucket.org/2.0/repositories/username").
                then().
                log().all().
                assertThat().
                statusCode(200).
                body("values.size()", lessThanOrEqualTo(5));
    }

    @Test
    public void testHeaders() {
        given().
                auth().preemptive().basic("username", "password").
                header("Accept", "application/json").
                log().headers().
                when().
                get("https://api.bitbucket.org/2.0/repositories/username/repo-name/refs/branches").
                then().
                log().body().
                assertThat().
                statusCode(200).
                body("values.size()", greaterThan(0));
    }

    @Test
    public void testRequestBody() {
        String requestBody = "{\n" +
                "  \"scm\": \"git\",\n" +
                "  \"is_private\": false,\n" +
                "  \"description\": \"Тестовый репозиторий (API)\",\n" +
                "  \"project\": {\n" +
                "    \"key\": \"TES\"\n" +
                "  }\n" +
                "}";

        given().
                auth().preemptive().basic("username", "password").
                header("Content-Type", "application/json").
                body(requestBody).
                log().body().
                when().
                post("https://api.bitbucket.org/2.0/repositories/username/test-repo-api").
                then().
                log().all().
                assertThat().
                statusCode(200).
                body("name", equalTo("test-repo-api"));
    }

    @Test
    public void generateBearerToken() {
        String clientId = "your-consumer-key"; // Ключ OAuth Consumer
        String clientSecret = "your-consumer-secret"; // Секрет OAuth Consumer

        Response response = given().
                auth().preemptive().basic(clientId, clientSecret). // Basic Auth с ключом и секретом
                        header("Content-Type", "application/x-www-form-urlencoded").
                formParam("grant_type", "client_credentials"). // Указываем тип запроса
                        log().all().
                when().
                post("https://bitbucket.org/site/oauth2/access_token"). // Запрос токена
                        then().
                log().all().
                assertThat().
                statusCode(200). // Убедимся, что запрос успешен
                        extract().response();

        // Извлекаем токен из ответа
        String accessToken = response.jsonPath().getString("access_token");
        System.out.println("Bearer Token: " + accessToken);
    }

    @Test
    public void testBearerToken() {
        String token = "fgmhdlfshGLFJDGAghfldcmghjdfcgm";

        given().
                header("Authorization", "Bearer " + token).
                log().all().
                when().
                get("https://api.bitbucket.org/2.0/user").
                then().
                log().all().
                assertThat().
                statusCode(200).
                body("username", equalTo("username"));
    }

    @Test
    public void testArrayValidation() {
        given().
                auth().preemptive().basic("username", "password").
                log().all().
                when().
                get("https://api.bitbucket.org/2.0/repositories/username").
                then().
                log().body().
                assertThat().
                statusCode(200).
                body("values.name", not(empty()));
    }

    @Test
    public void validateComplexResponseWithoutPatterns() {
        given().
                auth().preemptive().basic("username", "password").
                log().all().
                when().
                get("https://api.bitbucket.org/2.0/repositories/username").
                then().
                log().body().
                assertThat().
                statusCode(200).
                body("values.size()", greaterThanOrEqualTo(3)).
                body("values.name", everyItem(not(emptyString()))).
                body("values.is_private", hasItem(true)).
                body("values.is_private", hasItem(false)).
                body("values.links.html.href", everyItem(startsWith("https://bitbucket.org/")));
    }

    @Test(dataProvider = "repositoryData")
    public void testParameterizedRepositoryCreation(String repoName, String description) {
        String requestBody = "{\n" +
                "  \"scm\": \"git\",\n" +
                "  \"is_private\": true,\n" +
                "  \"description\": \"" + description + "\",\n" +
                "  \"project\": {\n" +
                "    \"key\": \"TES\"\n" +
                "  }\n" +
                "}";

        given().
                auth().preemptive().basic("username", "password").
                header("Content-Type", "application/json").
                body(requestBody).
                log().body().
                when().
                post("https://api.bitbucket.org/2.0/repositories/username/" + repoName).
                then().
                log().all().
                assertThat().
                statusCode(200).
                body("name", equalTo(repoName));
    }

    @DataProvider(name = "repositoryData")
    public Object[][] createRepositoryData() {
        return new Object[][]{
                {"repo1", "Первый репозиторий"},
                {"repo2", "Второй репозиторий"}
        };
    }

    // GitHub API
    @Test
    public void testQueryParametersGitHub() {
        given().
                auth().preemptive().basic("your-username", "your-personal-access-token").
                queryParam("per_page", 5). // Ограничиваем список до 5 записей
                log().all(). // Логируем запрос
                when().
                get("https://api.github.com/users/astatico/repos"). // Запрашиваем репозитории
                then().
                log().all(). // Логируем ответ
                assertThat().
                statusCode(200). // Проверяем, что запрос успешный
                body("size()", lessThanOrEqualTo(5)); // Убеждаемся, что получено не более 5 репозиториев
    }

    @Test
    public void testHeadersGitHub() {
        given().
                auth().preemptive().basic("your-username", "your-personal-access-token").
                header("Accept", "application/vnd.github.v3+json"). // Указываем, что работаем с API v3
                log().headers().
                when().
                get("https://api.github.com/repos/your-username/your-repository/branches"). // Запрос веток
                then().
                log().body().
                assertThat().
                statusCode(200). // Запрос успешный
                body("size()", greaterThan(0)); // Должна быть хотя бы одна ветка
    }

    @Test
    public void testCreateRepositoryGitHub() {
        String requestBody = """
                {
                  "name": "test-repo",
                  "description": "Тестовый репозиторий",
                  "private": true
                }""";

        given().
                auth().preemptive().basic("your-username", "your-personal-access-token").
                header("Content-Type", "application/json").
                body(requestBody).
                log().body().
                when().
                post("https://api.github.com/user/repos").
                then().
                log().all().
                assertThat().
                statusCode(201). // Проверяем, что репозиторий создан
                body("name", equalTo("test-repo")); // Проверяем, что имя совпадает
    }

    @Test
    public void testBearerTokenGitHub() {
        String token = "your-bearer-token";

        given().
                header("Authorization", "Bearer " + token).
                log().all().
                when().
                get("https://api.github.com/user").
                then().
                log().all().
                assertThat().
                statusCode(200). // Запрос успешный
                body("login", equalTo("your-username")); // Проверяем имя пользователя
    }

    @Test
    public void testArrayValidationGitHub() {
        given().
                auth().preemptive().basic("your-username", "your-personal-access-token").
                log().all().
                when().
                get("https://api.github.com/users/astatico/repos").
                then().
                log().body().
                assertThat().
                statusCode(200).
                body("size()", greaterThanOrEqualTo(2)); // Проверяем, что у нас хотя бы 2 репозитория
    }

    @Test(dataProvider = "repositoryDataGitHub")
    public void testParameterizedRepositoryCreationGitHub(String repoName, String description) {
        String requestBody = "{\n" +
                "  \"name\": \"" + repoName + "\",\n" +
                "  \"description\": \"" + description + "\",\n" +
                "  \"private\": true\n" +
                "}";

        given().
                auth().preemptive().basic("your-username", "your-personal-access-token").
                header("Content-Type", "application/json").
                body(requestBody).
                log().body().
                when().
                post("https://api.github.com/user/repos").
                then().
                log().all().
                assertThat().
                statusCode(201). // Репозиторий создан
                body("name", equalTo(repoName)); // Проверяем, что имя совпадает
    }

    @DataProvider(name = "repositoryDataGitHub")
    public Object[][] createRepositoryDataGitHub() {
        return new Object[][] {
                {"repo1", "Первый тестовый репозиторий"},
                {"repo2", "Второй тестовый репозиторий"},
                {"repo3", "Третий тестовый репозиторий"}
        };
    }
}
