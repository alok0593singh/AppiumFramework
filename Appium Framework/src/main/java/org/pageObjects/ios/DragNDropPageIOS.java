package org.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.IOSActions;

public class DragNDropPageIOS extends IOSActions {

    IOSDriver driver;

    public DragNDropPageIOS(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    private By[] dragLocators = {
            By.xpath("//XCUIElementTypeOther[@name='drag-l1']"),
            By.xpath("//XCUIElementTypeOther[@name='drag-l2']"),
            By.xpath("//XCUIElementTypeOther[@name='drag-l3']"),
            By.xpath("//XCUIElementTypeOther[@name='drag-c1']"),
            By.xpath("//XCUIElementTypeOther[@name='drag-c2']"),
            By.xpath("//XCUIElementTypeOther[@name='drag-c3']"),
            By.xpath("//XCUIElementTypeOther[@name='drag-r1']"),
            By.xpath("//XCUIElementTypeOther[@name='drag-r2']"),
            By.xpath("//XCUIElementTypeOther[@name='drag-r3']")
    };

    private By[] dropLocators = {
            By.xpath("//XCUIElementTypeOther[@name='drop-l1']"),
            By.xpath("//XCUIElementTypeOther[@name='drop-l2']"),
            By.xpath("//XCUIElementTypeOther[@name='drop-l3']"),
            By.xpath("//XCUIElementTypeOther[@name='drop-c1']"),
            By.xpath("//XCUIElementTypeOther[@name='drop-c2']"),
            By.xpath("//XCUIElementTypeOther[@name='drop-c3']"),
            By.xpath("//XCUIElementTypeOther[@name='drop-r1']"),
            By.xpath("//XCUIElementTypeOther[@name='drop-r2']"),
            By.xpath("//XCUIElementTypeOther[@name='drop-r3']")
    };

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Congratulations']")
    private WebElement puzzleSolvedText;

    public String solveDragNDropPuzzle() {
        for (int i = 0; i < dragLocators.length; i++) {
            WebElement dragElement = driver.findElement(dragLocators[i]);
            WebElement dropElement = driver.findElement(dropLocators[i]);
            dragAndDrop(driver, dragElement, dropElement);
        }

        return puzzleSolvedText.getAttribute("label");

    }

    public String getSolvedPuzzleText() {
        return puzzleSolvedText.getAttribute("label");
    }
}
