package tests.testUtils;

import io.appium.java_client.Setting;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.pageObjects.ios.HomePageIOS;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.utils.AppiumUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class IOSBaseTest extends AppiumUtils {

    public static IOSDriver driver;
    public static HomePageIOS wdHomePageIOS;

    @BeforeClass(alwaysRun = true)
    public void setup() throws IOException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("src//main//resources//data.properties");
        props.load(fis);
        String ipAddress = props.getProperty("ipAddress");
        String port = props.getProperty("port");

        service = startAppiumServer(ipAddress, Integer.parseInt(port));

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("platformVersion", "17.4");
        capabilities.setCapability("deviceName", "iPhone 15 Pro Max");
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("app", System.getProperty("user.dir") + "//src//test//resources//app//wdiodemos.zip");
        capabilities.setCapability("newCommandTimeout", 60);

        driver = new IOSDriver(service.getUrl(), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.setSetting(Setting.IGNORE_UNIMPORTANT_VIEWS, true);
        wdHomePageIOS = new HomePageIOS(driver);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (service != null) {
            service.stop();
        }
    }
}
