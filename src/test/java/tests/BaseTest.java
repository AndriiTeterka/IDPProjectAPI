package tests;

import org.testng.annotations.BeforeTest;
import utils.services.PostService;
import utils.services.UserService;

public class BaseTest {

    public UserService user;
    public PostService post;

    @BeforeTest
    public void setUpServices() {
        user = new UserService();
        post = new PostService();
    }
}
