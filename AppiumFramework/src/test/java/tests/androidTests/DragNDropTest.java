package tests.androidTests;

import tests.testUtils.AndroidBaseTest;
import org.pageObjects.android.DragNDropPageAndroid;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragNDropTest extends AndroidBaseTest {

    DragNDropPageAndroid dragNDropPage;

    @Test
    public void dragNDropTest() throws InterruptedException {
        dragNDropPage = wdHomePageAndroid.clickOnDragNDropPage();
        dragNDropPage.solveDragNDropPuzzle();

        Thread.sleep(2000);

        String text = dragNDropPage.getSolvedPuzzleText();

        Assert.assertEquals(text,"Congratulations");
    }

}
