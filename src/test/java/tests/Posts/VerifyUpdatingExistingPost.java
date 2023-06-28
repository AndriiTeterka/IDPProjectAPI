package tests.Posts;

import io.qameta.allure.Description;
import models.PostPojo;
import models.UserPojo;
import org.testng.annotations.Test;
import tests.BaseTest;
import utils.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyUpdatingExistingPost extends BaseTest {

    @Description("Verify updating existing post")
    @Test(description = "Verify updating existing post")
    public void verifyUpdatingExistingPost() {
        PostPojo request = DataGenerator.createRandomPostByUserId(user.getUserList().stream().findFirst().get().getId());
        PostPojo response = post.updatePost(request, post.getPostList().stream().findFirst().get().getId());

        assertThat(response)
                .isNotNull()
                .extracting(
                        PostPojo::getUserId,
                        PostPojo::getTitle,
                        PostPojo::getBody,
                        PostPojo::getName)
                .containsExactly(
                        request.getUserId(),
                        request.getTitle(),
                        request.getBody(),
                        request.getName());
    }
}
