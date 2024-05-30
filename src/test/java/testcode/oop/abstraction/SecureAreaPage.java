package testcode.oop.abstraction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import testcode.firsttestclasstest.BasePage;

public class SecureAreaPage extends BasePage {

    // Конструктор класса
    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }

    // Метод для получения сообщения об успешном входе
    public String getSuccessMessage() {
        WebElement successMessage = driver.findElement(By.cssSelector(".flash.success"));
        return successMessage.getText();
    }
}
