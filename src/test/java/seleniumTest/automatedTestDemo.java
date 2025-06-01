package seleniumTest;

import ChromeBrowser.SeleniumBrowserSetup;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class automatedTestDemo {

    private static SeleniumBrowserSetup chrome = new SeleniumBrowserSetup();
    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){

        driver = chrome.openBrowser();
    }

    @AfterAll
    public static void afterAll(){

        driver.quit();
    }

    @Test
    public void openPageGetTitle(){

        String expectedTitle = "The Internet";

        //Setting page to open
        driver.get("https://the-internet.herokuapp.com");

        assertEquals(expectedTitle, driver.getTitle());
    }

    @Test
    public void addRemoveElements() throws InterruptedException {

        String addElement = "Add Element";
        String remElement = "Delete";
        WebElement link = driver.findElement(By.linkText("Add/Remove Elements"));
        link.click();

        //Adding sleep timers to slow test down a bit for visual purposes
        Thread.sleep(500);

        //adding button
        WebElement addButton = driver.findElement(By.xpath("//div[@class='example']/button[@onclick='addElement()']"));
        addButton.click();

        Thread.sleep(500);

        WebElement remButton = driver.findElement(By.className("added-manually"));

        assertEquals(addElement, addButton.getText());
        assertEquals(remElement, remButton.getText());
    }
}
