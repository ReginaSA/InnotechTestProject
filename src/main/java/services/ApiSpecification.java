package services;

import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ApiSpecification {

    private static String baseUrl = "https://petstore.swagger.io/v2";

    public static RequestSpecification requestSpecApiV1(String path) {
        return new RequestSpecBuilder()
                .setBaseUri(baseUrl + path)
                .setContentType(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();
    }

    public static ResponseSpecification responseSpecStatusCode200() {
        return new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
}
