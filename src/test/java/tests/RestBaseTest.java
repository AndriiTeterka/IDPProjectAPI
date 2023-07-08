package tests;

import org.testng.annotations.BeforeTest;
import utils.services.rest.CommentService;
import utils.services.rest.PostService;
import utils.services.rest.UserService;

/**
 * This class serves as a base test class for REST API tests.
 * It sets up the necessary services and resources required for the tests.
 * The RestBaseTest class initializes UserService, PostService, and CommentService objects to interact with the corresponding REST APIs.
 * In the setUpServices method, the UserService, PostService, and CommentService objects are instantiated and assigned to the user, post, and comment variables, respectively.
 * Note: This class uses the TestNG framework for test execution.
 * The @BeforeTest annotation ensures that the setUpServices method is executed before any test methods.
 */
public class RestBaseTest {

    public UserService user;
    public PostService post;
    public CommentService comment;

    @BeforeTest
    public void setUpServices() {
        user = new UserService();
        post = new PostService();
        comment = new CommentService();
    }
}
