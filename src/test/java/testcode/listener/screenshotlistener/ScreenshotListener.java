package testcode.listener.screenshotlistener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        WebDriver driver = ((TheInternetTests) testClass).getDriver();

        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File("screenshots/" + result.getName() + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Другие методы интерфейса ITestListener можно оставить пустыми
    @Override
    public void onTestStart(ITestResult result) {}
    @Override
    public void onTestSuccess(ITestResult result) {}
    @Override
    public void onTestSkipped(ITestResult result) {}
    @Override
    public void onStart(ITestContext context) {}
    @Override
    public void onFinish(ITestContext context) {}
}
