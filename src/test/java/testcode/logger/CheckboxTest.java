package testcode.logger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CheckboxTest {

    private WebDriver driver;
    private final Logger logger = LogManager.getLogger(CheckboxTest.class);

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        driver = new ChromeDriver();
        logger.info("Browser started");
    }

    @Test
    public void testCheckbox() {
        try {
            driver.get("https://the-internet.herokuapp.com/checkboxes");
            logger.info("Navigated to checkboxes page");

            WebElement checkboxOne = driver.findElement(By.xpath("//input[@type='checkbox'][1]"));
            checkboxOne.click();
            logger.info("Checkbox 1 selected");

            WebElement checkboxTwo = driver.findElement(By.xpath("//input[@type='checkbox'][2]"));
            if (!checkboxTwo.isSelected()) {
                checkboxTwo.click();
                logger.info("Checkbox 2 selected");
            } else {
                logger.info("Checkbox 2 already selected");
            }
        } catch (Exception e) {
            logger.error("An error occurred during the test: {}", e.getMessage(), e);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }
    }
}
