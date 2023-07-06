package tests.Rest.Comments;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyGettingCommentById extends RestBaseTest {

    @Description("Verify GET comment by id")
    @Test(description = "Verify GET comment by id")
    public void verifyGettingCommentById() {
        int commentId = comment.getCommentList().stream().findFirst().get().getId();
        assertThat(comment.getCommentById(commentId).getId()).isEqualTo(commentId);
    }
}
