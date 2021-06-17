package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FAQPage extends BasePage {
    @FindBy(xpath = "//input[@placeholder='Search for help']")
    private WebElement searchForHelpField;

    @FindBy(xpath = "//h3[@class='CardListItem_textWrapper']")
    private List<WebElement> mainProblemButtons;

    public FAQPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkSearchForHelpFieldVisibility() {
        return searchForHelpField.isDisplayed();
    }
}
