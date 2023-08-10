package com.parabank.parasoft.testcase;

import com.parabank.parasoft.pages.CustomerLoginPage;
import com.parabank.parasoft.pages.TransferFundsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TransferFundsTest extends BaseTest {

    @Test(enabled = false)
    public void transferFundShouldSucceed() {
        TransferFundsPage transferFundsPage = page.getInstance(CustomerLoginPage.class)
                .doLogin(getUsername(), getPassword())
                .clickTransferFundsLink()
                .fillAmount(5000.00)
                .clickTransferBtn();
        Assert.assertTrue(transferFundsPage.hasTransferCompleteText());
    }
}
