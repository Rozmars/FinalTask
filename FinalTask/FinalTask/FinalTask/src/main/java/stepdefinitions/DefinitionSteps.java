package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import manager.PageFactoryManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.*;

import java.util.concurrent.TimeUnit;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;
import static org.testng.Assert.*;

public class DefinitionSteps {

    private final int DEFAULT_WAIT = 60;
    WebDriver driver;
    PageFactoryManager pageFactoryManager;
    HomePage homePage;
    LoginPage loginPage;
    ProductPage productPage;
    SearchResultPage searchResultPage;
    ShoppingCartPage shoppingCartPage;
    WishlistPage wishlistPage;
    FAQPage faqPage;

    @Before
    public void testSetup() {
        chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageFactoryManager = new PageFactoryManager(driver);
    }

    @And("User opens {string}")
    public void openHomePage(final String url) {
        homePage = pageFactoryManager.getHomePage();
        homePage.openHomePage(url);
    }

    @And("User clicks on profile icon")
    public void clickOnProfileIcon() {
        homePage.clickOnProfileIcon();
    }

    @And("User checks profile popup visibility")
    public void checkProfilePopupVisibility() {
        homePage.waitVisibilityOfElement(DEFAULT_WAIT, homePage.getProfilePopup());
        assertTrue(homePage.checkProfilePopupVisibility());
    }

    @And("User checks 'Sign In' button visibility in profile popup")
    public void checkSignInButtonVisibility() {
        assertTrue(homePage.checkSignInButtonVisibility());
    }

    @And("User clicks on 'Sign In' button on profile page")
    public void clickOnSignInButtonOnProfilePage() {
        homePage.clickOnSignInButton();
    }

    @And("User checks email address field visibility")
    public void checkEmailAddressFieldVisibility() {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.waitForPageLoadComplete(DEFAULT_WAIT);
        assertTrue(loginPage.checkEmailFieldVisibility());
    }

    @And("User checks password field visibility")
    public void checkPasswordFieldVisibility() {
        assertTrue(loginPage.checkPasswordFieldVisibility());
    }

    @And("User checks 'Sign In' button visibility on login page")
    public void checkSignInButtonVisibilityOnLoginPage() {
        loginPage = pageFactoryManager.getLoginPage();
        assertTrue(loginPage.checkSignInButtonVisibility());
    }

    @And("User enter his {string} and {string}")
    public void enterEmailAndPassword(final String email, final String password) {
        loginPage = pageFactoryManager.getLoginPage();
        loginPage.waitForPageLoadComplete(DEFAULT_WAIT);
        loginPage.enterCredentials(email, password);
    }

    @And("User clicks on 'Sign In' button on login page")
    public void clickOnSignInButtonOnLoginPage() {
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage.clickOnSignInButton();
    }

    @And("User checks search field visibility")
    public void checkSearchFieldVisibility() {
        assertTrue(homePage.checkSearchFieldVisibility());
    }


    @And("User enter {string}")
    public void enterKeyword(final String keyword) {
        homePage.enterKeyword(keyword);
    }

    @And("User clicks on 'Search' button")
    public void clickOnSearchButton() {
        homePage.clickOnSearchButton();
    }

    @And("User adds first product to wishlist")
    public void addFirstProductToWishlist() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_WAIT);
        searchResultPage.addFirstProductToWishList();
    }

    @And("User clicks on wishlist icon")
    public void clickOnWishlistIcon() {
        searchResultPage.waitForAjaxToComplete(DEFAULT_WAIT);
        searchResultPage.clickOnWishlistIcon();
    }

    @And("User checks that amount of products on page is {int}")
    public void checkAmountOfProductsOnPage(final int amountOfProducts) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForAjaxToComplete(DEFAULT_WAIT);
        assertEquals(searchResultPage.getAmountOfSearchResults(), amountOfProducts);
    }

    @And("User checks 'Sort' button visibility")
    public void checkSortButtonVisibility() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_WAIT);
        assertTrue(searchResultPage.isSortButtonVisible());
    }

    @And("User clicks 'Sort' button")
    public void clickOnSortButton() {
        searchResultPage.clickOnSortButton();
    }

    @And("User checks 'Price high to low' button visibility")
    public void checkPriceHighToLowButtonVisibility() {
        assertTrue(searchResultPage.isSortFromHighPriceToLowButtonVisible());
    }

    @And("User clicks 'Price high to low' button")
    public void clickOnPriceHighToLowButton() {
        searchResultPage.waitVisibilityOfElement(DEFAULT_WAIT, driver.findElement(By.xpath("//li[text()='Price high to low']")));
        searchResultPage.clickSortFromHighPriceToLowButton();
    }

    @And("User checks that sort order is correct")
    public void checkIsSortOrderCorrect() {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_WAIT);
        searchResultPage.waitForAjaxToComplete(DEFAULT_WAIT);
        assertNotEquals(searchResultPage.getFirstProductPrice().compareTo(searchResultPage.getFifthProductPrice()), 1);
    }

    @And("User checks 'Women' button visibility")
    public void checkWomenClothesButtonVisibility() {
        assertTrue(homePage.checkWomenClothesButtonVisibility());
    }

    @And("User clicks on 'Women' button")
    public void clickOnWomenClothesButton() {
        homePage.clickOnWomenClothesButton();
    }

    @And("User checks {string}")
    public void checkURL(final String URL) {
        assertEquals(homePage.getUrl(), URL);
    }

    @And("User clicks on Asos logo")
    public void userClicksOnAsosLogo() {
        homePage.clickOnAsosLogoButton();
    }

    @And("User clicks on 'Help & FAQs' button")
    public void clickOnHelpButton() {
        homePage.clickOnHelpButton();
    }

    @And("User checks Search for help field visibility")
    public void checkSearchForHelpFieldVisibility() {
        faqPage = pageFactoryManager.getFAQPage();
        faqPage.waitForPageLoadComplete(DEFAULT_WAIT);
        assertTrue(faqPage.checkSearchForHelpFieldVisibility());
    }

    @And("User clicks on 'Remove from wishlist' button")
    public void userClicksOnRemoveFromWishlistButton() {
        wishlistPage = pageFactoryManager.getWishlistPage();
        wishlistPage.waitForPageLoadComplete(DEFAULT_WAIT);
        wishlistPage.waitVisibilityOfElement(DEFAULT_WAIT, driver.findElement(By.xpath("//button[@class='deleteButton_2paeG deleteButton_19vSt']")));
        wishlistPage.clickOnRemoveFromWishlistButton();
    }

    @And("User checks size drop list visibility")
    public void checkSizeDropListVisibility() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_WAIT);
        assertTrue(productPage.checkSizeDroplistVisibility());
    }

    @And("User clicks on size drop list")
    public void clickOnSizeDropList() {
        productPage = pageFactoryManager.getProductPage();
        productPage.waitForPageLoadComplete(DEFAULT_WAIT);
        productPage.clickOnSizeDroplist();
    }

    @And("User choose product size")
    public void chooseProductSize() {
        productPage.chooseSize();
    }

    @Then("User checks 'Add to bag' button visibility")
    public void checkAddToBagButtonVisibility() {
        assertTrue(productPage.checkAddToBagButtonVisibility());
    }

    @And("User clicks 'Add to bag' button")
    public void clickAddToBagButton() {
        productPage.clickOnAddToBagButton();
    }

    @And("User check cart popup visibility")
    public void checkCartPopupVisibility() {
        productPage.waitForAjaxToComplete(DEFAULT_WAIT);
        productPage.waitForSelectedTime(DEFAULT_WAIT);
        productPage.waitVisibilityOfElement(DEFAULT_WAIT, driver.findElement(By.xpath("//div[@data-testid='minibag-dropdown']")));
        assertTrue(productPage.checkCartPopupVisibility());
    }

    @And("User clicks 'View bag' button")
    public void clickViewBagButton() {
        productPage.waitForAjaxToComplete(DEFAULT_WAIT);
        productPage.waitVisibilityOfElement(DEFAULT_WAIT, driver.findElement(By.xpath("//a[@data-test-id='bag-link']")));
        productPage.clickOnViewBagButton();
    }

    @And("User checks that amount of products in cart is {int}")
    public void checkAmountOfProductsInCaCartPage(final int amountOfProducts) {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_WAIT);
        shoppingCartPage.waitForAjaxToComplete(DEFAULT_WAIT);
        assertEquals(shoppingCartPage.getAmountOfProductsInShoppingCart(), amountOfProducts);
    }


    @And("User checks that amount of elements in wishlist is {int}")
    public void checkAmountOfElementsInWishlist(final int amountOfElements) {
        wishlistPage = pageFactoryManager.getWishlistPage();
        wishlistPage.waitForPageLoadComplete(DEFAULT_WAIT);
        wishlistPage.waitForSelectedTime(DEFAULT_WAIT);
        assertEquals(wishlistPage.getAmountOfElementsInWishlist(), amountOfElements);
    }

    @And("User clicks 'Remove item' button")
    public void clickRemoveItemButton() {
        shoppingCartPage = pageFactoryManager.getShoppingCartPage();
        shoppingCartPage.waitForPageLoadComplete(DEFAULT_WAIT);
        shoppingCartPage.waitForAjaxToComplete(DEFAULT_WAIT);
        shoppingCartPage.clickOnRemoveItemFromCartButton();
    }

    @Then("User checks {string} presense")
    public void checkTextPresense(final String noElementsMessage) {
        wishlistPage.waitForPageLoadComplete(DEFAULT_WAIT);
        wishlistPage.waitForSelectedTime(5);
        assertEquals(wishlistPage.getNoElementsMessage(), noElementsMessage);
    }

    @And("User checks 'Forgot password?' button visibility")
    public void checkForgotPasswordButtonVisibility() {
        assertTrue(loginPage.checkForgotPasswordButtonVisibility());
    }

    @Then("User checks {string} message")
    public void checkTextMessage(final String noElementsMessage) {
        shoppingCartPage.waitForAjaxToComplete(DEFAULT_WAIT);
        shoppingCartPage.waitForSelectedTime(DEFAULT_WAIT);
        shoppingCartPage.waitVisibilityOfElement(DEFAULT_WAIT, driver.findElement(By.xpath("//h2[text()='Your bag is empty']")));
        assertEquals(shoppingCartPage.getEmptyBagMessage(), noElementsMessage);
    }

    @Then("User checks email and password errors visibility")
    public void checkEmailAndPasswordErrorsVisibility() {
        loginPage.waitForAjaxToComplete(DEFAULT_WAIT);
        assertTrue(loginPage.checkEmailErrorVisibility());
        assertTrue(loginPage.checkPasswordErrorVisibility());
    }

    @Then("User checks {string} on search result page")
    public void checkTextOnSearchResultPage(final String noElementsMessage) {
        searchResultPage = pageFactoryManager.getSearchResultPage();
        searchResultPage.waitForPageLoadComplete(DEFAULT_WAIT);
        assertEquals(searchResultPage.getIncorrectSearchMessage(), noElementsMessage);
    }

    @After
    public void tearDown() {
        driver.close();
    }

}
