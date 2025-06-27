package seleniumTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testSetup.testSetup;

public class dragAndDropTest extends testSetup {

    @Test
    @DisplayName("Drag and Drop")
    public void dragAndDrop(){

        WebElement link = driver.findElement(By.linkText("Drag and Drop"));
        Actions actions = new Actions(driver);

        link.click();

        WebElement boxA = driver.findElement(By.id("column-a"));
        WebElement boxB = driver.findElement(By.id("column-b"));

        actions.dragAndDrop(boxA,boxB).build().perform();
    }
}
