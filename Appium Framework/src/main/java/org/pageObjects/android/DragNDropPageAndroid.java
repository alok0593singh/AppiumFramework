package org.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;

public class DragNDropPageAndroid extends AndroidActions {

    AndroidDriver driver;

    public DragNDropPageAndroid(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private By[] dragLocators = {
            By.xpath("//android.view.ViewGroup[@content-desc=\"drag-l1\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drag-l2\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drag-l3\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drag-c1\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drag-c2\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drag-c3\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drag-r1\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drag-r2\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drag-r3\"]")
    };

    private By[] dropLocators = {
            By.xpath("//android.view.ViewGroup[@content-desc=\"drop-l1\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drop-l2\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drop-l3\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drop-c1\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drop-c2\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drop-c3\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drop-r1\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drop-r2\"]"),
            By.xpath("//android.view.ViewGroup[@content-desc=\"drop-r3\"]")
    };

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Congratulations\"]")
    private WebElement puzzleSolvedText;

    public void solveDragNDropPuzzle() {
        for (int i = 0; i < dragLocators.length; i++) {
            WebElement dragElement = driver.findElement(dragLocators[i]);
            WebElement dropElement = driver.findElement(dropLocators[i]);
            dragAndDrop(driver, dragElement, dropElement);
        }
    }

    public String getSolvedPuzzleText() {
        return puzzleSolvedText.getAttribute("text");
    }
}
