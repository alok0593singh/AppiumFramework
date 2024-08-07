package org.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;

public class LoginPageAndroid extends AndroidActions {

    AndroidDriver driver;

    public LoginPageAndroid(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Sign up\"]")
    private WebElement signUpElement;

    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailElement;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"LOGIN\"]")
    private WebElement loginButton;

    @AndroidFindBy(id = "android:id/message")
    private WebElement loginSuccessfullElement;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement loginOkButton;

    public void enterCredential(String email,String password){
        emailElement.clear();
        emailElement.sendKeys(email);
        passwordElement.clear();
        passwordElement.sendKeys(password);

    }

    public void clickOnLogInButton(){
        loginButton.click();

    }

    public void clickOnLogInOkButton(){
        loginOkButton.click();
    }

    public String getLoginText(){
        return loginSuccessfullElement.getAttribute("text");

    }

    public SignUpPageAndroid signUpOption(){
        signUpElement.click();
        return new SignUpPageAndroid(driver);

    }



}
