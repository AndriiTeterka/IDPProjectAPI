package tests.GraphQL;

import io.qameta.allure.Description;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import tests.GraphQLBaseTest;

import java.util.List;

public class VerifyRickCharactersNameList extends GraphQLBaseTest {

    @Description("Verify Rick characters names contain Rick")
    @Test(description = "Verify Rick characters names contain Rick")
    public void verifyRickCharactersNameList() {
        List<String> names = characters.getRickCharactersNames();
        for (String name : names) {
            Assertions.assertThat(name).contains("Rick");
        }
    }
}
