package seleniumTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testSetup.testSetup;

import static io.restassured.RestAssured.*;

public class RESTAssuredTest extends testSetup {

    @Test
    @DisplayName("Checking 200 status")
    public void testAPIStatusCode(){
        given().when().get("https://the-internet.herokuapp.com/").then().assertThat().statusCode(200);
    }

    /*
    @Test
    @DisplayName("Checking JSON")
    public void checkJSON(){
        //can also use "application/json" instead of ContentType.JSON
        given().when().get("https://the-internet.herokuapp.com/").then().assertThat().contentType(ContentType.JSON);
    }
     */
    /*
    @Test
    @DisplayName("Checking JSON Body")
    public void displayJSONBody(){
        given().log().all().when().get("https://the-internet.herokuapp.com/").then().log().body();
    }
    */
}
