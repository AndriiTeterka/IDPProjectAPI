package tests.Rest.Posts;

import io.qameta.allure.Description;
import models.PostPojo;
import org.testng.annotations.Test;
import tests.RestBaseTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This class contains a test case for verifying that the post list is not empty.
 * It extends the RestBaseTest class.
 * The VerifyPostListIsNotEmpty test case uses the post object to retrieve the post list,
 * and asserts that the list is not null and not empty by extracting the ids of the posts.
 * Note: This class uses the TestNG framework for test execution.
 * The @Test annotation marks the method as a test case.
 * The @Description annotation provides a description for the test case.
 * The assertThat method from the AssertJ library is used for assertions.
 */
public class VerifyPostListIsNotEmpty extends RestBaseTest {

    @Description("Verify post list is not empty")
    @Test(description = "Verify post list is not empty")
    public void verifyPostListIsNotEmpty() {
        assertThat(post.getPostList()).extracting(PostPojo::getId).isNotNull().isNotEmpty();
    }
}
