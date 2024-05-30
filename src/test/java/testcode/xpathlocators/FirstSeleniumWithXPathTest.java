package testcode.xpathlocators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class FirstSeleniumWithXPathTest {

    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    @BeforeClass
    void initAndOpenSite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");

        webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h1[text()='Welcome to the-internet']")
        ));
    }

    @AfterClass(alwaysRun = true)
    void closeDriver() {
        driver.quit();
    }

    @Test
    void firstSeleniumWithXpathTest() {
        WebElement element = driver.findElement(By.xpath("//a[text()='A/B Testing']"));
        Assert.assertEquals(element.getText(), "A/B Testing", "Тексты не совпали.");
    }

    @Test
    void secondSeleniumWithXpathTest() {
        var inputsButton = driver.findElement(By.xpath("//a[text()='Inputs']"));
        inputsButton.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h3[text()='Inputs']")
        ));

        WebElement element = driver.findElement(By.xpath("//input[@type='number']"));
        Assert.assertEquals(element.getAttribute("type"), "number", "Атрибуты не совпали.");
    }

    @Test
    void thirdSeleniumWithXpathTest() {
        List<WebElement> elements = driver.findElements(By.xpath("//a"));
        Assert.assertEquals(elements.size(), 46, "Количество элементов не совпало.");
    }

    @Test
    void fourthSeleniumWithXpathTest() {
        WebElement link =
                driver.findElement(By.xpath("//div[@id='content']//a[text()='A/B Testing']"));

        Assert.assertEquals(link.getText(), "A/B Testing", "Тексты не совпали.");
    }

    @Test
    void fifthSeleniumWithXpathTest() {
        WebElement dropdownLink = driver.findElement(By.xpath("//a[contains(@href, 'dropdown')]"));
        Assert.assertTrue(dropdownLink.isDisplayed());
    }

    @Test
    void sixthSeleniumWithXpathTest() {
        WebElement element = driver.findElement(By.xpath("//li/preceding-sibling::*"));
        Assert.assertTrue(element.isDisplayed(), "Элемент не отображается.");
    }
}
