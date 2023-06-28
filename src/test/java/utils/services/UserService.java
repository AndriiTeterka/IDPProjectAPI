package utils.services;

import models.UserPojo;
import utils.ConfigProvider;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserService extends BaseService {

    @Override
    public String getBasePath() {
        return "/users";
    }

    public List<UserPojo> getUserList() {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .get()
                .then()
                .log().all()
                .extract()
                .jsonPath().getList(".", UserPojo.class);
    }

    public UserPojo getUserById(int id) {
        return given()
                .spec(buildRequestSpecificationById(id))
                .get()
                .then()
                .log().all()
                .extract().as(UserPojo.class);
    }

    public UserPojo createUser(UserPojo request) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .auth()
                .oauth2(ConfigProvider.ACCESS_TOKEN)
                .body(request)
                .post()
                .as(UserPojo.class);
    }

    public UserPojo updateUser(UserPojo request, int id) {
        return given()
                .spec(buildRequestSpecificationById(id))
                .auth()
                .oauth2(ConfigProvider.ACCESS_TOKEN)
                .body(request)
                .put()
                .as(UserPojo.class);
    }

    public void deleteUser(int id) {
        given()
                .spec(buildRequestSpecificationById(id))
                .auth()
                .oauth2(ConfigProvider.ACCESS_TOKEN)
                .delete()
                .then()
                .statusCode(204)
                .log().status();
    }

    public void deleteAllUsers() {
        List<UserPojo> userList = getUserList();
        for (UserPojo user : userList) {
            given()
                    .spec(buildRequestSpecificationById(user.getId()))
                    .auth()
                    .oauth2(ConfigProvider.ACCESS_TOKEN)
                    .delete()
                    .then()
                    .statusCode(204)
                    .log().status();
        }
    }
}
