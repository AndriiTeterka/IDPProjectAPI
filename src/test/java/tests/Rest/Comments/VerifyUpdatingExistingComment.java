package tests.Rest.Comments;

import io.qameta.allure.Description;
import models.CommentPojo;
import org.testng.annotations.Test;
import tests.RestBaseTest;
import utils.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyUpdatingExistingComment extends RestBaseTest {

    @Description("Verify updating existing comment")
    @Test(description = "Verify updating existing comment")
    public void verifyUpdatingExistingComment() {
        CommentPojo request = DataGenerator.createRandomCommentByPostId(post.getPostList().stream().findFirst().get().getId());
        CommentPojo response = comment.updateComment(request, comment.getCommentList().stream().findFirst().get().getId());

        assertThat(response)
                .isNotNull()
                .extracting(
                        CommentPojo::getPostId,
                        CommentPojo::getName,
                        CommentPojo::getEmail,
                        CommentPojo::getBody)
                .containsExactly(
                        request.getPostId(),
                        request.getName(),
                        request.getEmail(),
                        request.getBody());
    }
}
