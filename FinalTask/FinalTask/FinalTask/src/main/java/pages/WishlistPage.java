package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishlistPage extends BasePage {
    @FindBy(xpath = "//section[@class='productTiles_140vM']//div[@class='progressIndicatorWrapper_3QQxZ']")
    private List<WebElement> productsInWishlist;

    @FindBy(xpath = "//button[@class='deleteButton_2paeG deleteButton_19vSt']")
    private WebElement removeFromWishlistButton;

    @FindBy(xpath = "//h2[text()='You have no Saved Items']")
    private WebElement noElementsMessage;

    public WishlistPage(WebDriver driver) {
        super(driver);
    }

    public int getAmountOfElementsInWishlist() {
        return productsInWishlist.size();
    }

    public void clickOnRemoveFromWishlistButton() {
        removeFromWishlistButton.click();
    }

    public String getNoElementsMessage() {
        return noElementsMessage.getText();
    }
}
