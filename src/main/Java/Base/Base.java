package Base;

import Util.ReadFromConfig;
import Util.WebDriverUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class Base {

    protected WebDriver driver;

    protected String baseUrl;

    public Base() {
        this.baseUrl = ReadFromConfig.readFromFile("baseUrl");
        System.out.println(baseUrl);
        WebDriverUtil webDriverUtil = WebDriverUtil.getInstance();
        this.driver = webDriverUtil.getWebDriver(ReadFromConfig.readFromFile("browserType"));
        PageFactory.initElements(driver, this);
    }
}
