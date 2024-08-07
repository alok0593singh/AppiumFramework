package tests.androidTests;

import tests.testUtils.AndroidBaseTest;
import org.pageObjects.android.FormsPageAndroid;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormsPageTest extends AndroidBaseTest {
    FormsPageAndroid wdFormsPage;

    @BeforeMethod
    public void navigateToFormsPage() {
//        wdHomePageAndroid.clickOnLogInPage();
        wdFormsPage = wdHomePageAndroid.clickOnFormsPage();
    }

    @Test(priority = 1)
    public void inputTextAssertion() {
        wdFormsPage.enterDataIntoInputField("Shivendra");
        String typed_text = wdFormsPage.getTypedText();
        Assert.assertEquals(typed_text, "Shivendra");
    }

    @Test(priority = 2)
    public void switchAssertion() {
        wdFormsPage.clickOnSwitch();
        Assert.assertEquals(wdFormsPage.getSwitchText(), "Click to turn the switch OFF");
    }

    @Test(priority = 3)
    public void dropdownAssertion() throws InterruptedException {
        wdFormsPage.clickOnDropdownElement();
        String textAfterSelection = wdFormsPage.clickOnDropdownOption("Appium");
        Assert.assertEquals(textAfterSelection, "Appium is awesome");
    }

    @Test(priority = 4)
    public void activeButtonAssertion() {
        wdFormsPage.clickOnActiveButton();
        String textActiveButton = wdFormsPage.getTextForActiveButton();
        Assert.assertEquals(textActiveButton, "This button is active");
    }

    @Test(priority = 5)
    public void inActiveButtonAssertion() throws InterruptedException {
        Thread.sleep(2000);
        boolean buttonStatus = wdFormsPage.statusOfInActiveButton();
        System.out.println(buttonStatus);
    }
}
