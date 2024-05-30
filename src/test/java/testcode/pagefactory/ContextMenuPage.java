package testcode.pagefactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContextMenuPage {

    private final WebDriver driver;

    @FindBy(xpath = "//div[@id='hot-spot']")
    private WebElement contextMenuArea;

    public ContextMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void rightClickContextMenuArea() {
        Actions actions = new Actions(driver);
        actions.contextClick(contextMenuArea).perform();
    }

    public String getContextMenuMessage() {
        Alert alert = driver.switchTo().alert();
        String message = alert.getText();
        alert.accept();
        return message;
    }

    public static void main(String[] args) {
        WebDriverManager.chromedriver().clearDriverCache().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        ContextMenuPage contextMenuPage = new ContextMenuPage(driver);
        contextMenuPage.rightClickContextMenuArea();

        String message = contextMenuPage.getContextMenuMessage();
        System.out.println("Context Menu Message: " + message);

        driver.quit();
    }
}
