package com.parabank.parasoft.testcase;

import com.parabank.parasoft.pages.CustomerLoginPage;
import com.parabank.parasoft.pages.HomePage;
import com.parabank.parasoft.util.ParaBankString;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerLoginTest extends BaseTest {
    @Test(description = "Provide invalid username & Password")
    public void loginShouldFailWithoutCredential() {
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class)
                .doLogin();
        Assert.assertTrue(loginPage.hasError());
    }

    @Test
    public void loginShouldFailWithoutPassword() {
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class)
                .doLogin(getUsername());
        Assert.assertTrue(loginPage.hasError());
    }

    @Test
    public void verifyLoginPageTittle() {
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);
        Assert.assertEquals(loginPage.getPageTittle(), ParaBankString.LOGIN_TITLE);
    }

    @Test(enabled = true)
    public void loginShouldSucceed() {
        HomePage homePage = page.getInstance(CustomerLoginPage.class)
                .fillUsername(getUsername())
                .fillPassword(getPassword())
                .clickLoginBtn();
        Assert.assertTrue(homePage.hasLogoutLink());
    }

    @Test(enabled = false)
    public void loginShouldSucceed2() {
        HomePage homePage = page.getInstance(CustomerLoginPage.class)
                .doLogin(getUsername(), getPassword());
        Assert.assertTrue(homePage.hasLogoutLink());
    }
}
