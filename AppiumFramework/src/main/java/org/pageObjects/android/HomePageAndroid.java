package org.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;

public class HomePageAndroid extends AndroidActions {

    AndroidDriver driver;

    public HomePageAndroid(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Login\"]")
    private WebElement loginElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Forms\"]")
    private WebElement formsElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Swipe\"]")
    private WebElement swipeElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Drag\"]")
    private WebElement dragElement;

    public LoginPageAndroid clickOnLogInPage() {
        loginElement.click();
        return new LoginPageAndroid(driver);
    }

    public FormsPageAndroid clickOnFormsPage(){
        formsElement.click();
        return new FormsPageAndroid(driver);
    }

    public SwipePageAndroid clickOnSwipePage(){
        swipeElement.click();
        return new SwipePageAndroid(driver);
    }

    public DragNDropPageAndroid clickOnDragNDropPage(){
        dragElement.click();
        return new DragNDropPageAndroid(driver);
    }



}
