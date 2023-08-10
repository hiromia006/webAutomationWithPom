package com.parabank.parasoft.testcase;

import com.parabank.parasoft.pages.BasePage;
import com.parabank.parasoft.pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    private Properties properties;
    Page page;
    private String defaultProjectPath = System.getProperty("user.dir");


    public BaseTest() {
        try {
            String filePath = defaultProjectPath + "/src/test/resources/config.properties";
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream(filePath);
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @BeforeMethod
    public void setUpBrowser() {
        String browserName = properties.getProperty("browserName");
        System.out.println("OS Name " + System.getProperty("os.name"));
        String osName = System.getProperty("os.name");

        if (Objects.equals(browserName, "chrome")) {
            if (osName.contains("Windows")) {
                System.setProperty("webdriver.chrome.driver", defaultProjectPath + "/src/test/resources/drivers/chromedriver.exe");
            } else {
                System.setProperty("webdriver.chrome.driver", defaultProjectPath + "/src/test/resources/drivers/chromedriver");
            }
            driver = new ChromeDriver();
        } else if (Objects.equals(browserName, "firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (Objects.equals(browserName, "chromeHeadless")) {
            if (osName.contains("Windows")) {
                System.setProperty("webdriver.chrome.driver", defaultProjectPath + "/src/test/resources/drivers/chromedriver.exe");
            } else {
                System.setProperty("webdriver.chrome.driver", defaultProjectPath + "/src/test/resources/drivers/chromedriver");
            }

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            driver = new ChromeDriver(options);

        } else if (Objects.equals(browserName, "firefoxHeadless")) {
            WebDriverManager.firefoxdriver().setup();

            FirefoxOptions options = new FirefoxOptions();
            options.addArguments("--headless");
            driver = new FirefoxDriver(options);
        } else {
            System.out.println("Please provide proper Browser Name");
        }

        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();

        page = new BasePage(driver);
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }


    @AfterMethod
    public void dearTown() {
        driver.quit();
    }
}
