package testcode.implicitandexplicitwaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SecondExplicitWait {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement enableButton = driver.findElement(By.cssSelector("#input-example > button"));
        enableButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement inputField =
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#input-example > input")));
        inputField.sendKeys("Test Input");

        driver.quit();
    }
}
