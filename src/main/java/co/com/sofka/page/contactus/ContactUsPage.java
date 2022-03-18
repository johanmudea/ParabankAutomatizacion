package co.com.sofka.page.contactus;

import co.com.sofka.model.contactus.ContactUsModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class ContactUsPage extends CommonActionOnPages {

    public ContactUsPage(WebDriver driver, ContactUsModel contactUsModel) {
        super(driver);
        this.contactUsModel = contactUsModel;
    }

    private static final Logger LOGGER = Logger.getLogger(ContactUsPage.class);
    private ContactUsModel contactUsModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";

    private final By name = By.id("name");
    private final By email = By.id("email");
    private final By phone = By.id("phone");
    private final By message = By.id("message");
    private final By submit = By.xpath("//input[text()='Send to Customer Care']");



    public void fillcontactUsForm() throws InterruptedException {
        scrollOn(name);
        clearOn(name);
        typeOn(name, contactUsModel.getName());

        scrollOn(email);
        clearOn(email);
        typeOn(email, contactUsModel.getEmail());


        scrollOn(phone);
        clearOn(phone);
        typeOn(phone, contactUsModel.getPhone());

        scrollOn(message);
        clearOn(message);
        typeOn(message, contactUsModel.getMessage());


        doSubmit(submit);

    }
        /**
    public List<String> isRegistrationDone(){
        List<String> submitedFormResul = new ArrayList<>();
        submitedFormResul.add(getText(assertionname).trim());
        submitedFormResul.add(getText(assertionGender).trim());
        submitedFormResul.add(getText(assertionMobile).trim());
        return submitedFormResul;
         */
    }



