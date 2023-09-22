package com.parabank.parasoft.testcase;

import com.parabank.parasoft.pages.CustomerLoginPage;
import com.parabank.parasoft.pages.HomePage;
import com.parabank.parasoft.pages.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
    @Test
    public void registerShouldSucceed() {
        HomePage homePage = page.getInstance(CustomerLoginPage.class)
                .clickRegistrationLink()
                .doRegistration();
        Assert.assertTrue(homePage.hasLogoutLink());

    }

    @Test
    public void registerWithOutRequiredShouldFail() {
        RegisterPage registerPage = page.getInstance(CustomerLoginPage.class)
                .clickRegistrationLink()
                .clickRegisterLink();
        Assert.assertTrue(registerPage.hasError());
    }
}
