package co.com.sofka.page.register;

import co.com.sofka.model.register.RegisterModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends CommonActionOnPages {

    public RegisterPage(WebDriver driver, RegisterModel registerModel) {
        super(driver);
        pageFactoryInitElement(driver, this);
        this.registerModel = registerModel;
    }

    public static final Logger LOGGER = Logger.getLogger(RegisterPage.class);
    private RegisterModel registerModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    //Localizadores

    @CacheLookup
    @FindBy(linkText = "Register")
    private WebElement registro;

    @CacheLookup
    @FindBy(id = "customer.firstName")
    private WebElement firstName;

    @CacheLookup
    @FindBy(id = "customer.lastName")
    private WebElement lastName;

    @CacheLookup
    @FindBy(id = "customer.address.street")
    private WebElement address;

    @CacheLookup
    @FindBy(id = "customer.address.city")
    private WebElement city;

    @CacheLookup
    @FindBy(id = "customer.address.state")
    private WebElement state;

    @CacheLookup
    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCode;

    @CacheLookup
    @FindBy(id ="customer.phoneNumber")
    private  WebElement phoneNumber;

    @CacheLookup
    @FindBy(id ="customer.ssn")
    private  WebElement ssn;

    @CacheLookup
    @FindBy(id ="customer.username")
    private  WebElement userName;

    @CacheLookup
    @FindBy(id ="customer.password")
    private  WebElement password;

    @CacheLookup
    @FindBy(id ="repeatedPassword")
    private  WebElement confirm;

    @CacheLookup
    @FindBy(xpath = "//table/tbody/tr[13]/td[2]/input")
    private  WebElement submit;


    public void customerFormIn() throws InterruptedException{

        scrollOn(registro);
        clickOn(registro);

    }
    public void fillRegisterForm() throws InterruptedException {


        scrollOn(registro);
        clickOn(registro);

        scrollOn(firstName);
        clearOn(firstName);
        typeOn(firstName, registerModel.getFirstName());

        scrollOn(lastName);
        clearOn(lastName);
        typeOn(lastName, registerModel.getLastName());

        scrollOn(address);
        clearOn(address);
        typeOn(address, registerModel.getAddress());


        scrollOn(city);
        clearOn(city);
        typeOn(city, registerModel.getCity());

        scrollOn(state);
        clearOn(state);
        typeOn(state, registerModel.getState());

        scrollOn(zipCode);
        clearOn(zipCode);
        typeOn(zipCode, registerModel.getZipCode());

        scrollOn(phoneNumber);
        clearOn(phoneNumber);
        typeOn(phoneNumber, registerModel.getPhoneNumber());


        scrollOn(ssn);
        clearOn(ssn);
        typeOn(ssn, registerModel.getSsn());

        scrollOn(userName);
        clearOn(userName);
        typeOn(userName, registerModel.getUserName());

        scrollOn(password);
        clearOn(password);
        typeOn(password, registerModel.getPassword());

        scrollOn(confirm);
        clearOn(confirm);
        typeOn(confirm, registerModel.getConfirm());

        doSubmit(submit);


    }

    public String customerForm(WebDriver driver){
        WebElement element = driver.findElement(By.xpath("//html/body/div[1]/div[3]/div[2]/p"));
        String textForm = element.getText().trim();
        return textForm;

    }

    public String inConfirmation(WebDriver driver){
        WebElement element = driver.findElement(By.xpath("//html/body/div[1]/div[3]/div[2]/h1"));
        String textConfirmation = element.getText().trim();
        return textConfirmation;

    }

}
