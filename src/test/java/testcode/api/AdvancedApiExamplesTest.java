package testcode.api;

import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class AdvancedApiExamplesTest {

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
}
