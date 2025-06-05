package seleniumTest;

import ChromeBrowser.SeleniumBrowserSetup;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class dropDownTest {

    private static SeleniumBrowserSetup chrome = new SeleniumBrowserSetup();
    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){

        driver = chrome.openBrowser();
        //Setting page to open
        driver.get("https://the-internet.herokuapp.com");
    }

    @AfterAll
    public static void afterAll(){

        driver.quit();
    }

    @Test
    @DisplayName("Dropdown List")
    public void dropDownList(){

        WebElement link = driver.findElement(By.linkText("Dropdown"));
        Actions actions = new Actions(driver);

        link.click();

        WebElement dropDown = driver.findElement(By.id("dropdown"));
        dropDown.click();

        WebElement optionSel = driver.findElement(By.xpath("//div[@class='example']/select[@id='dropdown']/option[@value='2']"));
        optionSel.click();

        actions.sendKeys(Keys.ESCAPE).perform();

        assertEquals(optionSel.getText(),"Option 2");
    }
}
