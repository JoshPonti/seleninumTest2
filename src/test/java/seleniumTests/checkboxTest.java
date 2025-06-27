package seleniumTests;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testSetup.testSetup;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class checkboxTest extends testSetup {

    @Test
    @DisplayName("Checkboxes are selected")
    public void checkboxSelected(){

        WebElement link = driver.findElement(By.linkText("Checkboxes"));

        link.click();

        WebElement chkbox1 = driver.findElement(By.cssSelector("form#checkboxes input[type='checkbox']:nth-of-type(1)"));
        WebElement chkbox2 = driver.findElement(By.cssSelector("form#checkboxes input[type='checkbox']:nth-of-type(2)"));

        if (!chkbox1.isSelected()){
            chkbox1.click();
        }
        if (!chkbox2.isSelected()) {
            chkbox2.click();
        }
        assertTrue(chkbox1.isSelected());
        assertTrue(chkbox2.isSelected());
    }

    @Test
    @DisplayName("Checkboxes are deselected")
    public void checkboxUnselected(){

        WebElement chkboxa = driver.findElement(By.cssSelector("form#checkboxes input[type='checkbox']:nth-of-type(1)"));
        WebElement chkboxb = driver.findElement(By.cssSelector("form#checkboxes input[type='checkbox']:nth-of-type(2)"));

        if (chkboxa.isSelected()){
            chkboxa.click();
        }
        if (chkboxb.isSelected()) {
            chkboxb.click();
        }
        assertFalse(chkboxa.isSelected());
        assertFalse(chkboxb.isSelected());
    }
}
