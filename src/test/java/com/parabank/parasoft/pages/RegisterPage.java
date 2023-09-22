package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.General;
import com.thedeanda.lorem.LoremIpsum;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public RegisterPage fillFirstName(String firstname) {
        General.waitForDomStable();
        getWebElement(By.id("customer.firstName")).sendKeys(firstname);
        return this;
    }

    public RegisterPage fillLastName(String lastname) {
        getWebElement(By.xpath("//input[@id='customer.lastName']")).sendKeys(lastname);
        return this;
    }

    public RegisterPage fillAddress(String address) {
        getWebElement(By.xpath("//input[@id='customer.address.street']")).sendKeys(address);
        return this;
    }

    public RegisterPage fillCity(String city) {
        getWebElement(By.xpath("//input[@id='customer.address.city']")).sendKeys(city);
        return this;
    }

    public RegisterPage fillState(String state) {
        getWebElement(By.xpath("//input[@id='customer.address.state']")).sendKeys(state);
        return this;
    }

    public RegisterPage fillZipCode(int zipcode) {
        getWebElement(By.xpath("//input[@id='customer.address.zipCode']")).sendKeys(String.valueOf(zipcode));
        return this;
    }

    public RegisterPage fillPhone(String phone) {
        getWebElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys(String.valueOf(phone));
        return this;
    }

    public RegisterPage fillSsn(String ssn) {
        getWebElement(By.id("customer.ssn")).sendKeys(ssn);
        return this;
    }

    public RegisterPage fillUsername(String username) {
        getWebElement(By.id("customer.username")).sendKeys(username);
        return this;
    }

    public RegisterPage fillPassword(String password) {
        getWebElement(By.id("customer.password")).sendKeys(password);
        return this;
    }

    public RegisterPage fillConfirmPassword(String rePassword) {
        getWebElement(By.id("repeatedPassword")).sendKeys(rePassword);
        return this;

    }

    public HomePage clickRegisterBtn() {
        getWebElement(By.cssSelector("input.button[value='Register']")).click();
        return getInstance(HomePage.class);
    }

    public RegisterPage clickRegisterLink() {
        getWebElement(By.cssSelector("input.button[value='Register']")).click();
        return this;
    }

    public Boolean hasError() {
        return getWebElements(By.className("error")).size() > 0;
    }

    public HomePage doRegistration() {
        String username = LoremIpsum.getInstance().getTitle(1);
        return fillFirstName(LoremIpsum.getInstance().getFirstName())
                .fillLastName(LoremIpsum.getInstance().getLastName())
                .fillAddress(LoremIpsum.getInstance().getLastName())
                .fillCity(LoremIpsum.getInstance().getCity())
                .fillState(LoremIpsum.getInstance().getName())
                .fillZipCode(1200)
                .fillPhone(LoremIpsum.getInstance().getPhone())
                .fillSsn(LoremIpsum.getInstance().getPhone())
                .fillUsername(username)
                .fillPassword(username)
                .fillConfirmPassword(username)
                .clickRegisterBtn();
    }
}
