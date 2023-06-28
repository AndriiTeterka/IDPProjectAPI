package tests.Posts;

import io.qameta.allure.Description;
import models.PostPojo;
import org.testng.annotations.Test;
import tests.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyPostListIsNotEmpty extends BaseTest {

    @Description("Verify post list is not empty")
    @Test(description = "Verify post list is not empty")
    public void verifyPostListIsNotEmpty() {
        assertThat(post.getPostList()).extracting(PostPojo::getId).isNotNull().isNotEmpty();
    }
}
