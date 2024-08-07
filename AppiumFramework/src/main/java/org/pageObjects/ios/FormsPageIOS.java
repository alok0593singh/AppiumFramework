package org.pageObjects.ios;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.IOSActions;

public class FormsPageIOS extends IOSActions {

    IOSDriver driver;

    public FormsPageIOS(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(accessibility = "text-input")
    private WebElement inputFieldElement;

    @iOSXCUITFindBy(accessibility = "input-text-result")
    private WebElement typedTextElement;

    @iOSXCUITFindBy(accessibility = "switch")
    private WebElement switchElement;

    @iOSXCUITFindBy(accessibility = "switch-text")
    private WebElement switchTextElement;

    @iOSXCUITFindBy(accessibility = "Dropdown")
    private WebElement dropdownElement;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel")
    private WebElement dropdownOption;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[@value=\"webdriver.io is awesome\"]")
    private WebElement dropdownOptionForWdio;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[@value=\"Appium is awesome\"]")
    private WebElement dropdownOptionForAppium;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypePickerWheel[@value=\"This app is awesome\"]")
    private WebElement dropdownOptionForThisApp;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"done_text\"]")
    private WebElement doneButtonForDropDown;

    @iOSXCUITFindBy(accessibility = "text-input")
    private WebElement textAfterSelectDropdownOption;

    @iOSXCUITFindBy(accessibility = "Active")
    private WebElement activeButton;

    @iOSXCUITFindBy(accessibility = "This button is active")
    private WebElement activeButtonText;

    @iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"OK\"]")
    private WebElement okForActiveButton;

    @iOSXCUITFindBy(accessibility = "button-Inactive")
    private WebElement inActiveButton;


    public String enterAndGetText(String text){
        inputFieldElement.clear();
        inputFieldElement.sendKeys(text);
        return typedTextElement.getAttribute("value");
    }


    public String dropdownSelectAndGetOption(String text){
        dropdownElement.click();
        dropdownOption.sendKeys(text);
        String data = dropdownOption.getAttribute("value");
        doneButtonForDropDown.click();
        return data;
    }


    public String clickOnSwitchAndGetText(){
        switchElement.click();
        return switchTextElement.getAttribute("value");
    }

    public String clickOnActiveButtonAndGetText(){
        activeButton.click();
        String status = activeButtonText.getAttribute("value");
        okForActiveButton.click();
        return status;
    }


    public String statusOfInActiveButton() {
        return inActiveButton.getAttribute("accessible");
    }

}
