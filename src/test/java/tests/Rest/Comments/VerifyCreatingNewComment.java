package tests.Rest.Comments;

import io.qameta.allure.Description;
import models.CommentPojo;
import org.testng.annotations.Test;
import tests.RestBaseTest;
import utils.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class contains a test case for verifying the creation of a new comment using a POST request.
 * It extends the RestBaseTest class.
 * The VerifyCreatingNewComment test case generates a random comment using the DataGenerator class,
 * associates it with a post by retrieving the first post from the post list, and then sends a POST request to create the comment.
 * The test asserts that the response is not null and that the response properties match the request properties.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The DataGenerator class is used to generate a random comment based on a post ID.
 * The assertThat method from the AssertJ library is used for assertions.
 */
public class VerifyCreatingNewComment extends RestBaseTest {

    @Description("Verify POST a new comment")
    @Test(description = "Verify POST a new comment")
    public void verifyCreatingNewComment() {
        CommentPojo request = DataGenerator.createRandomCommentByPostId(post.getPostList().stream().findFirst().get().getId());
        CommentPojo response = comment.createComment(request);

        assertThat(response)
                .isNotNull()
                .extracting(
                        CommentPojo::getPostId,
                        CommentPojo::getName,
                        CommentPojo::getEmail,
                        CommentPojo::getBody)
                .containsExactly(
                        request.getPostId(),
                        request.getName(),
                        request.getEmail(),
                        request.getBody());
    }
}
