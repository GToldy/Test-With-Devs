package Pages;

import Base.Base;
import Util.Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Base {

    @FindBy(xpath = "//button[contains(@class, 'post')]")
    WebElement addPostButton;

    @FindBy(xpath = "//button[contains(@class, 'add-like')]")
    WebElement likePostButton;

    @FindBy(xpath = "//button[contains(@class, 'add-dislike')]")
    WebElement dislikePostButton;

    @FindBy(xpath = "//button[@id='6']")
    WebElement deletePostButton;

    @FindBy(xpath = "//button[contains(@class, 'add-comment')]")
    WebElement addCommentButton;

    @FindBy(xpath = "//button[contains(@class, 'add-comment-like')]")
    WebElement likeCommentButton;

    @FindBy(xpath = "//button[contains(@class, 'add-comment-dislike')]")
    WebElement dislikeCommentButton;

    @FindBy(xpath = "//button[contains(@class, 'delete-comment')]")
    WebElement deleteCommentButton;

    @FindBy(xpath = "//a[contains(@class,'logout')]")
    WebElement logOutButton;

    @FindBy(xpath = "//div[contains(@class, 'username-container')]/h5")
    WebElement userNameContainer;




    public void clickOnAddPostButton() {
        Util.lookUpWebElementWithWait(driver, addPostButton).click();
    }

    public void clickOnLikePostButton() {
        Util.lookUpWebElementWithWait(driver, likePostButton).click();
    }

    public void clickOnDislikePostButton() {
        Util.lookUpWebElementWithWait(driver, dislikePostButton).click();
    }

    public void clickOnDeletePostButton() {
        Util.lookUpWebElementWithWait(driver, deletePostButton).click();
    }

    public void clickOnAddCommentButton() {
        Util.lookUpWebElementWithWait(driver, addCommentButton).click();
    }
    public void clickOnLikeCommentButton() {
        Util.lookUpWebElementWithWait(driver, likeCommentButton).click();
    }
    public void clickOnDislikeCommentButton() {
        Util.lookUpWebElementWithWait(driver, dislikeCommentButton).click();
    }
    public void clickOnDeleteCommentButton() {
        Util.lookUpWebElementWithWait(driver, deleteCommentButton).click();
    }

    public void logOut() {
        Util.lookUpWebElementWithWait(driver, logOutButton).click();
    }

    public void waitForUserNameContainer() {
        Util.lookUpWebElementWithWait(driver, userNameContainer);
    }

    public String getLoggedInUser() {
        return Util.lookUpWebElementWithWait(driver, userNameContainer).getText();
    }

    public Boolean checkForLogOutButton() {
        return Util.lookUpWebElementWithWait(driver, logOutButton).isDisplayed();
    }
}
