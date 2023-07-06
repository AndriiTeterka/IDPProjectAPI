package tests.GraphQL;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.GraphQLBaseTest;

public class VerifyAllCharactersCount extends GraphQLBaseTest {

    @Description("Verify all characters count")
    @Test(description = "Verify all characters count")
    public void verifyAllCharactersCount() {
        Assertions.assertThat(characters.getAllCharactersCount()).isEqualTo(826);
    }
}
