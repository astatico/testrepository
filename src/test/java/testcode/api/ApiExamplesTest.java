package testcode.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ApiExamplesTest {

    @BeforeClass
    void initParam() {
        // Установка базового URL
        RestAssured.baseURI = "https://reqres.in/api";
    }

    @Test
    void getApiTest() {
        // Пример GET-запроса с проверкой
        given().
                when().
                get("/users/2").
                then().
                assertThat().
                statusCode(200).
                body("data.first_name", equalTo("Janet"));
    }

    @Test
    void getPositiveApiTest() {
        Response response =
                given().
                        when().
                        get("/users/2").
                        then().
                        assertThat().
                        statusCode(200).
                        body("data.first_name", equalTo("Janet")).
                        extract().response();

        System.out.println("Response Body: " + response.asString());
    }

    @Test
    void getNegativeApiTest() {
        given().
                when().
                get("/users/999").
                then().
                assertThat().
                statusCode(404);
    }

    @Test
    void postApiTest() {
        String requestBody = "{\"name\": \"John Doe\", \"job\": \"leader\"}";

        Response response =
                given().
                        header("Content-Type", "application/json").
                        body(requestBody).
                        when().
                        post("/users").
                        then().
                        assertThat().
                        statusCode(201).
                        extract().response();

        System.out.println("Response Body: " + response.asString());
    }

    @Test
    void putApiTest() {
        String updateBody = "{ \"name\": \"John Updated\", \"job\": \"manager\"}";

        given().
                header("Content-Type", "application/json").
                body(updateBody).
                when().
                put("/users/2").
                then().
                assertThat().
                statusCode(200).
                body("name", equalTo("John Updated"));
    }

    @Test
    void patchApiTest() {
        String patchBody = "{ \"job\": \"developer\"}";

        given().
                header("Content-Type", "application/json").
                body(patchBody).
                when().
                patch("/users/2").
                then().
                assertThat().
                statusCode(200).
                body("job", equalTo("developer"));
    }

    @Test
    void deleteApiTest() {
        given().
                when().
                delete("/users/2").
                then().
                assertThat().
                statusCode(204);
    }

    @Test
    void getUsersListApiTest() {
        Response response =
                given().
                        when().
                        get("/users?page=1").
                        then().
                        assertThat().
                        statusCode(200).
                        extract().response();

        String firstNameFirstUser = response.jsonPath().getString("data[0].first_name");
        System.out.println("First Name of First User: " + firstNameFirstUser);
    }
}
