package tests.GraphQL;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.GraphQLBaseTest;

public class VerifyRickCharactersCount extends GraphQLBaseTest {

    @Description("Verify Rick characters count")
    @Test(description = "Verify Rick characters count")
    public void verifyRickCharactersCount() {
        Assertions.assertThat(characters.getRickCharactersCount()).isEqualTo(107);
    }
}
