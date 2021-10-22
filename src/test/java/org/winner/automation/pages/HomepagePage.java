package org.winner.automation.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.WebElement;
import org.winner.automation.utils.TestData;

@DefaultUrl(TestData.BASE_URL)
public class HomepagePage extends PageObject {

    // Page objects
    @FindBy(xpath = "//*[@id=\"headerSticky\"]/div[1]/div[1]/div[5]/div[2]/button/span")
    private WebElement loginButton;
    @FindBy(xpath = "//*[@id=\"headerSticky\"]/div[1]/div[1]/div[5]/div[1]/div[2]/div[2]/span")
    private WebElement accountBalance;
    @FindBy(xpath = "//*[@id=\"lf_username\"]")
    private WebElement emailTextField;
    @FindBy(xpath = "//*[@id=\"lf_password\"]")
    private WebElement passwordTextField;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[5]/div[1]/div/div/div[2]/div/div/div[1]/div/div[4]/button")
    private WebElement firstNextButton;
    @FindBy(xpath = "//*[@id=\"root\"]/div/div[5]/div[1]/div/div/div[2]/div/div/div[2]/div/div[4]/button")
    private WebElement secondNextButton;

    // Methods for page objects
    public void userClickLoginButton(){
        loginButton.click();
    }

    public boolean userCheckAccountBalanceIsDisplayed(){
        return accountBalance.isDisplayed();
    }

    public void userEnterValidEmailAddress(){
        emailTextField.sendKeys(TestData.EMAIL_FOR_FLORIN_ACCOUNT);
    }

    public void userEnterValidPassword(){
        passwordTextField.sendKeys(TestData.PASSWORD_FOR_FLORIN_ACCOUNT);
    }

    public void userClickFirstNextButton(){
        firstNextButton.click();
    }

    public void userClickSecondNextButton(){
        secondNextButton.click();
    }
}