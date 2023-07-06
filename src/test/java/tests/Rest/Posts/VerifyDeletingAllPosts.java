package tests.Rest.Posts;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

public class VerifyDeletingAllPosts extends RestBaseTest {

    @Description("Verify deleting all posts")
    @Test(description = "Verify deleting all posts")
    public void verifyDeletingAllPosts() {
        post.deleteAllPosts();
    }
}
