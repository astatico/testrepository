package testcode.generics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormExample {

    private WebDriver driver;

    public FormExample(WebDriver driver) {
        this.driver = driver;
    }

    public FormExample() {}

    public <T> void fillFormInput(String fieldName, T value) {
        WebElement inputField = driver.findElement(By.name(fieldName));
        inputField.clear();
        inputField.sendKeys(String.valueOf(value));
    }

    public void testForm() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        FormExample formExample = new FormExample(driver);
        formExample.fillFormInput("username", "testuser");
        formExample.fillFormInput("password", 1234);

        driver.quit();
    }

    public static void main(String[] args) {
        FormExample example = new FormExample();
        example.testForm();
    }
}
