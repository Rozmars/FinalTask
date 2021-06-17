package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//select[@data-id='sizeSelect']")
    private WebElement sizeDroplist;

    @FindBy(xpath = "//select[@data-id='sizeSelect']//option[not(contains(text(), 'Not available'))]")
    private List<WebElement> sizeOptions;

    @FindBy(xpath = "//span[text()='Add to bag']")
    private WebElement addToBagButton;

    @FindBy(xpath = "//div[@data-testid='minibag-dropdown']")
    private WebElement cartPopup;

    @FindBy(xpath = "//a[@data-test-id='bag-link']")
    private WebElement viewBagButton;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkSizeDroplistVisibility() {
        return sizeDroplist.isDisplayed();
    }

    public void clickOnSizeDroplist() {
        sizeDroplist.click();
    }

    public void chooseSize() {
        sizeOptions.get(1).click();
    }

    public boolean checkAddToBagButtonVisibility() {
        return addToBagButton.isDisplayed();
    }

    public void clickOnAddToBagButton() {
        addToBagButton.click();
    }

    public boolean checkCartPopupVisibility() {
        return cartPopup.isDisplayed();
    }

    public void clickOnViewBagButton() {
        viewBagButton.click();
    }

}
