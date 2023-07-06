package utils.services.graphQl;

import utils.ConfigProvider;
import utils.services.GraphQLService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static io.restassured.RestAssured.given;

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
