package seleniumTests;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testSetup.testSetup;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_CLASS;

@TestInstance(PER_CLASS)
public class alertTest extends testSetup {

    @Test
    @DisplayName("Attempting to dismiss alert")
    public void alertTest() {

        WebElement link = driver.findElement(By.linkText("Context Menu"));
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        link.click();
        //Locating context menu area location
        WebElement element = driver.findElement(By.id("hot-spot"));

        //"moving" mouse to context menu area
        actions.contextClick(element).perform();

        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        assertEquals("You selected a context menu", alert.getText());
        alert.accept();

        actions.sendKeys(Keys.ESCAPE).perform();

    }
}
