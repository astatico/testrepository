package testcode.lombok;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    private final TestConfig config = new TestConfig();

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginSuccess() {
        User user = new User("tomsmith", "SuperSecretPassword!");

        loginPage.open(config.getBaseUrl());
        loginPage.login(user.getUsername(), user.getPassword());

        Assert.assertTrue(loginPage.isSuccessMessageDisplayed(), "Login was not successful");
    }

    @Test
    public void testLoginFailure() {
        User user = new User("invalidUser", "invalidPassword");

        loginPage.open(config.getBaseUrl());
        loginPage.login(user.getUsername(), user.getPassword());

        Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message was not displayed");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

