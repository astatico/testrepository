package testcode.implicitandexplicitwaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstExplicitWait {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement startButton = driver.findElement(By.cssSelector("#start > button"));
        startButton.click();

        WebElement finishText =
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#finish > h4")));
        System.out.println("Finish text: " + finishText.getText());

        driver.quit();
    }
}
