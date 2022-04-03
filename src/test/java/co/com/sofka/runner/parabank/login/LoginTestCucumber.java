package co.com.sofka.runner.parabank.login;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"src/test/resources/features/login/Login.feature"},
        glue = "co.com.sofka.stepdefinition.login"
        //tags = "@executable"
)



public class LoginTestCucumber {

}
