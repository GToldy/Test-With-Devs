package Util;

import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Util {

    public static WebElement lookUpWebElementWithWait(WebDriver driver, WebElement element) {
        return new WebDriverWait(driver, Duration.ofMillis(3000)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement lookUpWebElementWithWait(WebDriver driver, String selector) {
        return new WebDriverWait(driver, Duration.ofMillis(3000)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
    }

    public static WebElement lookUpWebElementWithWait(WebDriver driver, By element) {
        return new WebDriverWait(driver, Duration.ofMillis(3000)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement lookUpWebElementWithWait(WebDriver driver, int duration, String selector) {
        return new WebDriverWait(driver, Duration.ofMillis(duration)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(selector)));
    }

    public static By lookUpWebElementByRelativeLocator(String parent, String child) {
        return RelativeLocator.with(By.cssSelector(parent)).below(By.cssSelector(child));
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].scrollIntoView()", element);
    }
}