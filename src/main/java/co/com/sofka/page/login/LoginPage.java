package co.com.sofka.page.login;

import co.com.sofka.model.login.LoginModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends CommonActionOnPages {

    public LoginPage(WebDriver driver, LoginModel loginModel) {
        super(driver);
        pageFactoryInitElement(driver,this);
        this.loginModel = loginModel;
    }

    public static final Logger LOGGER = Logger.getLogger(LoginPage.class);
    private LoginModel loginModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    //Localizadores con WebElement.

    @CacheLookup
    @FindBy(name ="username")
    private  WebElement username;

    @CacheLookup
    @FindBy(name ="password")
    private  WebElement password;


    @FindBy(xpath = "//html/body/div[1]/div[3]/div[1]/div[1]/form/div[3]/input")
    private  WebElement submit;


    @FindBy(xpath = "//html/body/div[1]/div[3]/div[2]/div/div/h1")
    private  WebElement logout;

    public void check() throws InterruptedException{

        scrollOn(submit);
        clickOn(submit);
        doSubmit(submit);

    }

    public void fillLogin() throws InterruptedException {

        scrollOn(username);
        clearOn(username);
        typeOn(username, loginModel.getUserName());

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
