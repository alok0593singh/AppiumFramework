package org.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;
import org.utils.AppiumUtils;

public class SwipePageAndroid extends AndroidActions {
    AndroidDriver driver;

    public SwipePageAndroid(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"You found me!!!\"]")
    private WebElement scrollTextElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"EXTENDABLE\"]")
    private WebElement swipeToExtendableElement;

    public String getTextAfterScroll() {
        return scrollTextElement.getAttribute("text");
    }

    public void swipeTillEnd() {
        AppiumUtils.scroll(driver, ScrollDirection.UP, 0.75);
    }

    public void swipeTillTop(){
        AppiumUtils.scroll(driver, ScrollDirection.DOWN, 0.75);
    }

    public void swipeToLeft(){
        AppiumUtils.scroll(driver, ScrollDirection.LEFT, 0.75);
    }

    public void swipeToRight(){
        AppiumUtils.scroll(driver, ScrollDirection.RIGHT, 0.75);
    }

//    public String scrollToText(String text) {
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
//        return text;
//    }
}
