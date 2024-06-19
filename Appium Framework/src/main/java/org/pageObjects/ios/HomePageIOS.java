package org.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.IOSActions;

public class HomePageIOS extends IOSActions {

    IOSDriver driver;

    public HomePageIOS(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @iOSXCUITFindBy(accessibility = "Login")
    private WebElement loginElement;

    @iOSXCUITFindBy(accessibility = "Forms")
    private WebElement formsElement;

    @iOSXCUITFindBy(accessibility = "Swipe")
    private WebElement swipeElement;

    @iOSXCUITFindBy(accessibility = "Drag")
    private WebElement dragElement;

    public LoginPageIOS clickOnLogInPage() {
        loginElement.click();
        return new LoginPageIOS(driver);
    }

    public FormsPageIOS clickOnFormsPage(){
        formsElement.click();
        return new FormsPageIOS(driver);
    }

    public SwipePageIOS clickOnSwipePage(){
        swipeElement.click();
        return new SwipePageIOS(driver);
    }

    public DragNDropPageIOS clickOnDragNDropPage(){
        dragElement.click();
        return new DragNDropPageIOS(driver);
    }
}
