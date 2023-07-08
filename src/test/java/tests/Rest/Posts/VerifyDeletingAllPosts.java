package tests.Rest.Posts;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

/**
 * This class contains a test case for verifying the deletion of all posts.
 * It extends the RestBaseTest class.
 * The VerifyDeletingAllPosts test case uses the post object to send a request to delete all posts.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 */
public class VerifyDeletingAllPosts extends RestBaseTest {

    @Description("Verify deleting all posts")
    @Test(description = "Verify deleting all posts")
    public void verifyDeletingAllPosts() {
        post.deleteAllPosts();
    }
}
