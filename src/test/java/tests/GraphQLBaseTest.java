package tests;

import org.testng.annotations.BeforeTest;
import utils.services.graphQl.CharactersService;

import java.io.IOException;

public class GraphQLBaseTest {

    public CharactersService characters;

    @BeforeTest
    public void setUpServices() throws IOException {
        characters = new CharactersService();
    }
}
