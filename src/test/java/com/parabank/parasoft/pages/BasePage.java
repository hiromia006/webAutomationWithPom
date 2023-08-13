package com.parabank.parasoft.pages;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.parabank.parasoft.report.ReportTestManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BasePage extends Page {
    public BasePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getPageTittle() {
        return driver.getTitle();
    }

    @Override
    public WebElement getWebElement(By locator) {
        WebElement webElement = null;
        try {
            waitForWebElement(locator);
            webElement = driver.findElement(locator);
            addInfoLog("has been located " + locator.toString());
        } catch (Exception exception) {
            System.out.println(locator.toString() + " No found");
            addFailLog(locator.toString() + " has not been found.");
        }
        return webElement;
    }

    @Override
    public List<WebElement> getWebElements(By locator) {
        List<WebElement> webElements = null;
        try {
            waitForWebElement(locator);
            webElements = driver.findElements(locator);
            addInfoLog("has been located " + locator.toString());
        } catch (Exception exception) {
            System.out.println(locator.toString() + " No found");
            addFailLog(locator.toString() + " has not been found.");
        }
        return webElements;
    }

    @Override
    public void waitForWebElement(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (Exception exception) {
            System.out.println(locator.toString() + " Not Loading");
        }
    }

    public void addInfoLog(String message) {
        if (ReportTestManager.getTest() != null)
            ReportTestManager.getTest().log(Status.INFO, message);
    }

    public void addFailLog(String message) {
        if (ReportTestManager.getTest() != null)
            ReportTestManager.getTest().log(Status.FAIL, message);
        // Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64,"
                + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        ReportTestManager.getTest().fail("details2",
                MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
    }
}
