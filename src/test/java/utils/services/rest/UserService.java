package utils.services.rest;

import models.UserPojo;
import utils.ConfigProvider;
import utils.services.RestService;

import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * This class provides methods to interact with the REST API for users.
 * It extends the RestService class.
 * The UserService class is responsible for sending REST requests related to users.
 * It has methods to retrieve the user list, get a user by their ID, create a new user,
 * update an existing user, delete a user by their ID, and delete all users.
 * Note: This class uses the ConfigProvider class to retrieve the access token for authentication.
 * The RestService class provides the base functionality for sending REST requests.
 * The REQUEST_SPECIFICATION is inherited from the RestService class and is used for request specification.
 */
public class UserService extends RestService {

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
