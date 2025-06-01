package seleniumTest;

import ChromeBrowser.SeleniumBrowserSetup;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;

import java.time.Duration;

public class basicAuthTest {

    private static SeleniumBrowserSetup chrome = new SeleniumBrowserSetup();
    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){

        driver = chrome.openBrowser();
        //driver.get("https://the-internet.herokuapp.com");
    }

    @AfterAll
    public static void afterAll(){

        driver.quit();
    }

    @Test
    @DisplayName("Basic Authentification Test")
    public void basicAuth(){

    String user, pass, url, domain;
    user = "admin";
    pass = "admin";
    domain = "the-internet.herokuapp.com/basic_auth";
    url = "https://"+user+":"+pass+"@"+domain;

    driver.get(url);
    }
}
