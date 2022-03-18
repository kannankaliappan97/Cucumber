package Step;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class ApiStep {
    private static String requestBody = "{\n" +
            "  \"title\": \"My first Post\",\n" +
            "  \"body\": \"Body Response Posted\",\n" +
            "  \"userId\": \"101\" \n}";
    public void baseurl(){
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    public void post(){
        baseurl();
        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .extract().response();

        Assertions.assertEquals(201, response.statusCode());
        Assertions.assertEquals("My first Post", response.jsonPath().getString("title"));
        Assertions.assertEquals("Body Response Posted", response.jsonPath().getString("body"));
        Assertions.assertEquals("101", response.jsonPath().getString("userId"));
        Assertions.assertEquals("101", response.jsonPath().getString("id"));
    }

    public void get(){
        baseurl();
        Response response = given()
                .contentType(ContentType.JSON)
                .param("postId", "1")
                .when()
                .get("/comments")
                .then()
                .extract().response();

        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Jayne_Kuhic@sydney.com", response.jsonPath().getString("email[1]"));


    }
}
