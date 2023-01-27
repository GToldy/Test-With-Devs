package Pages;

import Base.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import Util.ReadFromConfig;
import Util.Util;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LogInPage extends Base {

    @FindBy(xpath = "//input[@id='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordInput;

    @FindBy(xpath = "//button[@id='login-btn']")
    WebElement loginButton;


    public String loginRoute = baseUrl + "login";
    public String userName = ReadFromConfig.readFromFile("correctUsername");
    public String password = ReadFromConfig.readFromFile("correctPassword");


    private void setUsernameInput(String username) {
        Util.lookUpWebElementWithWait(driver, usernameInput).sendKeys(username);
    }

    private void setPasswordInput(String password) {
        Util.lookUpWebElementWithWait(driver, passwordInput).sendKeys(password);
    }

    private void clickOnLoginButton() {
        Util.lookUpWebElementWithWait(driver, loginButton).click();
    }


    public void navigateToLogin() {
        driver.get(loginRoute);
    }

    public void logInWithUser(String username, String password) {
        this.setUsernameInput(username);
        this.setPasswordInput(password);
        this.clickOnLoginButton();
    }

    public String getPasswordFieldType() {
        return Util.lookUpWebElementWithWait(driver, passwordInput).getAttribute("type");
    }

    public String getAlertMessage() {
        Alert alert = new WebDriverWait(driver, Duration.ofMillis(3000)).until(ExpectedConditions.alertIsPresent());
        return alert.getText();
    }
}