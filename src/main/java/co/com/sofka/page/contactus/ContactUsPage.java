package co.com.sofka.page.contactus;

import co.com.sofka.model.contactus.ContactUsModel;
import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
    private final By submit = By.xpath("//table/tbody/tr[5]/td[2]");
    private final By confirmation = By.xpath("//html/body/div/div[3]/div[2]/p[2]");



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

    public Object confirmation(){

        getText(confirmation);


        return null;
    }


}



