package com.parabank.parasoft.testcase;

import com.parabank.parasoft.pages.CustomerLoginPage;
import com.parabank.parasoft.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerLoginTest extends BaseTest {
    @Test
    public void loginShouldFailWithoutCredential() {
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class)
                .doLogin();
        Assert.assertTrue(loginPage.hasError());
    }

    @Test
    public void loginShouldFailWithoutPassword() {
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class)
                .doLogin("sqa");
        Assert.assertTrue(loginPage.hasError());
    }

    @Test
    public void loginShouldSucceed() {
        HomePage homePage = page.getInstance(CustomerLoginPage.class)
                .fillUsername("sqa")
                .fillPassword("sqa")
                .clickLoginBtn();
        Assert.assertTrue(homePage.hasLogoutLink());
    }

    @Test
    public void loginShouldSucceed2() {
        HomePage homePage = page.getInstance(CustomerLoginPage.class)
                .doLogin("sqa", "sqa");
        Assert.assertTrue(homePage.hasLogoutLink());
    }
}
