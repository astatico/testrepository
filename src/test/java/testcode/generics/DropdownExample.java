package testcode.generics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

public class DropdownExample {

    private WebDriver driver;

    public DropdownExample(WebDriver driver) {
        this.driver = driver;
    }

    public DropdownExample() {}

    public <T> void selectDropdownValue(String dropdownId, T value) {
        WebElement dropdownElement = driver.findElement(By.id(dropdownId));
        Select dropdown = new Select(dropdownElement);

        if (value instanceof String) {
            dropdown.selectByVisibleText((String) value);
        } else if (value instanceof Integer) {
            dropdown.selectByIndex((Integer) value);
        } else {
            throw new IllegalArgumentException("Unsupported value type");
        }
    }

    public void testDropdown() {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        DropdownExample dropdownExample = new DropdownExample(driver);
        dropdownExample.selectDropdownValue("dropdown", "Option 1");

        driver.quit();
    }

    public static void main(String[] args) {
        DropdownExample example = new DropdownExample();
        example.testDropdown();
    }
}
