package seleniumTest;

import ChromeBrowser.SeleniumBrowserSetup;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class brokenImageTest {

    private static SeleniumBrowserSetup chrome = new SeleniumBrowserSetup();
    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){

        driver = chrome.setupBrowser();
        driver.get("https://the-internet.herokuapp.com");
    }

    @AfterAll
    public static void afterAll(){

        driver.quit();
    }

    @Test
    @DisplayName("Broken Image Test")
    public void imageTest(){

        WebElement link = driver.findElement(By.linkText("Broken Images"));
        Actions actions = new Actions(driver);

        link.click();

        //Getting list of all images
        List<WebElement> imgList = driver.findElements(By.tagName("img"));
        //System.out.println(imgList);
        for(WebElement img : imgList){
            if (img.getAttribute("naturalWidth").equals("0")){
                //assertTrue(img.getAttribute("naturalWidth").equals("0"));
                System.out.println(img + " is broken");
            }
            else{
                assertFalse(img.getAttribute("naturalWidth").equals("0"));
                System.out.println(img + " is not null");
            }
        }
    }
}
