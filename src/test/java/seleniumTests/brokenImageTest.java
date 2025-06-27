package seleniumTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testSetup.testSetup;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class brokenImageTest extends testSetup {

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
