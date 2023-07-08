package tests.Rest.Comments;

import io.qameta.allure.Description;
import models.CommentPojo;
import org.testng.annotations.Test;
import tests.RestBaseTest;
import utils.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class contains a test case for verifying the updating of an existing comment using a PUT request.
 * It extends the RestBaseTest class.
 * The VerifyUpdatingExistingComment test case generates a random comment using the DataGenerator class,
 * associates it with a post by retrieving the first post from the post list,
 * retrieves the ID of an existing comment from the comment list,
 * and then sends a PUT request to update the comment using its ID.
 * The test asserts that the response is not null and that the response properties match the updated request properties.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The DataGenerator class is used to generate a random comment based on a post ID.
 * The assertThat method from the AssertJ library is used for assertions.
 */
public class VerifyUpdatingExistingComment extends RestBaseTest {

    @Description("Verify updating existing comment")
    @Test(description = "Verify updating existing comment")
    public void verifyUpdatingExistingComment() {
        CommentPojo request = DataGenerator.createRandomCommentByPostId(post.getPostList().stream().findFirst().get().getId());
        CommentPojo response = comment.updateComment(request, comment.getCommentList().stream().findFirst().get().getId());

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
