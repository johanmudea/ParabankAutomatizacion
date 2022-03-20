package co.com.sofka.runner.parabank.register;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"D:/projects/training_sofka/ParabankAutomatizacion/src/test/resources/features/register/Register.feature"},
        glue = "co.com.sofka.stepdefinition.register"
        //tags = "@executable"
)


public class RegisterTestCucumber {
}
