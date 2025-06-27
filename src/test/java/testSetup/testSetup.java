package testSetup;

import ChromeBrowser.SeleniumBrowserSetup;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

public class testSetup {

    private static SeleniumBrowserSetup chrome = new SeleniumBrowserSetup();
    protected static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){

        driver = chrome.setupBrowser();
        driver.get("https://the-internet.herokuapp.com");
    }

    @AfterAll
    public static void afterAll(){

        driver.quit();
    }
}
