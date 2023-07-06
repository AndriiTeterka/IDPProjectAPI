package tests.Rest.Comments;

import io.qameta.allure.Description;
import models.CommentPojo;
import org.testng.annotations.Test;
import tests.RestBaseTest;
import utils.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyCreatingNewComment extends RestBaseTest {

    @Description("Verify POST a new comment")
    @Test(description = "Verify POST a new comment")
    public void verifyCreatingNewComment() {
        CommentPojo request = DataGenerator.createRandomCommentByPostId(post.getPostList().stream().findFirst().get().getId());
        CommentPojo response = comment.createComment(request);

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
