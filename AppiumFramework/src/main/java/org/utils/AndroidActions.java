package org.utils;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;
import java.util.Arrays;

public class AndroidActions extends AppiumUtils{

    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver)
    {
//        super(driver);
        this.driver = driver;
    }

    public void longPressAction(WebElement ele)
    {
        ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId",((RemoteWebElement)ele).getId(),
                        "duration",2000));
    }


    public void scrollToEndAction()
    {
        boolean canScrollMore;
        do
        {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 3.0

            ));
        }while(canScrollMore);
    }

    public void scrollToEnd(){
        //Get Screen size
        Dimension size = driver.manage().window().getSize();

        //find the position where you need to touch
        int startX = size.getWidth()/2;
        int startY =(int) (size.getHeight()/1.14);

        // position  till you want to move your finger to swipe
        int endX = startX;
        int endY = (int) (size.getHeight()*0.25);

//        System.out.println("x,y for start: "+startX+"-"+startY);
//        System.out.println("x,y for ent: "+endX+"-"+endY);

        // PointerInput class to create a sequence of actions
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");

        Sequence sequence = new Sequence(finger, 1)
                .addAction(finger.createPointerMove(Duration.ofMillis(0),PointerInput.Origin.viewport(),startX,startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(100),PointerInput.Origin.viewport(),endX,endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Arrays.asList(sequence));
//        driver.perform(Arrays.asList(sequence));

    }


    public String scrollToText(String text)
    {

        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));"));
        return text;
    }


    public void swipeAction(WebElement ele,String direction)
    {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement)ele).getId(),

                "direction", direction,
                "percent", 0.75
        ));


    }

}

