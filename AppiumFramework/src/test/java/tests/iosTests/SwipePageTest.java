package tests.iosTests;

import tests.testUtils.IOSBaseTest;
import org.pageObjects.ios.SwipePageIOS;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SwipePageTest extends IOSBaseTest {
    SwipePageIOS wdSwipePage;

    @BeforeMethod
    public void navigateToSwipePage() {
        wdSwipePage = wdHomePageIOS.clickOnSwipePage();
    }

    @Test
    public void scrollTextAssertion() throws InterruptedException {

//        wdSwipePage.getTextAfterScroll();
        wdSwipePage.swipeTillEnd();

//        Thread.sleep(3000);
        String data = wdSwipePage.getTextAfterScroll();
        Assert.assertEquals(data, "You found me!!!");
    }

//    @Test
//    public void scrollToEnd() throws InterruptedException {
//        wdSwipePage.swipeTillEnd();
//        Thread.sleep(3000);
//
//    }
//
//    @Test
//    public void scrollToTop() throws InterruptedException {
//        wdSwipePage.swipeTillTop();
//        Thread.sleep(3000);
//    }
//
//    @Test
//    public void scrollToLeft() throws InterruptedException {
//        wdSwipePage.swipeToLeft();
//    }
//
//    @Test
//    public void scrollToRight() throws InterruptedException {
//        wdSwipePage.swipeToRight();
//    }


}
