package seleniumTest;

import ChromeBrowser.SeleniumBrowserSetup;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.*;

public class basicAuthTest {

    private static SeleniumBrowserSetup chrome = new SeleniumBrowserSetup();
    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){

        driver = chrome.setupBrowser();
    }

    @AfterAll
    public static void afterAll(){

        driver.quit();
    }

    @ParameterizedTest
    @CsvSource(value = {"admin,admin"})
    @DisplayName("Basic Authentification Test")
    public void basicAuth(String user, String pass){

    String url, domain;
    domain = "the-internet.herokuapp.com/basic_auth";
    url = "https://"+user+":"+pass+"@"+domain;

    driver.get(url);
    }
}
