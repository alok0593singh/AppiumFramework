package org.pageObjects.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;

public class FormsPageAndroid extends AndroidActions {

    AndroidDriver driver;

    public FormsPageAndroid(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(accessibility = "text-input")
    private WebElement inputFieldElement;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"input-text-result\"]")
    private WebElement typedTextElement;

    @AndroidFindBy(accessibility = "switch")
    private WebElement switchElement;

    @AndroidFindBy(accessibility = "switch-text")
    private WebElement switchTextElement;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"text_input\"]")
    private WebElement dropdownElement;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"webdriver.io is awesome\"]")
    private WebElement dropdownOptionForWdio;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"Appium is awesome\"]")
    private WebElement dropdownOptionForAppium;

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text=\"This app is awesome\"]")
    private WebElement dropdownOptionForThisApp;

    @AndroidFindBy(xpath = "//android.widget.EditText[@resource-id=\"text_input\"]")
    private WebElement textAfterSelectDropdownOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"Active\"]")
    private WebElement activeButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@resource-id=\"android:id/message\"]")
    private WebElement activeButtonText;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement okForActiveButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc=\"button-Inactive\"]")
    private WebElement inActiveButton;


    public void enterDataIntoInputField(String inputText){
//        inputFieldElement.click();
        inputFieldElement.clear();
        inputFieldElement.sendKeys(inputText);
    }

    public String getTypedText(){
        return typedTextElement.getAttribute("text");
    }

    public void clickOnDropdownElement(){
        dropdownElement.click();
    }

    public String clickOnDropdownOption(String option) {
        if (option.equalsIgnoreCase("Appium")) {
            dropdownOptionForAppium.click();
        } else if (option.equalsIgnoreCase("Webdriver")) {
            dropdownOptionForWdio.click();
        } else if (option.equalsIgnoreCase("This")) {
            dropdownOptionForThisApp.click();
        } else {
            System.out.println("Option not recognized");
        }

        return textAfterSelectDropdownOption.getAttribute("text");
    }


    public void clickOnSwitch(){
        switchElement.click();
    }

    public String getSwitchText(){
        return switchTextElement.getText();
    }


    public void clickOnActiveButton(){
        activeButton.click();
    }

    public String getTextForActiveButton(){
        String status = activeButtonText.getAttribute("text");
        okForActiveButton.click();

        return status;

    }

    public boolean statusOfInActiveButton() {


        return inActiveButton.isEnabled();
    }




}
