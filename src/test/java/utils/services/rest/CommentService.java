package utils.services.rest;

import models.CommentPojo;
import utils.ConfigProvider;
import utils.services.RestService;

import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * This class provides methods to interact with the REST API for comments.
 * It extends the RestService class.
 * The CommentService class is responsible for sending REST requests related to comments.
 * It has methods to retrieve the comment list, get a comment by its ID, create a new comment,
 * update an existing comment, delete a comment by its ID, and delete all comments.
 * Note: This class uses the ConfigProvider class to retrieve the access token for authentication.
 * The RestService class provides the base functionality for sending REST requests.
 * The REQUEST_SPECIFICATION is inherited from the RestService class and is used for request specification.
 */
public class CommentService extends RestService {

    @Override
    public String getBasePath() {
        return "/comments";
    }

    public List<CommentPojo> getCommentList() {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .get()
                .then()
                .log().all()
                .extract()
                .jsonPath().getList(".", CommentPojo.class);
    }

    public CommentPojo getCommentById(int id) {
        return given()
                .spec(buildRequestSpecificationById(id))
                .get()
                .then()
                .log().all()
                .extract().as(CommentPojo.class);
    }

    public CommentPojo createComment(CommentPojo request) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .auth()
                .oauth2(ConfigProvider.ACCESS_TOKEN)
                .body(request)
                .post()
                .as(CommentPojo.class);
    }

    public CommentPojo updateComment(CommentPojo request, int id) {
        return given()
                .spec(buildRequestSpecificationById(id))
                .auth()
                .oauth2(ConfigProvider.ACCESS_TOKEN)
                .body(request)
                .put()
                .as(CommentPojo.class);
    }

    public void deleteComment(int id) {
        given()
                .spec(buildRequestSpecificationById(id))
                .auth()
                .oauth2(ConfigProvider.ACCESS_TOKEN)
                .delete()
                .then()
                .statusCode(204)
                .log().status();
    }

    public void deleteAllComments() {
        List<CommentPojo> commentList = getCommentList();
        for (CommentPojo comment : commentList) {
            given()
                    .spec(buildRequestSpecificationById(comment.getId()))
                    .auth()
                    .oauth2(ConfigProvider.ACCESS_TOKEN)
                    .delete()
                    .then()
                    .statusCode(204)
                    .log().status();
        }
    }
}
