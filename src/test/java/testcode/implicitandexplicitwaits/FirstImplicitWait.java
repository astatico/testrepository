package testcode.implicitandexplicitwaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FirstImplicitWait {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        WebElement startButton = driver.findElement(By.cssSelector("#start > button"));
        startButton.click();

        WebElement finishText = driver.findElement(By.cssSelector("#finish > h4"));
        System.out.println("Finish text: " + finishText.getText());

        driver.quit();
    }
}
