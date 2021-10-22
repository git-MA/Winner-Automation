package org.winner.automation.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.winner.automation.steps.RegistrationSteps;

@RunWith(SerenityRunner.class)
public class RegistrationTests {

    @Steps
    RegistrationSteps user;

    @Managed(uniqueSession = true)
    WebDriver chromeDriver;

    @Before
    public void setUp() {
        chromeDriver.manage().window().maximize();
    }

    @Test
    public void registrationFeaturePositiveScenario() {
        user.isOnRegistrationPage(chromeDriver);
        user.entersValidPhoneNumber();
        user.entersValidEmailAddress();
        user.entersValidPassword();
        user.entersConfirmationPassword();
        user.clicksFirstNextButton();
        user.entersLastName();
        user.entersFirstName();
        user.entersAddress();
        user.entersValidID();
        user.marksCheckBoxes();
        user.clicksSecondNextButton();
        user.waitUntilMessageIsDisplayed(chromeDriver);
        user.verifyThatProperMessageIsDisplayedAfterSuccessfullyRegistration();
    }
}