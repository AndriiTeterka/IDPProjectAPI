package tests.Rest.Posts;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class VerifyGettingPostById extends RestBaseTest {

    @Description("Verify GET post by id")
    @Test(description = "Verify GET post by id")
    public void verifyGettingPostById() {
        int postId = post.getPostList().stream().findFirst().get().getId();
        assertThat(post.getPostById(postId).getId()).isEqualTo(postId);
    }
}
