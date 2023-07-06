package tests.Rest.Comments;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

public class VerifyDeletingExistingComment extends RestBaseTest {

    @Description("Verify deleting existing comment")
    @Test(description = "Verify deleting existing comment")
    public void VerifyDeletingExistingComment() {
        comment.deleteComment(comment.getCommentList().stream().findFirst().get().getId());
    }
}
