package tests.androidTests;

import tests.testUtils.AndroidBaseTest;
import org.pageObjects.android.LoginPageAndroid;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class LoginTest extends AndroidBaseTest {

    @Test(dataProvider = "getData")
    public void androidLoginFlow(HashMap<String ,String> input){
        LoginPageAndroid wdLoginPage = wdHomePageAndroid.clickOnLogInPage();
        wdLoginPage.enterCredential(input.get("Email"), input.get("Password"));
        wdLoginPage.clickOnLogInButton();

        String text = wdLoginPage.getLoginText();

        wdLoginPage.clickOnLogInOkButton();

        Assert.assertEquals(text,"You are logged in!");

    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//TestData//credentials.json");
        return new Object[][]{ {data.get(0)}, {data.get(1)} };
    }
}
