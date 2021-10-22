package org.winner.automation.steps;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.winner.automation.pages.HomepagePage;
import org.winner.automation.pages.RegistrationPage;


public class HomepageSteps {

    HomepagePage homepagePage;
    RegistrationPage registrationPage;

    @Step
    public void isOnHomepage(WebDriver driver){
        homepagePage.open();
        registrationPage.acceptCookies(driver);
    }

    @Step
    public void clicksLoginButton(){
        homepagePage.userClickLoginButton();
    }

    @Step
    public void entersValidEmailAddress(){
        homepagePage.userEnterValidEmailAddress();
    }

    @Step
    public void entersValidPassword(){
        homepagePage.userEnterValidPassword();
    }

    @Step
    public void clicksFirstNextButton(){
        homepagePage.userClickFirstNextButton();
    }

    @Step
    public void clicksSecondNextButton(){
        homepagePage.userClickSecondNextButton();
    }

    @Step
    public void verifyThatLoginIsSuccessfully(){
        Assert.assertEquals(homepagePage.userCheckAccountBalanceIsDisplayed(), true);
    }
}