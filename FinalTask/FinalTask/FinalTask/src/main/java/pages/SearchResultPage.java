package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BasePage {

    @FindBy(xpath = "//article[@data-auto-id='productTile']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//button[@data-auto-id='saveForLater']")
    private List<WebElement> addToWishlistButtons;

    @FindBy(xpath = "//a[@data-testid='savedItemsIcon']")
    private WebElement wishlistIcon;

    @FindBy(xpath = "//div[text()='Sort']")
    private WebElement sortButton;

    @FindBy(xpath = "//li[text()='Price high to low']")
    private WebElement sortFromHighPriceToLowButton;

    @FindBy(xpath = "//span[@data-auto-id='productTilePrice']")
    private List<WebElement> priceOfEachProduct;

    @FindBy(xpath = "//section[@class='grid-backgroundWrapper__row js-dynamicBackground  js-fullWidthContainer dynamic-background-0 lazy-loaded']//h2")
    private WebElement incorrectSearchMessage;

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public void addFirstProductToWishList() {
        addToWishlistButtons.get(0).click();
    }

    public void clickOnWishlistIcon() {
        wishlistIcon.click();
    }

    public int getAmountOfSearchResults() {
        return searchResults.size();
    }

    public boolean isSortButtonVisible() {
        return sortButton.isDisplayed();
    }

    public void clickOnSortButton() {
        sortButton.click();
    }

    public boolean isSortFromHighPriceToLowButtonVisible() {
        return sortFromHighPriceToLowButton.isDisplayed();
    }

    public void clickSortFromHighPriceToLowButton() {
        sortFromHighPriceToLowButton.click();
    }

    public String getFirstProductPrice() {
        return priceOfEachProduct.get(0).getText();
    }

    public String getFifthProductPrice() {
        return priceOfEachProduct.get(4).getText();
    }

    public String getIncorrectSearchMessage() {
        return incorrectSearchMessage.getText();
    }
}
