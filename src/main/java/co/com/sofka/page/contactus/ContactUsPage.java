package co.com.sofka.page.contactus;

import co.com.sofka.model.contactus.ContactUsModel;
import co.com.sofka.page.common.BaseSikulix;
import co.com.sofka.page.common.CommonActionOnPages;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class ContactUsPage extends CommonActionOnPages {

    public ContactUsPage(WebDriver driver, ContactUsModel contactUsModel) {
        super(driver);
        this.contactUsModel = contactUsModel;
    }

    private static final Logger LOGGER = Logger.getLogger(ContactUsPage.class);
    private ContactUsModel contactUsModel;
    private static final String MODEL_NULL_MESSAGE = "El modelo del formulario es nulo.";


    private final By contacto = By.linkText("Contact Us");
    private final By name = By.id("name");
    private final By email = By.id("email");
    private final By phone = By.id("phone");
    private final By message = By.id("message");
    private final By submit = By.xpath("//table/tbody/tr[5]/td[2]");
    private final By confirmation = By.xpath("//html/body/div/div[3]/div[2]/p[2]");

    private final By emailError = By.id("email.errors");





    public void fillcontactUsForm() throws InterruptedException {


        scrollOn(contacto);
        clickOn(contacto);

        scrollOn(name);
        clearOn(name);
        typeOn(name, contactUsModel.getName());

        scrollOn(email);
        clearOn(email);
        if (contactUsModel.getEmail() != null ){

            typeOn(email, contactUsModel.getEmail());

        } else{
            typeOn(email, "");

        }


        scrollOn(phone);
        clearOn(phone);
        typeOn(phone, contactUsModel.getPhone());

        scrollOn(message);
        clearOn(message);
        typeOn(message, contactUsModel.getMessage());


        doSubmit(submit);

    }



    public String confirmation(WebDriver driver){
        WebElement element = driver.findElement(By.xpath("//html/body/div/div[3]/div[2]/p[2]"));
        String text = element.getText().trim();
                return text;

    }

    public String emailError(WebDriver driver){
        WebElement element = driver.findElement(By.id("email.errors"));
        String text = element.getText().trim();
        return text;

    }


}



