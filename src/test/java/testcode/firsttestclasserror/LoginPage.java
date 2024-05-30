package testcode.firsttestclasserror;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("username2");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By errorMessage = By.xpath("//div[contains(text(), 'Your username is invalid!')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Метод для ввода логина
    public void enterUsername(String username) {
        enterText(usernameField, username);
    }

    // Метод для ввода пароля
    public void enterPassword(String password) {
        enterText(passwordField, password);
    }

    // Метод для нажатия на кнопку входа
    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public boolean errorMessageAfterLoginDisplayed() {
        return messageDisplayed(errorMessage);
    }
}
