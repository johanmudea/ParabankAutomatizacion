package co.com.sofka.page.register;

import co.com.sofka.model.contactus.ContactUsModel;
import co.com.sofka.model.register.RegisterModel;
import co.com.sofka.page.common.CommonActionOnPages;
import co.com.sofka.page.contactus.ContactUsPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends CommonActionOnPages {

    public RegisterPage(WebDriver driver, RegisterModel registerModel) {
        super(driver);
        this.registerModel = registerModel;
    }

    public static final Logger LOGGER = Logger.getLogger(RegisterPage.class);
    private RegisterModel registerModel;

    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";


    private final By registro = By.linkText("Register");


    private final By firstName = By.id("customer.firstName");
    private final By lastName = By.id("customer.lastName");
    private final By address = By.id("customer.address.street");
    private final By city = By.id("customer.address.city");
    private final By state = By.id("customer.address.state");
    private final By zipCode = By.id("customer.address.zipCode");
    private final By phoneNumber = By.id("customer.phoneNumber");
    private final By ssn = By.id("customer.ssn");
    private final By userName = By.id("customer.username");
    private final By password = By.id("customer.password");
    private final By confirm = By.id("repeatedPassword");

    private final By customerForm = By.xpath("//html/body/div[1]/div[3]/div[2]/p");

    private final By inConfirmation = By.xpath("//html/body/div[1]/div[3]/div[2]/p");

    private final By submit = By.xpath("//table/tbody/tr[13]/td[2]/input");



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
