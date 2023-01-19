package services;

import entities.User;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import static io.restassured.RestAssured.given;
import static services.ApiSpecification.requestSpecApiV1;
import static services.ApiSpecification.responseSpecStatusCode200;

public class UserApi {
    private static final String path = "/user/";

    @Step("Создание нового пользователя через POST запрос")
    public String createUser(User user) {
        return
                given(requestSpecApiV1(path))
                        .body(user)
                        .log().all()
                        .when()
                        .post()
                        .then()
                        .spec(responseSpecStatusCode200())
                        .extract()
                        .jsonPath()
                        .get("message");
    }

    public String updateUser(String userName, User user) {
        return
                given(requestSpecApiV1(path + userName))
                        .body(user)
                        .log().all()
                        .when()
                        .put()
                        .then()
                        .spec(responseSpecStatusCode200())
                        .extract()
                        .jsonPath()
                        .get("message");
    }

    public Response getUserByName(String username) {
        return given(requestSpecApiV1(path + username))
                .when()
                .get()
                .then()
                .log().all()
                .extract()
                .response();
    }

    public String deleteUserByName(String username) {
        return given(requestSpecApiV1(path + username))
                .when()
                .delete()
                .then()
                .extract()
                .jsonPath()
                .get("message");
    }

}
