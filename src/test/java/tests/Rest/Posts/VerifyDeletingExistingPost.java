package tests.Rest.Posts;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

public class VerifyDeletingExistingPost extends RestBaseTest {

    @Description("Verify deleting existing post")
    @Test(description = "Verify deleting existing post")
    public void verifyDeletingExistingPost() {
        post.deletePost(post.getPostList().stream().findFirst().get().getId());
    }
}
