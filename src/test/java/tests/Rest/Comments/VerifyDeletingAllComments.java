package tests.Rest.Comments;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

public class VerifyDeletingAllComments extends RestBaseTest {

    @Description("Verify deleting all comments")
    @Test(description = "Verify deleting all comments")
    public void verifyDeletingAllComments() {
        comment.deleteAllComments();
    }
}
