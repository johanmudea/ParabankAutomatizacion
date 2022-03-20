package co.com.sofka.stepdefinition.contactus;


import co.com.sofka.model.contactus.ContactUsModel;
import co.com.sofka.page.contactus.ContactUsPage;
import co.com.sofka.runner.parabank.contactus.ContactUsTest;
import co.com.sofka.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

import static co.com.sofka.page.contactus.ContactUsPage.LOGGER;

public class ContactUsStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(ContactUsStepDefinition.class);

    private ContactUsModel contactUsModel;
    private ContactUsPage contactUsPage;


    @Given(": El cliente esta en el sitio web de contacto")
    public void elClienteEstaEnElSitioWebDeContacto() {

        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            contactUsModel = new ContactUsModel();


        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }

    }
    @When("El cliente ingresa sus credenciales.")
    public void elClienteIngresaSusCredenciales() {

        try{

            contactUsModel.setName("1");
            contactUsModel.setEmail("1");
            contactUsModel.setPhone("1");
            contactUsModel.setMessage("1");


            contactUsPage = new ContactUsPage(driver, contactUsModel);

            contactUsPage.fillcontactUsForm();


        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }

    }
    @Then("debe enviarme mensaje de comfirmacion.")
    public void debeEnviarmeMensajeDeComfirmacion() {

        Assertions.assertEquals("A Customer Care Representative will be contacting you.", contactUsPage.confirmation(driver));
        quiteDriver();

    }

    //Segundo caso de prueba.

    @When("El cliente no diligencia el Email")
    public void elClienteNoDiligenciaElEmail() {

        try{

            contactUsModel.setName("1");
            //contactUsModel.setEmail("1");
            contactUsModel.setPhone("1");
            contactUsModel.setMessage("1");

            contactUsPage = new ContactUsPage(driver, contactUsModel);

            contactUsPage.fillcontactUsForm();

            //WebElement element = driver.findElement(By.xpath("//html/body/div/div[3]/div[2]/p[2]"));
            //String text = element.getText();
            // Assertions.assertEquals("A Customer Care Representative will be contacting you.", contactUsPage.confirmation(driver));

            //Assertions.assertEquals("Email is required.", contactUsPage.emailError(driver));

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }

    }
    @Then("debe mostrar mensaje de error Email is required.")
    public void debeMostrarMensajeDeErrorEmailIsRequired() {

        Assertions.assertEquals("Email is required.", contactUsPage.emailError(driver));
        quiteDriver();

    }



}
