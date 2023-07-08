package tests.Rest.Comments;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

/**
 * This class contains a test case for verifying the deletion of an existing comment.
 * It extends the RestBaseTest class.
 * The VerifyDeletingExistingComment test case uses the comment object to retrieve the first comment from the comment list,
 * and then sends a request to delete that comment using its ID.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 */
public class VerifyDeletingExistingComment extends RestBaseTest {

    @Description("Verify deleting existing comment")
    @Test(description = "Verify deleting existing comment")
    public void VerifyDeletingExistingComment() {
        comment.deleteComment(comment.getCommentList().stream().findFirst().get().getId());
    }
}
