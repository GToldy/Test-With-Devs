package Util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverUtil {

    private static WebDriverUtil webDriverUtil = null;
    private static WebDriver webDriver;

    private WebDriverUtil() {}


    public static WebDriverUtil getInstance() {
        if (webDriverUtil == null) {
            webDriverUtil = new WebDriverUtil();
        }
        return webDriverUtil;
    }

    private static void initWebDriver(String driverType) {
        if (webDriver == null) {
            switch (driverType) {
                case "Chrome" -> {
                    WebDriverManager.chromedriver().setup();
                    webDriver = new ChromeDriver();
                }
                case "Firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    webDriver = new FirefoxDriver();
                }
                case "Safari" -> {
                    WebDriverManager.safaridriver().setup();
                    webDriver = new SafariDriver();
                }
            }
        }

        assert webDriver != null;
        webDriver.manage().window().maximize();
    }


    public WebDriver getWebDriver(String driverType) {
        initWebDriver(driverType);
        return webDriver;
    }


    public static void quitWebDriver(){
        webDriver.quit();
        webDriver = null;
    }

    public static String getCurrentPageUrl() {
        return webDriver.getCurrentUrl();
    }
}
