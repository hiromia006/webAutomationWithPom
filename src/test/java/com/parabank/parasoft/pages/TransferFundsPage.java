package com.parabank.parasoft.pages;

import com.parabank.parasoft.util.General;
import com.parabank.parasoft.util.ParaBankString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TransferFundsPage extends BasePage {
    public TransferFundsPage(WebDriver driver) {
        super(driver);
    }

    public TransferFundsPage fillAmount(double amount) {
        General.waitForDomStable();
        getWebElement(By.id("amount")).sendKeys(String.valueOf(amount));
        return this;
    }

    public TransferFundsPage clickTransferBtn() {
        getWebElement(By.cssSelector("input.button")).click();
        return this;
    }

    public boolean hasTransferCompleteText() {
        return getWebElement(By.className("title")).getText().trim().contains(ParaBankString.COMPLETE);
    }
}
