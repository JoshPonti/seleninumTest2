package seleniumTest;

import ChromeBrowser.SeleniumBrowserSetup;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class automatedTestDemo {

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
    @DisplayName("Open Browser, Enter URL, Get URL Title")
    public void openPageGetTitle() throws InterruptedException {

        String expectedTitle = "The Internet";

        Thread.sleep(200);
        assertEquals(expectedTitle, driver.getTitle());
    }

    @Test
    @DisplayName("Adding button, then checking button names")
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

    @Test
    @DisplayName("Verify number of delete buttons (5)")
    public void countButtons() throws InterruptedException {
        int buttonCount = 0;
        WebElement addButton = driver.findElement(By.xpath("//div[@class='example']/button[@onclick='addElement()']"));
        for(int i = 0; i<4; i++){
            addButton.click();
        }

        Thread.sleep(200);

        List<WebElement> delButtons = driver.findElements(By.xpath("//div[@id='elements']/button[@onclick='deleteElement()']"));
        buttonCount = delButtons.size();

        assertEquals(5,buttonCount);
    }
}
