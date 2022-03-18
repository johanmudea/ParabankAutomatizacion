package co.com.sofka.runner.parabank.contactus;

import co.com.sofka.model.contactus.ContactUsModel;
import co.com.sofka.page.contactus.ContactUsPage;
import co.com.sofka.stepdefinition.setup.WebUI;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ContactUsTest extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(ContactUsTest.class);

    private ContactUsModel contactUsModel;




    @BeforeEach

    public void setUp(){
        try{
            setUpLog4j2();
            setUpWebDriver();
            generalSetUp();

            contactUsModel = new ContactUsModel();

            contactUsModel.setName("1");
            contactUsModel.setEmail("1");
            contactUsModel.setPhone("1");
            contactUsModel.setMessage("1");


        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }



    }


    @Test
    public void contactUsTestMandatoryFields(){
        try{
            //PracticeFormPage practiceFormPage = new PracticeFormPage(driver, practiceFormModel, TEN_SECONDS.getValue());
            ContactUsPage contactUsPage = new ContactUsPage(driver, contactUsModel);

            //practiceFormPage.fillStudentForm();
            contactUsPage.fillcontactUsForm();


            WebElement element = driver.findElement(By.xpath("//html/body/div/div[3]/div[2]/p[2]"));

            String text = element.getText();

            Assertions.assertEquals("A Customer Care Representative will be contacting you.", text);
           // Assert.assertEquals("A Customer Care Representative will be contacting you.", contactUsPage.confirmation());

        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }


    }


    @AfterEach
    public void tearDown(){
       // quiteDriver();

    }

}