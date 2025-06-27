package seleniumTest;

import ChromeBrowser.SeleniumBrowserSetup;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import static io.restassured.RestAssured.*;

public class RESTAssuredTest {

    private static SeleniumBrowserSetup chrome = new SeleniumBrowserSetup();
    private static WebDriver driver;

    @BeforeAll
    public static void beforeAll(){

        driver = chrome.setupBrowser();
        //Setting page to open
        driver.get("https://the-internet.herokuapp.com");
    }

    @AfterAll
    public static void afterAll(){

        driver.quit();
    }

    @Test
    @DisplayName("Checking 200 status")
    public void testAPIStatusCode(){
        given().when().get("https://the-internet.herokuapp.com/").then().assertThat().statusCode(200);
    }

    @Test
    @DisplayName("Checking JSON")
    public void checkJSON(){
        //can also use "application/json" instead of ContentType.JSON
        given().when().get("https://the-internet.herokuapp.com/").then().assertThat().contentType(ContentType.JSON);
    }
    /*
    @Test
    @DisplayName("Checking JSON Body")
    public void displayJSONBody(){
        given().log().all().when().get("https://the-internet.herokuapp.com/").then().log().body();
    }
    */
}
