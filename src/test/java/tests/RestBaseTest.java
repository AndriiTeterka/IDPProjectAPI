package tests;

import org.testng.annotations.BeforeTest;
import utils.services.rest.CommentService;
import utils.services.rest.PostService;
import utils.services.rest.UserService;

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
