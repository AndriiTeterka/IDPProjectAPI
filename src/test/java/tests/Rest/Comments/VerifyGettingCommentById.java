package tests.Rest.Comments;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class contains a test case for verifying the retrieval of a comment by its ID using a GET request.
 * It extends the RestBaseTest class.
 * The VerifyGettingCommentById test case uses the comment object to retrieve the first comment from the comment list,
 * gets its ID, and then sends a GET request to retrieve the comment by its ID.
 * The test asserts that the ID of the retrieved comment matches the original comment ID.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The assertThat method from the AssertJ library is used for assertions.
 */
public class VerifyGettingCommentById extends RestBaseTest {

    @Description("Verify GET comment by id")
    @Test(description = "Verify GET comment by id")
    public void verifyGettingCommentById() {
        int commentId = comment.getCommentList().stream().findFirst().get().getId();
        assertThat(comment.getCommentById(commentId).getId()).isEqualTo(commentId);
    }
}
