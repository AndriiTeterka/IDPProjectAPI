package utils.services;

import models.CommentPojo;
import utils.ConfigProvider;

import java.util.List;

import static io.restassured.RestAssured.given;

public class CommentService extends BaseService {

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
