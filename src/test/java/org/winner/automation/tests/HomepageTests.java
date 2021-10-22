package org.winner.automation.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.winner.automation.steps.HomepageSteps;

import java.util.concurrent.TimeUnit;

@RunWith(SerenityRunner.class)
public class HomepageTests {

    @Steps
    HomepageSteps user;

    @Managed(uniqueSession = true)
    WebDriver chromeBrowser;

    @Before
    public void setUp() {
        chromeBrowser.manage().window().maximize();
    }

    @Test
    public void loginFeaturePositiveScenario() {
        user.isOnHomepage(chromeBrowser);
        user.clicksLoginButton();
        user.entersValidEmailAddress();
        user.clicksFirstNextButton();
        user.entersValidPassword();
        user.clicksSecondNextButton();
        chromeBrowser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        user.verifyThatLoginIsSuccessfully();
    }
}