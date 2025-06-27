package seleniumTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testSetup.testSetup;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class dropDownTest extends testSetup {

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
