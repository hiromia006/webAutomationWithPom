package com.parabank.parasoft.testcase;

import com.parabank.parasoft.pages.CustomerLoginPage;
import com.parabank.parasoft.pages.HomePage;
import com.parabank.parasoft.pages.OpenNewAccountPage;
import com.parabank.parasoft.util.ParaBankString;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountTest extends BaseTest {
    @Test
    public void openAccountShouldSucceed() {
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);
       Assert.assertEquals(loginPage.getPageTittle(), ParaBankString.LOGIN_TITLE);

        HomePage homePage = loginPage
                .doLogin(getUsername(), getPassword());
        Assert.assertTrue(homePage.hasLogoutLink());

        OpenNewAccountPage openNewAccountPage = homePage
                .clickOpenAccountLink()
                .selectAccountType(1)
                .clickOpenAccountBtn();
        Assert.assertTrue(openNewAccountPage.hasAccountId());

    }

    @Test
    public void openAccount2ShouldSucceed() {
        OpenNewAccountPage openNewAccountPage = page.getInstance(CustomerLoginPage.class)
                .doLogin(getUsername(), getPassword())
                .clickOpenAccountLink()
                .selectAccountType(1)
                .clickOpenAccountBtn();
        Assert.assertTrue(openNewAccountPage.hasAccountId());
    }
}