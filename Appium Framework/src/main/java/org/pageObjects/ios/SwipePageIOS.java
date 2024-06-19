package org.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AppiumUtils;
import org.utils.IOSActions;

public class SwipePageIOS extends IOSActions {

    IOSDriver driver;

    public SwipePageIOS(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='You found me!!!']")
    private WebElement scrollTextElement;


    public String getTextAfterScroll() {
//        scrollToWebElement(scrollTextElement);
        return scrollTextElement.getAttribute("value");

    }

    public void swipeTillEnd() {
        AppiumUtils.scroll(driver, ScrollDirection.UP, 0.75);
    }

    public void swipeTillTop() {
        AppiumUtils.scroll(driver, ScrollDirection.DOWN, 0.75);
    }

    public void swipeToLeft() {
        AppiumUtils.scroll(driver, ScrollDirection.LEFT, 0.75);
    }

    public void swipeToRight() {
        AppiumUtils.scroll(driver, ScrollDirection.RIGHT, 0.75);
    }

//    public String scrollToText(String text) {
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
//        return text;
//    }

}
