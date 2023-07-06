package tests.Rest.Posts;

import io.qameta.allure.Description;
import models.PostPojo;
import org.testng.annotations.Test;
import tests.RestBaseTest;
import utils.DataGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyCreatingNewPost extends RestBaseTest {

    @Description("Verify POST a new post")
    @Test(description = "Verify POST a new post")
    public void verifyCreatingNewPost() {
        PostPojo request = DataGenerator.createRandomPostByUserId(user.getUserList().stream().findFirst().get().getId());
        PostPojo response = post.createPost(request);

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