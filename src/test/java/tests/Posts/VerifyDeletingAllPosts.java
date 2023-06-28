package tests.Posts;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.BaseTest;

public class VerifyDeletingAllPosts extends BaseTest {

    @Description("Verify deleting all posts")
    @Test(description = "Verify deleting all posts")
    public void verifyDeletingAllPosts() {
        post.deleteAllPosts();
    }
}
