package tests.androidTests;

import tests.testUtils.AndroidBaseTest;
import org.pageObjects.android.SwipePageAndroid;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwipePageTest extends AndroidBaseTest {
    SwipePageAndroid wdSwipePage;

    @BeforeMethod
    public void navigateToFormsPage() {
        wdSwipePage = wdHomePageAndroid.clickOnSwipePage();
    }

//    @Test
//    public void scrollTextAssertion() {
//        String data = wdSwipePage.scrollToText("You found me!!!");
//        Assert.assertEquals(data, "You found me!!!");
//    }

//    @Test
//    public void scrollToEnd() throws InterruptedException {
//        wdSwipePage.swipeTillEnd();
//        Thread.sleep(2000);
//    }

//    @Test
//    public void scrollToTop() throws InterruptedException {
//        wdSwipePage.swipeTillTop();
//        Thread.sleep(2000);
//    }

    @Test
    public void scrollToLeft() throws InterruptedException {
        wdSwipePage.swipeToLeft();
        Thread.sleep(2000);
    }

    @Test
    public void scrollToRight() throws InterruptedException {
        wdSwipePage.swipeToRight();
        Thread.sleep(2000);
    }
}
