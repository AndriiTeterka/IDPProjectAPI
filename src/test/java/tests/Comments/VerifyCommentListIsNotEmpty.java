package tests.Comments;

import io.qameta.allure.Description;
import models.CommentPojo;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyCommentListIsNotEmpty extends BaseTest {

    @Description("Verify comment list is not empty")
    @Test(description = "Verify comment list is not empty")
    public void verifyCommentListIsNotEmpty() {
        assertThat(comment.getCommentList()).extracting(CommentPojo::getId).isNotNull().isNotEmpty();
    }
}
