package tests.Posts;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;

public class VerifyDeletingExistingPost extends BaseTest {

    @Description("Verify deleting existing post")
    @Test(description = "Verify deleting existing post")
    public void verifyDeletingExistingPost() {
        post.deletePost(post.getPostList().stream().findFirst().get().getId());
    }
}
