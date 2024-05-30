package testcode.implicitandexplicitwaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SecondImplicitWait {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        WebElement removeButton = driver.findElement(By.cssSelector("#checkbox-example > button"));
        removeButton.click();

        WebElement message = driver.findElement(By.id("message"));
        System.out.println("Message after removing checkbox: " + message.getText());

        driver.quit();
    }
}
