package co.com.sofka.runner.parabank.contactus;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;




@RunWith(Cucumber.class)

@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = {"D:/projects/training_sofka/ParabankAutomatizacion/src/test/resources/features/contactus/ContactUs.feature"},
        glue = "co.com.sofka.stepdefinition.contactus"
        //tags = "@executable"
)


public class ContactUsTestCucumber {

}
