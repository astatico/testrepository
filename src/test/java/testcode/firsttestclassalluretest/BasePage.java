package testcode.firsttestclassalluretest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Метод для клика по элементу
    protected void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    // Метод для ввода текста в поле
    protected void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    protected boolean messageDisplayed(By locator) {
        return driver.findElement(locator).isDisplayed();
    }
}
