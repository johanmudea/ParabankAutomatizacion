package co.com.sofka.stepdefinition.login;

import co.com.sofka.model.login.LoginModel;
import co.com.sofka.page.login.LoginPage;
import co.com.sofka.stepdefinition.setup.WebUI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class LoginStepDefinition extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(LoginStepDefinition.class);

    private LoginModel loginModel;
    private LoginPage loginPage;

    @Given("estoy en el sitio web")
    public void estoyEnElSitioWeb() {

        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();
             loginModel = new LoginModel();


        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }

    }

    @When("click en login sin diligenciar datos de usuario")
    public void clickEnLoginSinDiligenciarDatosDeUsuario() {

        try{

            loginPage = new LoginPage(driver, loginModel);

            loginPage.check();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }

    }

    @Then("envia mensaje de error")
    public void enviaMensajeDeError() {

        Assertions.assertEquals("Please enter a username and password.", loginPage.insert(driver));
        quiteDriver();

    }


//escenario 2

    @Given("el usuario esta en  el sitio web")
    public void elUsuarioEstaEnElSitioWeb() {

        setUpLog4j2();
        setUpWebDriver();
        generalSetUp();

    }
    @When("diligencia sus credenciales correctamente")
    public void diligenciaSusCredencialesCorrectamente() {

        try{

            loginModel = new LoginModel();
            loginModel.setUserName("1");
            loginModel.setPassword("1");
            loginPage = new LoginPage(driver, loginModel);
            loginPage.fillLogin();

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }

    }
    @Then("se muestra log out")
    public void seMuestraLogOut() {

        Assertions.assertEquals("Accounts Overview", loginPage.log(driver));
        quiteDriver();

    }



}
