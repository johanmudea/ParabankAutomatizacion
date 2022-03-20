package co.com.sofka.stepdefinition.register;


import co.com.sofka.model.contactus.ContactUsModel;
import co.com.sofka.model.register.RegisterModel;
import co.com.sofka.page.contactus.ContactUsPage;
import co.com.sofka.page.register.RegisterPage;
import co.com.sofka.runner.parabank.contactus.ContactUsTest;
import co.com.sofka.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;


public class RegisterStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(RegisterStepDefinition.class);


    private RegisterModel registerModel;
    private RegisterPage registerPage;




    // primero escenario verificación

    @Given("el administrador esta en el sitio web")
    public void elAdministradorEstaEnElSitioWeb() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
            registerModel = new RegisterModel();


        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }




    }
    @When("Click en link de register")
    public void clickEnLinkDeRegister() {

        try{

            registerPage = new RegisterPage(driver, registerModel);

            registerPage.customerFormIn();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }

    }
    @Then("Se muestra la pagina de registro")
    public void seMuestraLaPaginaDeRegistro() {

        Assertions.assertEquals("Signing up is easy!", registerPage.inConfirmation(driver));
        quiteDriver();

    }

    //segundo escenario registro

    @Given("Usuario esta en la pagina de registro")
    public void usuarioEstaEnLaPaginaDeRegistro() {
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();



        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }


    }
    @When("dilgencia la informacion")
    public void dilgenciaLaInformacion() {

        try{

            registerModel = new RegisterModel();


            registerModel.setFirstName("1");
            registerModel.setLastName("1");
            registerModel.setAddress("1");
            registerModel.setCity("1");
            registerModel.setState("1");
            registerModel.setZipCode("1");
            registerModel.setPhoneNumber("1");
            registerModel.setSsn("1");

            registerModel.setUserName("juan");
            registerModel.setPassword("1");
            registerModel.setConfirm("1");


            registerPage = new RegisterPage(driver, registerModel);

            registerPage.fillRegisterForm();


        } catch (Exception exception){
            //quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }


    }
    @Then("Se muestra confirmacion de registro")
    public void seMuestraConfirmacionDeRegistro() {

        Assertions.assertEquals("Your account was created successfully. You are now logged in.", registerPage.customerForm(driver));
        quiteDriver();

    }
}
