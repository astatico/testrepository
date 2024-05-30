package testcode.pageobjectsample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicLoadingPage {

    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By startButtonLocator = By.cssSelector("#start button");
    private final By loadingIndicatorLocator = By.id("loading");
    private final By loadedTextLocator = By.id("finish");

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public void open() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    public void clickStartButton() {
        driver.findElement(startButtonLocator).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIndicatorLocator));
    }

    public String getLoadedText() {
        return driver.findElement(loadedTextLocator).getText();
    }
}