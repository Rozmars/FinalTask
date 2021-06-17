package manager;

import org.openqa.selenium.WebDriver;
import pages.*;

public class PageFactoryManager {

    WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public ProductPage getProductPage() {
        return new ProductPage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }

    public ShoppingCartPage getShoppingCartPage() {
        return new ShoppingCartPage(driver);
    }

    public FAQPage getFAQPage() {
        return new FAQPage(driver);
    }

    public WishlistPage getWishlistPage() {
        return new WishlistPage(driver);
    }

}
