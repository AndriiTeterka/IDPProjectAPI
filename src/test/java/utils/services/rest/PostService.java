package utils.services.rest;

import models.PostPojo;
import utils.ConfigProvider;
import utils.services.RestService;

import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * This class provides methods to interact with the REST API for posts.
 * It extends the RestService class.
 * The PostService class is responsible for sending REST requests related to posts.
 * It has methods to retrieve the post list, get a post by its ID, create a new post,
 * update an existing post, delete a post by its ID, and delete all posts.
 * Note: This class uses the ConfigProvider class to retrieve the access token for authentication.
 * The RestService class provides the base functionality for sending REST requests.
 * The REQUEST_SPECIFICATION is inherited from the RestService class and is used for request specification.
 */
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
