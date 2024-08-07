package tests.iosTests;

import tests.testUtils.IOSBaseTest;
import org.pageObjects.ios.DragNDropPageIOS;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragNDropTest extends IOSBaseTest {
    DragNDropPageIOS dragNDropPage;

    @Test
    public void dragNDropTest() throws InterruptedException {
        dragNDropPage = wdHomePageIOS.clickOnDragNDropPage();

        String text = dragNDropPage.solveDragNDropPuzzle();
        Assert.assertEquals(text,"Congratulations");
    }
}
