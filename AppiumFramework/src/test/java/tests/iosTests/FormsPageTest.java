package tests.iosTests;

import tests.testUtils.IOSBaseTest;
import org.pageObjects.ios.FormsPageIOS;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FormsPageTest extends IOSBaseTest {
    FormsPageIOS wdFormsPage;

    @BeforeMethod
    public void navigateToFormsPage() {
        wdFormsPage = wdHomePageIOS.clickOnFormsPage();
    }

    @Test
    public void inputTextAssertion() {
        String typed_text = wdFormsPage.enterAndGetText("Shivendra");
        Assert.assertEquals(typed_text, "Shivendra");
    }

    @Test
    public void switchAssertion() {
        String text = wdFormsPage.clickOnSwitchAndGetText();
        Assert.assertEquals(text, "Click to turn the switch OFF");
    }

    @Test
    public void dropdownAssertion() throws InterruptedException {
        String text = wdFormsPage.dropdownSelectAndGetOption("Appium is awesome");
        Assert.assertEquals(text, "Appium is awesome");
    }

    @Test
    public void activeButtonAssertion() {
        String text = wdFormsPage.clickOnActiveButtonAndGetText();
        Assert.assertEquals(text, "This button is active");
    }

    @Test
    public void inActiveButtonAssertion() throws InterruptedException {
        String Status = wdFormsPage.statusOfInActiveButton();
        Assert.assertEquals(Status, "false");
    }
}
