package co.com.sofka.page.login;

import co.com.sofka.model.login.LoginModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends CommonActionOnPages {

    public LoginPage(WebDriver driver, LoginModel loginModel) {
        super(driver);
        this.loginModel = loginModel;
    }

    public static final Logger LOGGER = Logger.getLogger(LoginPage.class);
    private LoginModel loginModel;

    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";


    private final By userName = By.name("username");
    private final By password = By.name("password");
    private final By submit = By.xpath("//html/body/div[1]/div[3]/div[1]/div[1]/form/div[3]/input"); // no such element: Unable to locate element: {"method":"link text","selector":"LOG IN"}
    private final By logout = By.xpath("//html/body/div[1]/div[3]/div[2]/div/div/h1");



    public void check() throws InterruptedException{

        scrollOn(submit);
        clickOn(submit);
        doSubmit(submit);

    }


    public void fillLogin() throws InterruptedException {


        scrollOn(userName);
        clearOn(userName);
        typeOn(userName, loginModel.getUserName());

        scrollOn(password);
        clearOn(password);
        typeOn(password, loginModel.getUserName());

        doSubmit(submit);

    }

    public String insert (WebDriver driver){
        WebElement element = driver.findElement(By.xpath("html/body/div[1]/div[3]/div[2]/p"));
        String texto = element.getText().trim();
        return texto;
    }

    public String log (WebDriver driver){
        WebElement element = driver.findElement(By.xpath("//html/body/div[1]/div[3]/div[2]/div/div/h1"));
        String textForm = element.getText().trim();
        return textForm;

    }





}
