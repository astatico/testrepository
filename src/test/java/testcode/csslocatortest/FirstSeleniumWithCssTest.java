package testcode.csslocatortest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FirstSeleniumWithCssTest {

    private static final String LOGIN = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";
    private static final String SUCCESSFUL_LOGIN = "Welcome to the Secure Area. When you are done click logout below.";

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
    void firstSeleniumWithCssTest() {
        var formAuthentication = driver.findElement(By.xpath("//a[text()='Form Authentication']"));
        formAuthentication.click();

        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("login")
        ));

        var usernameInput = driver.findElement(By.id("username"));
        var passwordInput = driver.findElement(By.id("password"));
        var loginButton = driver.findElement(By.className("fa-sign-in"));

        usernameInput.sendKeys(LOGIN);
        passwordInput.sendKeys(PASSWORD);
        loginButton.click();

        var loginSuccessful = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("subheader")
        ));

        Assert.assertEquals(loginSuccessful.getText(), SUCCESSFUL_LOGIN, "Login is failed.");
    }
}
