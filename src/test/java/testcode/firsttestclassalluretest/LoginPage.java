package testcode.firsttestclassalluretest;

import io.qameta.allure.Allure;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class LoginPage extends BasePage {

    private final By usernameField = By.id("username");
    private final By passwordField = By.id("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By errorMessage = By.xpath("//div[contains(text(), 'Your username is invalid!')]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Метод для ввода логина
    public void enterUsername(String username) {
        Allure.step("Ввод логина", () -> {
            enterText(usernameField, username);
            screenshot();
        });
    }

    // Метод для ввода пароля
    public void enterPassword(String password) {
        Allure.step("Ввод пароля", () -> enterText(passwordField, password));
    }

    // Метод для нажатия на кнопку входа
    public void clickLoginButton() {
        Allure.step("Нажатие на кнопку входа", () -> clickElement(loginButton));
    }

    public boolean errorMessageAfterLoginDisplayed() {
        boolean errorMessageDisplayed = messageDisplayed(errorMessage);
        Allure.step("Проверка на наличие сообщения об ошибке", () -> errorMessageDisplayed);
        return errorMessageDisplayed;
    }

    private void screenshot() {
        Allure.addAttachment("Screenshot",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
