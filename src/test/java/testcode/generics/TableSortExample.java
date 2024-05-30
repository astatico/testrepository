package testcode.generics;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import java.util.List;

public class TableSortExample {

    private WebDriver driver;

    public TableSortExample(WebDriver driver) {
        this.driver = driver;
    }

    public TableSortExample() {}

    // Метод для получения данных из таблицы
    public <T> T getTableCellValue(int row, int column, Class<T> type) {
        WebElement table = driver.findElement(By.id("table1"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        WebElement targetRow = rows.get(row - 1);
        List<WebElement> cells = targetRow.findElements(By.tagName("td"));
        String cellText = cells.get(column - 1).getText();

        if (type.equals(Integer.class)) {
            return type.cast(Integer.parseInt(cellText));
        } else if (type.equals(Double.class)) {
            return type.cast(Double.parseDouble(cellText));
        } else if (type.equals(String.class)) {
            return type.cast(cellText);
        } else {
            throw new IllegalArgumentException("Unsupported type");
        }
    }

    public void testTableData() {
        WebDriverManager.chromedriver().clearDriverCache().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        TableSortExample tableExample = new TableSortExample(driver);
        String sum = tableExample.getTableCellValue(2, 4, String.class);
        System.out.println("Sum: " + sum);

        driver.quit();
    }

    public static void main(String[] args) {
        TableSortExample example = new TableSortExample();
        example.testTableData();
    }
}
