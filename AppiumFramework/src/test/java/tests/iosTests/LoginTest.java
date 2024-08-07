package tests.iosTests;

import tests.testUtils.IOSBaseTest;
import org.pageObjects.ios.LoginPageIOS;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginTest extends IOSBaseTest {

    @Test(dataProvider = "getData")
    public void iosLoginFlow(HashMap<String ,String> input){
        LoginPageIOS wdLoginPage = wdHomePageIOS.clickOnLogInPage();

        String text = wdLoginPage.enterCredentialAndGetText(input.get("Email"), input.get("Password"));
        Assert.assertEquals(text,"You are logged in!");

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//TestData//credentials.json");
        return new Object[][]{ {data.get(0)}, {data.get(1)} };
    }
}
