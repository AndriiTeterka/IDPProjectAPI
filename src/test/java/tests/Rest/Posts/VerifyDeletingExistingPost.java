package tests.Rest.Posts;

import io.qameta.allure.Description;
import org.testng.annotations.Test;
import tests.RestBaseTest;

/**
 * This class contains a test case for verifying the deletion of an existing post.
 * It extends the RestBaseTest class.
 * The VerifyDeletingExistingPost test case uses the post object to retrieve the first post from the post list,
 * and then sends a request to delete that post using its ID.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 */
public class VerifyDeletingExistingPost extends RestBaseTest {

    @Description("Verify deleting existing post")
    @Test(description = "Verify deleting existing post")
    public void verifyDeletingExistingPost() {
        post.deletePost(post.getPostList().stream().findFirst().get().getId());
    }
}
