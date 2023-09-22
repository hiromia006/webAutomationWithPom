package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.General;
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

    public RegisterPage fillPhone(int phone) {
        getWebElement(By.xpath("//input[@id='customer.phoneNumber']")).sendKeys(String.valueOf(phone));
        return this;
    }

    public RegisterPage fillSsn(String ssn){

        return this;
    }

    public HomePage clickRegisterBtn() {
        getWebElement(By.cssSelector("input.button[value='Register']")).click();
        return getInstance(HomePage.class);
    }

    public Boolean hasUpdateSuccess() {
        return getWebElements(By.xpath("//h1[@class='title']")).size() > 0;
    }
}
