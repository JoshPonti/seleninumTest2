package ChromeBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumBrowserSetup {

    public WebDriver openBrowser() {

        //class object
        ChromeOptions co = new ChromeOptions();

        //Setting browser version
        co.setBrowserVersion("137");

        //Creating new WebDriver - Chrome
        ChromeDriver driver = new ChromeDriver();

        //maximizing window
        driver.manage().window().maximize();

        return driver;
    }

}
