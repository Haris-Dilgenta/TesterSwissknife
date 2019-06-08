import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumK8test {

    WebDriver driver;
    DesiredCapabilities desiredCapabilities;
    String URL = "http://www.google.co.uk";
    String Node = "http://192.168.99.100:30925/wd/hub";

    @Before
    public void simpleConfig() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/test/resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-infobars").
                addArguments("--disable-gpu").
                addArguments("--privileged").
                addArguments("--ignore-certificate-errors");
        desiredCapabilities = DesiredCapabilities.chrome();
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);

        driver = new RemoteWebDriver(new URL(Node), desiredCapabilities);

    }

    @Test
    public void simpleTest() {

        driver.get(URL);
        String title = driver.getTitle();
        System.out.println(title);

    }

    @After
    public void cleanUp() {
        driver.quit();
        driver = null;
    }


}

