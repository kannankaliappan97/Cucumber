package StepDefs;

import Step.ApiStep;
import io.cucumber.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class ApiStepdefs {
    ApiStep apiStep =new ApiStep();
    private static String requestBody = "{\n" +
            "  \"title\": \"My first Post\",\n" +
            "  \"body\": \"Body Response Posted\",\n" +
            "  \"userId\": \"101\" \n}";
    @Given("Add the data")
    public void add_the_data() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
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

    @Given("i hit the {string} request")
    public void iHitTheRequest(String request) {
        if(request.equalsIgnoreCase("post")){
            apiStep.post();
        }else if(request.equalsIgnoreCase("get")){
            apiStep.get();
        }
    }
}
