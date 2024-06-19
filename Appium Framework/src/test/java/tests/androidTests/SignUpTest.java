package tests.androidTests;

import tests.testUtils.AndroidBaseTest;
import org.pageObjects.android.LoginPageAndroid;
import org.pageObjects.android.SignUpPageAndroid;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SignUpTest extends AndroidBaseTest {

    LoginPageAndroid wdLoginPage;

    @BeforeClass
    public void navigateToLoginPage() {
        wdLoginPage = wdHomePageAndroid.clickOnLogInPage();
    }

    @Test(dataProvider = "getData", groups = {"Smoke"})
    public void androidSignFlow(HashMap<String, String> input) throws InterruptedException {
        SignUpPageAndroid wdSignUpPage = wdLoginPage.signUpOption();
        wdSignUpPage.enterCredentialSignUp(input.get("Email"), input.get("Password"));
        wdSignUpPage.clickOnSubmitButton();
        String text = wdSignUpPage.getSignUpText();
        wdSignUpPage.clickOnSignUpOk();
        Assert.assertEquals(text, "Signed Up!");
        Thread.sleep(4000);
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//TestData//credentials.json");
        return new Object[][]{ {data.get(0)}, {data.get(1)} };
    }
}
