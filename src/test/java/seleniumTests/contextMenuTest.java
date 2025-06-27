package seleniumTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testSetup.testSetup;

public class contextMenuTest extends testSetup{

    @Test
    @DisplayName("Right-Click in box, alert appears")
    public void contextMenu(){
        WebElement link = driver.findElement(By.linkText("Context Menu"));
        Actions actions = new Actions(driver);

        link.click();

        WebElement element = driver.findElement(By.id("hot-spot"));
        //"moving" mouse to context menu area (checkered box on page)
        actions.contextClick(element).perform();

        //accepting alert to close
        driver.switchTo().alert().accept();

        //closing right click context menu
        actions.click();
    }
}
