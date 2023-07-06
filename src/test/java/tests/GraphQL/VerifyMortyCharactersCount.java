package tests.GraphQL;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.GraphQLBaseTest;

public class VerifyMortyCharactersCount extends GraphQLBaseTest {

    @Description("Verify Morty characters count")
    @Test(description = "Verify Morty characters count")
    public void verifyMortyCharactersCount() {
        Assertions.assertThat(characters.getMortyCharactersCount()).isEqualTo(68);
    }
}
