package tests;

import org.testng.annotations.BeforeTest;
import utils.services.graphQl.CharactersService;

import java.io.IOException;

/**
 * This class serves as a base test class for GraphQL tests.
 * It sets up the necessary services and resources required for the tests.
 * The GraphQLBaseTest class initializes a CharactersService object to interact with the GraphQL characters service.
 * In the setUpServices method, the CharactersService object is instantiated and assigned to the characters variable.
 * Note: This class uses the TestNG framework for test execution.
 * The @BeforeTest annotation ensures that the setUpServices method is executed before any test methods.
 * The IOException is thrown if there is an error initializing the CharactersService object.
 */
public class GraphQLBaseTest {

    public CharactersService characters;

    @BeforeTest
    public void setUpServices() throws IOException {
        characters = new CharactersService();
    }
}
