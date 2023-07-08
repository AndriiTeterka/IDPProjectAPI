package tests.Rest.Comments;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

/**
 * This class contains a test case for verifying the deletion of all comments.
 * It extends the RestBaseTest class.
 * The VerifyDeletingAllComments test case uses the comment object to send a request to delete all comments.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 */
public class VerifyDeletingAllComments extends RestBaseTest {

    @Description("Verify deleting all comments")
    @Test(description = "Verify deleting all comments")
    public void verifyDeletingAllComments() {
        comment.deleteAllComments();
    }
}
