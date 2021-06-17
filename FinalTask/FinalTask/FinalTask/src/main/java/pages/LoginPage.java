package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//input[@id='EmailAddress']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement passwordField;

    @FindBy(xpath = "//input[@id='signin']")
    private WebElement signInButton;

    @FindBy(xpath = "//a[@class='qa-forgot-password adobeTrackedButton']")
    private WebElement forgotPasswordButton;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    private WebElement emailError;

    @FindBy(xpath = "//span[@id='Password-error']")
    private WebElement passwordError;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkEmailFieldVisibility() {
        return emailField.isDisplayed();
    }

    public boolean checkPasswordFieldVisibility() {
        return passwordField.isDisplayed();
    }

    public boolean checkSignInButtonVisibility() {
        return signInButton.isDisplayed();
    }

    public void enterCredentials(final String email, final String password) {
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public boolean checkForgotPasswordButtonVisibility() {
        return forgotPasswordButton.isDisplayed();
    }

    public boolean checkEmailErrorVisibility() {
        return emailError.isDisplayed();
    }

    public boolean checkPasswordErrorVisibility() {
        return passwordError.isDisplayed();
    }


}
