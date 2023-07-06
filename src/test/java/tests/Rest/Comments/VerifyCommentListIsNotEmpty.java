package tests.Rest.Comments;

import io.qameta.allure.Description;
import models.CommentPojo;
import org.testng.annotations.Test;
import tests.RestBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyCommentListIsNotEmpty extends RestBaseTest {

    @Description("Verify comment list is not empty")
    @Test(description = "Verify comment list is not empty")
    public void verifyCommentListIsNotEmpty() {
        assertThat(comment.getCommentList()).extracting(CommentPojo::getId).isNotNull().isNotEmpty();
    }
}
