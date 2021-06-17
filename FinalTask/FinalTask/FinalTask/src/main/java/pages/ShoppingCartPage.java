package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    @FindBy(xpath = "//li[@class='bag-item-holder']")
    private List<WebElement> shoppingCartItems;

    @FindBy(xpath = "//button[@class='bag-item-remove']")
    private WebElement removeItemFromCartButton;

    @FindBy(xpath = "//h2[text()='Your bag is empty']")
    private WebElement emptyBagMessage;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public int getAmountOfProductsInShoppingCart() {
        return shoppingCartItems.size();
    }

    public void clickOnRemoveItemFromCartButton() {
        removeItemFromCartButton.click();
    }

    public String getEmptyBagMessage() {
        return emptyBagMessage.getText();
    }
}
