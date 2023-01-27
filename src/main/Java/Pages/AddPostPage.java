package Pages;

import Base.Base;
import Util.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddPostPage extends Base {

    @FindBy(xpath = "//input[id@='title']")
    WebElement addPostTitleInput;

    @FindBy(xpath = "//input[id@='content']")
    WebElement addPostContentInput;

    @FindBy(xpath = "//input[contains(@class, 'post-editor')]")
    WebElement postButton;




    private void setPostTitleInput(String title) {
        Util.lookUpWebElementWithWait(driver, addPostTitleInput).sendKeys(title);
    }

    private void setPostContentInput(String postContent) {
        Util.lookUpWebElementWithWait(driver, addPostContentInput).sendKeys(postContent);
    }

    private void clickOnPostButton() {
        Util.lookUpWebElementWithWait(driver, postButton).click();
    }


    public void createNewPost(String title, String postContent) {
        this.setPostTitleInput(title);
        this.setPostContentInput(postContent);
        this.clickOnPostButton();
    }
}
