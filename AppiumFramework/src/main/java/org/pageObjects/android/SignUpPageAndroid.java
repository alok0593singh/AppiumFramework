package org.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;

public class SignUpPageAndroid extends AndroidActions {

    AndroidDriver driver;

    public SignUpPageAndroid(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(accessibility = "input-email")
    private WebElement emailElementSignUp;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement passwordElementSignUp;

    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement confirmPasswordElementSignUp;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"SIGN UP\"]")
    private WebElement signUpButton;

    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement signUpSuccessful;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement signUpOkButton;


    public void enterCredentialSignUp(String email,String password){
        emailElementSignUp.sendKeys(email);
        passwordElementSignUp.sendKeys(password);
        confirmPasswordElementSignUp.sendKeys(password);

    }

    public void clickOnSubmitButton(){
        signUpButton.click();
    }

    public void clickOnSignUpOk(){
        signUpOkButton.click();
    }

    public String getSignUpText(){
        return signUpSuccessful.getAttribute("text");
    }

}
