package org.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utils.IOSActions;

import java.time.Duration;

public class SignUpPageIOS extends IOSActions {

    IOSDriver driver;

    public SignUpPageIOS(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "input-email")
    private WebElement emailElementSignUp;

    @iOSXCUITFindBy(accessibility = "input-password")
    private WebElement passwordElementSignUp;

    @iOSXCUITFindBy(accessibility = "input-repeat-password")
    private WebElement confirmPasswordElementSignUp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='SIGN UP']")
    private WebElement signUpButton;

    @iOSXCUITFindBy(accessibility = "You successfully signed up!")
    private WebElement signUpSuccessful;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement signUpOkButton;

    public void enterCredentialSignUp(String email, String password) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(emailElementSignUp)).sendKeys(email);
        emailElementSignUp.clear();
        emailElementSignUp.sendKeys(email);
        passwordElementSignUp.sendKeys(password);
        confirmPasswordElementSignUp.sendKeys(password);
    }

    public void clickOnSubmitButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }

    public void clickOnSignUpOk() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signUpOkButton)).click();
    }

    public String getSignUpText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(signUpSuccessful)).getAttribute("label");
    }
}
