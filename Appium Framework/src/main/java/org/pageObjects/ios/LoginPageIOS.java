package org.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.IOSActions;

public class LoginPageIOS extends IOSActions {

    IOSDriver driver;

    public LoginPageIOS(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Sign up\"]")
    private WebElement signUpElement;

    @iOSXCUITFindBy(accessibility = "input-email")
    private WebElement emailElement;

    @iOSXCUITFindBy(accessibility = "input-password")
    private WebElement passwordElement;

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`name == \"LOGIN\"`]")
    private WebElement loginButton;

    @iOSXCUITFindBy(accessibility = "You are logged in!")
    private WebElement loginSuccessfullElement;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement loginOkButton;


    public String enterCredentialAndGetText(String email,String password){
        emailElement.clear();
        emailElement.sendKeys(email);
        passwordElement.clear();
        passwordElement.sendKeys(password);
        loginButton.click();
        String data =  loginSuccessfullElement.getAttribute("value");
        loginOkButton.click();
        return data;

    }

    public void clickOnLogInButton(){
        loginButton.click();

    }

    public void clickOnLogInOkButton(){
        loginOkButton.click();
    }

    public String getLoginText(){
        return loginSuccessfullElement.getAttribute("value");

    }

    public SignUpPageIOS signUpOption(){
        signUpElement.click();
        return new SignUpPageIOS(driver);

    }


}
