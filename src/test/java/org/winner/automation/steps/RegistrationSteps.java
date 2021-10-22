package org.winner.automation.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.winner.automation.pages.RegistrationPage;


public class RegistrationSteps {

    RegistrationPage registrationPage;

    @Step
    public void isOnRegistrationPage(WebDriver driver){
        registrationPage.open();
        registrationPage.acceptCookies(driver);
    }

    @Step
    public void entersValidEmailAddress() {
        registrationPage.userEntersValidEmailAddress();
    }

    @Step
    public void entersValidPhoneNumber(){
        registrationPage.userEntersValidPhoneNumber();
    }

    @Step
    public void entersValidPassword(){
        registrationPage.userEntersValidPassword();
    }

    @Step
    public void entersConfirmationPassword(){
        registrationPage.userEntersConfirmationPassword();
    }

    @Step
    public void clicksFirstNextButton(){
        registrationPage.userClicksFirstNextButton();
    }

    @Step
    public void clicksSecondNextButton(){
        registrationPage.userClicksSecondNextButton();
    }

    @Step
    public void entersLastName(){
        registrationPage.userEntersLastName();
    }

    @Step
    public void entersFirstName(){
        registrationPage.userEntersFirstName();
    }

    @Step
    public void entersAddress(){
        registrationPage.userEntersAddress();
    }

    @Step
    public void entersValidID(){
        registrationPage.userEntersID();
    }

    @Step
    public void marksCheckBoxes(){
        registrationPage.userChecksTheAgeCheckBox();
        registrationPage.userChecksTheNewsletterCheckBox();
        registrationPage.userChecksTermsAndConditionsCheckBox();
    }

    @Step
    public void verifyThatProperMessageIsDisplayedAfterSuccessfullyRegistration(){
        Assert.assertEquals(registrationPage.successfullyRegistrationMessage(), "Felicitări");
    }

    @Step
    public void waitUntilMessageIsDisplayed(WebDriver driver){
        registrationPage.waitToMessage(driver);
    }
}