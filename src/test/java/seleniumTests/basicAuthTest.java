package seleniumTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import testSetup.testSetup;

public class basicAuthTest extends testSetup {

    @ParameterizedTest
    @CsvSource(value = {"admin,admin"})
    @DisplayName("Basic Authentification Test")
    public void basicAuth(String user, String pass){

    String url, domain;
    domain = "the-internet.herokuapp.com/basic_auth";
    url = "https://"+user+":"+pass+"@"+domain;

    driver.get(url);
    }
}
