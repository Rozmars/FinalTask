package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    @FindBy(xpath = "//button[@data-testid='myAccountIcon']")
    private WebElement profileIcon;

    @FindBy(xpath = "//div[@data-testid='myaccount-dropdown']")
    private WebElement profilePopup;

    @FindBy(xpath = "//a[@data-testid='signin-link']")
    private WebElement signInButton;

    @FindBy(xpath = "//input[@id='chrome-search']")
    private WebElement searchField;

    @FindBy(xpath = "//button[@data-testid='search-button-inline']")
    private WebElement searchButton;

    @FindBy(xpath = "//a[@data-testid='women-floor']")
    private WebElement womenClothesButton;

    @FindBy(xpath = "//a[@data-testid='help']")
    private WebElement helpButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openHomePage(String url) {
        driver.get(url);
    }

    public void clickOnProfileIcon() {
        profileIcon.click();
    }

    public boolean checkProfilePopupVisibility() {
        return profilePopup.isDisplayed();
    }

    public WebElement getProfilePopup() {
        return profilePopup;
    }

    public boolean checkSignInButtonVisibility() {
        return signInButton.isDisplayed();
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public boolean checkSearchFieldVisibility() {
        return searchField.isDisplayed();
    }

    public void enterKeyword(final String keyword) {
        searchField.clear();
        searchField.sendKeys(keyword, Keys.ENTER);
    }

    public void clickOnSearchButton() {
        searchButton.click();
    }

    public boolean checkWomenClothesButtonVisibility() {
        return  womenClothesButton.isDisplayed();
    }

    public void clickOnWomenClothesButton() {
        womenClothesButton.click();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void clickOnHelpButton() {
        helpButton.click();
    }


}
