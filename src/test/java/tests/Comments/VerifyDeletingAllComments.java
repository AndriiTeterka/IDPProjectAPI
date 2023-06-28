package tests.Comments;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;

public class VerifyDeletingAllComments extends BaseTest {

    @Description("Verify deleting all comments")
    @Test(description = "Verify deleting all comments")
    public void verifyDeletingAllComments() {
        comment.deleteAllComments();
    }
}
