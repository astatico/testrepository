package testcode.api;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class BasicApiTest {

    @Test
    void firstApiTest() {
        // Установка базового URL
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        // Выполнение простого GET-запроса и проверка статус-кода
        given().
                log().all().
                when().
                get("/posts/1").
                then().
                log().all().
                assertThat().
                statusCode(200).
                body("userId", equalTo(1));
    }
}
