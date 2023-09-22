package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.General;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerLoginPage extends BasePage {
    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    public CustomerLoginPage fillUsername(String username) {
        WebElement webElement = getWebElement(By.name("username"));
        webElement.clear();
        webElement.sendKeys(username);
        return this;
    }

    public CustomerLoginPage fillPassword(String password) {
        getWebElement(By.name("password")).sendKeys(password);
        return this;
    }

    public HomePage clickLoginBtn() {
        getWebElement(By.cssSelector("input.button")).click();
        return getInstance(HomePage.class);
    }

    public CustomerLoginPage clickLoginBtnToFail() {
        getWebElement(By.cssSelector("input.button")).click();
        return this;
    }

    public CustomerLoginPage doLogin() {
        return clickLoginBtnToFail();
    }

    public CustomerLoginPage doLogin(String username) {
        return fillUsername(username)
                .clickLoginBtnToFail();
    }

    public HomePage doLogin(String username, String password) {
        return fillUsername(username)
                .fillPassword(password)
                .clickLoginBtn();
    }

    public RegisterPage clickRegistrationLink(){
        General.waitForDomStable();
        getWebElement(By.linkText("Register")).click();
        return getInstance(RegisterPage.class);
    }

    public boolean hasError() {
        return getWebElements(By.className("error")).size() > 0;
    }
}
