package tests.Comments;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;

public class VerifyDeletingExistingComment extends BaseTest {

    @Description("Verify deleting existing comment")
    @Test(description = "Verify deleting existing comment")
    public void VerifyDeletingExistingComment() {
        comment.deleteComment(comment.getCommentList().stream().findFirst().get().getId());
    }
}
