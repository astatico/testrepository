package testcode.pageobjectsample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicLoadingPageTest {

    private WebDriver driver;
    private DynamicLoadingPage dynamicLoadingPage;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        dynamicLoadingPage = new DynamicLoadingPage(driver);
    }

    @AfterClass(alwaysRun = true)
    void closeDriver() {
        driver.quit();
    }

    @Test
    public void testDynamicLoading() {
        dynamicLoadingPage.open();
        dynamicLoadingPage.clickStartButton();

        String loadedText = dynamicLoadingPage.getLoadedText();
        Assert.assertEquals(loadedText, "Hello World!", "Loaded text doesn't match expected!");
    }
}
