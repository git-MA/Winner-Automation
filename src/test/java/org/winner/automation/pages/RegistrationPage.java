package org.winner.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.winner.automation.utils.ReadExcelData;
import org.winner.automation.utils.TestData;

import java.util.concurrent.TimeUnit;

@DefaultUrl(TestData.REGISTRATION_URL)
public class RegistrationPage extends PageObject {

    // Page Objects
    @FindBy(xpath = "//*[@id=\"Telefon\"]")
    private WebElement phoneNumberTextBox;
    @FindBy(xpath = "//*[@id=\"Email\"]")
    private WebElement emailTextBox;
    @FindBy(xpath = "//*[@id=\"Password\"]")
    private WebElement passwordTextBox;
    @FindBy(xpath = "//*[@id=\"PasswordConfirm\"]")
    private WebElement confirmationPasswordTextBox;
    @FindBy(xpath = "//*[@id=\"Prenume\"]")
    private WebElement lastNameTextBox;
    @FindBy(xpath = "//*[@id=\"Nume\"]")
    private WebElement firstNameTextBox;
    @FindBy(xpath = "//*[@id=\"address\"]")
    private WebElement addressTextBox;
    @FindBy(xpath = "//*[@id=\"CNP\"]")
    private WebElement idTextBox;
    @FindBy(xpath = "//*[@id=\"registerWizard\"]/div/div[2]/div/div[1]/div[6]")
    private WebElement ageCheckBox;
    @FindBy(xpath = "//*[@id=\"registerWizard\"]/div/div[2]/div/div[1]/div[7]")
    private WebElement newsletterCheckBox;
    @FindBy(xpath = "//*[@id=\"registerWizard\"]/div/div[2]/div/div[1]/div[8]")
    private WebElement termsAndConditionsCheckBox;
    @FindBy(xpath = "//*[@id=\"registerWizard\"]/div/div[1]/div/div[2]/button")
    private WebElement nextButton1;
    @FindBy(xpath = "//*[@id=\"registerWizard\"]/div/div[2]/div/div[2]/button/span[2]")
    private WebElement nextButton2;
    @FindBy(xpath = "//*[@id=\"MainContent\"]/div[2]/div/div[2]/div[1]/div")
    private WebElement successfullyRegistrationMessage;
    @FindBy(xpath = "//*[@id=\"cookieAgreement\"]/div/div/div[2]/button")
    private WebElement acceptCookiesButton;

    // Methods for Page Objects

    // rowNumber is a variable which can be set according to the Excel row
    // from where you want to take data
    // example: for rowNumber = 4, it will take data from fourth row
    int rowNumber = 4;

    public void userEntersValidPhoneNumber() {
        phoneNumberTextBox.sendKeys(TestData.VALID_PHONE_NUMBER);
    }

    public void userEntersValidEmailAddress() {
        emailTextBox.sendKeys(ReadExcelData.receiveCellData(4, rowNumber));
    }

    public void userEntersValidPassword() {
        passwordTextBox.sendKeys(ReadExcelData.receiveCellData(5, rowNumber));
    }

    public void userEntersConfirmationPassword() {
        confirmationPasswordTextBox.sendKeys(ReadExcelData.receiveCellData(5, rowNumber));
    }

    public void userEntersLastName() {
        lastNameTextBox.sendKeys(ReadExcelData.receiveCellData(2, rowNumber));
    }

    public void userEntersFirstName() {
        firstNameTextBox.sendKeys(ReadExcelData.receiveCellData(1, rowNumber));
    }

    public void userEntersAddress() {
        addressTextBox.sendKeys(ReadExcelData.receiveCellData(6, rowNumber));
    }

    public void userEntersID() {
        idTextBox.sendKeys(ReadExcelData.receiveCellData(3, rowNumber));
    }

    public void userClicksFirstNextButton() {
        nextButton1.click();
    }

    public void userClicksSecondNextButton() {
        nextButton2.click();
    }

    public void userChecksTheAgeCheckBox() {
        ageCheckBox.click();
    }

    public void userChecksTheNewsletterCheckBox() {
        newsletterCheckBox.click();
    }

    public void userChecksTermsAndConditionsCheckBox() {
        termsAndConditionsCheckBox.click();
    }

    public String successfullyRegistrationMessage() {
        if(successfullyRegistrationMessage.isDisplayed()){
            return successfullyRegistrationMessage.getText();
        } else
            return "MESSAGE NOT DISPLAYED";
    }

    public void acceptCookies(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        if (acceptCookiesButton.isDisplayed()) {
            acceptCookiesButton.click();
        }
    }

    public void waitToMessage(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.textToBePresentInElement(successfullyRegistrationMessage,"Felicitări"));
    }
}