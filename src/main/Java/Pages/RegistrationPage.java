package Pages;

import Base.Base;
import Util.Util;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegistrationPage extends Base {

    @FindBy(xpath = "//input[@id='username']")
    WebElement registrationUsernameInput;

    @FindBy(xpath = "//input[@id='email']")
    WebElement registrationEmailInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement registrationPasswordInput;

    @FindBy(xpath = "//input[@id='password-confirm']")
    WebElement registrationConfirmPasswordInput;

    @FindBy(xpath = "//button[@id='registrate-btn']")
    WebElement registrationButton;




    public String registerRoute = baseUrl + "registration";


    private void setRegistrationUsernameInput(String username) {
        Util.lookUpWebElementWithWait(driver, registrationUsernameInput).sendKeys(username);
    }

    private void setRegistrationEmailInput(String email) {
        Util.lookUpWebElementWithWait(driver, registrationEmailInput).sendKeys(email);
    }

    private void setRegistrationPasswordInput(String password) {
        Util.lookUpWebElementWithWait(driver, registrationPasswordInput).sendKeys(password);
    }

    private void setRegistrationConfirmPasswordInput(String confirmPassword) {
        Util.lookUpWebElementWithWait(driver, registrationConfirmPasswordInput).sendKeys(confirmPassword);
    }

    private void clickOnRegisterButton() {
        Util.lookUpWebElementWithWait(driver, registrationButton).click();
    }


    public void navigateToRegistration() {
        driver.get(registerRoute);
    }

    public void registerNewUser(String username, String email, String password, String confirmPassword) {
        this.setRegistrationUsernameInput(username);
        this.setRegistrationEmailInput(email);
        this.setRegistrationPasswordInput(password);
        this.setRegistrationConfirmPasswordInput(confirmPassword);
        this.clickOnRegisterButton();
    }

    public String getEmailInputType() {
        return Util.lookUpWebElementWithWait(driver, registrationEmailInput).getAttribute("type");
    }

    public Boolean registrationErrorAlertIsPresent() {
        Alert alert = new WebDriverWait(driver, Duration.ofMillis(3000)).until(ExpectedConditions.alertIsPresent());
        return alert != null;
    }

    public String registrationErrorAlertMessage() {
        Alert alert = new WebDriverWait(driver, Duration.ofMillis(3000)).until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }
}
