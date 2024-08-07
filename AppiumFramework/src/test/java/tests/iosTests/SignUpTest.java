package tests.iosTests;

import tests.testUtils.IOSBaseTest;
import org.pageObjects.ios.LoginPageIOS;
import org.pageObjects.ios.SignUpPageIOS;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SignUpTest extends IOSBaseTest {

    @Test(dataProvider = "getData")
    public void iosSignUpFlow(HashMap<String ,String> input) throws InterruptedException {
        LoginPageIOS wdLoginPage = wdHomePageIOS.clickOnLogInPage();
        SignUpPageIOS wdSignUpPage = wdLoginPage.signUpOption();
//        Thread.sleep(5000);
        wdSignUpPage.enterCredentialSignUp(input.get("Email"), input.get("Password"));
        wdSignUpPage.clickOnSubmitButton();

        String text = wdSignUpPage.getSignUpText();

        wdSignUpPage.clickOnSignUpOk();

        Assert.assertEquals(text, "You successfully signed up!");
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//TestData//credentials.json");
        return new Object[][]{ {data.get(0)}, {data.get(1)} };
    }
}
