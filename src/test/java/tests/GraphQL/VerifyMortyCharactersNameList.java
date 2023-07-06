package tests.GraphQL;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.GraphQLBaseTest;

import java.util.List;

public class VerifyMortyCharactersNameList extends GraphQLBaseTest {

    @Description("Verify Morty characters names contain Morty")
    @Test(description = "Verify Morty characters names contain Morty")
    public void verifyMortyCharactersNameList() {
        List<String> names = characters.getMortyCharactersNames();
        for (String name : names) {
            Assertions.assertThat(name).contains("Morty");
        }
    }
}
