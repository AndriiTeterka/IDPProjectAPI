package utils.services.graphQl;

import utils.ConfigProvider;
import utils.services.GraphQLService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static io.restassured.RestAssured.given;

/**
 * This class provides methods to interact with the GraphQL characters service.
 * It extends the GraphQLService class.
 * The CharactersService class is responsible for sending GraphQL requests related to characters.
 * It has methods to retrieve the names and counts of all characters, Morty characters, and Rick characters.
 * Note: This class uses the ConfigProvider class to retrieve the file path for the Rick and Morty characters request.
 * The GraphQLService class provides the base functionality for sending GraphQL requests.
 * The REQUEST_SPECIFICATION is inherited from the GraphQLService class and is used for request specification.
 */
public class CharactersService extends GraphQLService {

    String rickAndMortyRequest = new String(Files.readAllBytes(Paths.get(ConfigProvider.RICK_AND_MORTY_CHARACTERS_FILE_PATH)));


    public CharactersService() throws IOException {
    }

    @Override
    public String getBasePath() {
        return "/graphql";
    }

    public List<String> getAllCharactersNames() {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(rickAndMortyRequest.replace("{name}", ""))
                .post()
                .then()
                .extract().jsonPath().getList("data.characters.results.name");
    }

    public int getAllCharactersCount() {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(rickAndMortyRequest.replace("{name}", ""))
                .post()
                .then()
                .extract().jsonPath().getInt("data.characters.info.count");
    }

    public List<String> getMortyCharactersNames() {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(rickAndMortyRequest.replace("{name}", "Morty"))
                .post()
                .then()
                .extract().jsonPath().getList("data.characters.results.name");
    }

    public int getMortyCharactersCount() {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(rickAndMortyRequest.replace("{name}", "Morty"))
                .post()
                .then()
                .extract().jsonPath().getInt("data.characters.info.count");
    }

    public List<String> getRickCharactersNames() {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(rickAndMortyRequest.replace("{name}", "Rick"))
                .post()
                .then()
                .extract().jsonPath().getList("data.characters.results.name");
    }

    public int getRickCharactersCount() {
        return given()
                .spec(REQUEST_SPECIFICATION)
                .body(rickAndMortyRequest.replace("{name}", "Rick"))
                .post()
                .then()
                .extract().jsonPath().getInt("data.characters.info.count");
    }
}
