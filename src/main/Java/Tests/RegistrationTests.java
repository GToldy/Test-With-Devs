package Tests;

import Pages.HomePage;
import Pages.LogInPage;
import Pages.RegistrationPage;
import Util.WebDriverUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationTests {

    RegistrationPage registrationPage = new RegistrationPage();
    LogInPage logInPage = new LogInPage();
    HomePage homePage = new HomePage();


    @BeforeEach
    public void setEnvironment() {
        registrationPage.navigateToRegistration();
    }

    @AfterEach
    public void quit() {
        WebDriverUtil.quitWebDriver();
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/newUserRegistrationTestData.csv", numLinesToSkip = 1)
    public void testUserRegistration(String username, String email, String password, String confirmPassword) {
        registrationPage.registerNewUser(username, email, password, confirmPassword);

        logInPage.logInWithUser(username, password);
        String loggedInUsername = homePage.getLoggedInUser();
        assertTrue(loggedInUsername.contains(username));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/alreadyRegisteredUserTestData.csv", numLinesToSkip = 1)
    public void testExistingUserRegistration(String username, String email, String password, String confirmPassword) {
        registrationPage.registerNewUser(username, email, password, confirmPassword);

        assertTrue(registrationPage.registrationErrorAlertIsPresent());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/requiredRegistrationFieldsTestData.csv", numLinesToSkip = 1)
    public void testRequiredFields(String username, String email, String password, String confirmPassword) {
        registrationPage.registerNewUser(username, email, password, confirmPassword);

        String errorMessage = registrationPage.registrationErrorAlertMessage();

        assertEquals("All fields must be filled!", errorMessage);
    }

    @Test
    public void testRegistrationEmailInputType() {
        String inputType = registrationPage.getEmailInputType();
        assertEquals("email", inputType);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/passwordConfirmationsTestData.csv", numLinesToSkip = 1)
    public void testPasswordConfirmationCheck(String username, String email, String password, String confirmPassword) {
        registrationPage.registerNewUser(username, email, password, confirmPassword);

        String errorMessage = registrationPage.registrationErrorAlertMessage();

        assertEquals("Cannot create a User(invalid datas)!", errorMessage);
    }
}
