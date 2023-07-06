package tests.Rest.Posts;

import io.qameta.allure.Description;
import models.PostPojo;
import org.testng.annotations.Test;
import tests.RestBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyPostListIsNotEmpty extends RestBaseTest {

    @Description("Verify post list is not empty")
    @Test(description = "Verify post list is not empty")
    public void verifyPostListIsNotEmpty() {
        assertThat(post.getPostList()).extracting(PostPojo::getId).isNotNull().isNotEmpty();
    }
}
