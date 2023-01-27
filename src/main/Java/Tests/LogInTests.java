package Tests;

import Pages.HomePage;
import Pages.LogInPage;
import Util.ReadFromConfig;
import Util.WebDriverUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LogInTests {

    LogInPage logInPage = new LogInPage();
    HomePage homePage = new HomePage();


    @BeforeEach
    public void setEnvironment() {
        logInPage.navigateToLogin();
    }

    @AfterEach
    public void quit() {
        WebDriverUtil.quitWebDriver();
    }

    @Test
    public void testSuccessfulLogIn() {
        logInPage.logInWithUser(logInPage.userName, logInPage.password);

        String loggedInUsername = homePage.getLoggedInUser();
        String correctUsername = ReadFromConfig.readFromFile("correctUsername");
        assertTrue(loggedInUsername.contains(correctUsername));
    }

    @Test
    public void testLoginWithEmptyFields() {
        logInPage.logInWithUser("", "");

        String errorMessage = logInPage.getAlertMessage();

        assertEquals("Wrong Username or Password!", errorMessage);
    }

    @Test
    public void testLoginWithEmptyPassword() {
        logInPage.logInWithUser("user1", "");

        String errorMessage = logInPage.getAlertMessage();

        assertEquals("Wrong Username or Password!", errorMessage);
    }

    @Test
    public void testLoginPasswordFieldType() {
        String inputType = logInPage.getPasswordFieldType();
        assertEquals("password", inputType);
    }
}
