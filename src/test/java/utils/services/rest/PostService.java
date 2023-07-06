package utils.services.rest;

import models.PostPojo;
import utils.ConfigProvider;
import utils.services.RestService;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostService extends RestService {

    @Override
    public String getBasePath() {
        return "/posts";
    }

    public List<PostPojo> getPostList() {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .get()
                .then()
                .log().all()
                .extract()
                .jsonPath().getList(".", PostPojo.class);
    }

    public PostPojo getPostById(int id) {
        return given()
                .spec(buildRequestSpecificationById(id))
                .get()
                .then()
                .log().all()
                .extract().as(PostPojo.class);
    }

    public PostPojo createPost(PostPojo request) {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .auth()
                .oauth2(ConfigProvider.ACCESS_TOKEN)
                .body(request)
                .post()
                .as(PostPojo.class);
    }

    public PostPojo updatePost(PostPojo request, int id) {
        return given()
                .spec(buildRequestSpecificationById(id))
                .auth()
                .oauth2(ConfigProvider.ACCESS_TOKEN)
                .body(request)
                .put()
                .as(PostPojo.class);
    }

    public void deletePost(int id) {
        given()
                .spec(buildRequestSpecificationById(id))
                .auth()
                .oauth2(ConfigProvider.ACCESS_TOKEN)
                .delete()
                .then()
                .statusCode(204)
                .log().status();
    }

    public void deleteAllPosts() {
        List<PostPojo> postList = getPostList();
        for (PostPojo post : postList) {
            given()
                    .spec(buildRequestSpecificationById(post.getId()))
                    .auth()
                    .oauth2(ConfigProvider.ACCESS_TOKEN)
                    .delete()
                    .then()
                    .statusCode(204)
                    .log().status();
        }
    }
}
