package co.com.sofka.runner.parabank.contactus;

import co.com.sofka.model.contactus.ContactUsModel;
import co.com.sofka.stepdefinition.setup.WebUI;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

            contactUsModel.setName("");
            contactUsModel.setEmail("");
            contactUsModel.setPhone("");
            contactUsModel.setMessage("");


        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }



    }


    @Test
    public void contactUsTestMandatoryFields(){
        try{


        } catch (Exception exception){
            quiteDriver();
            Assertions.fail(exception.getMessage(), exception);
            LOGGER.error(exception.getMessage(), exception);
        }
    }


    @AfterEach
    public void tearDown(){
        quiteDriver();

    }

}