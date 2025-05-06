package com.solvd;

import com.solvd.pages.common.AccountPageBase;
import com.solvd.pages.common.HomePageBase;
import com.solvd.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {
    //    CID4
    @Test
    public void testCorrectLogin() {
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.open();

        LoginPageBase loginPage = homePage.clickLogin();
        AccountPageBase accountPage = loginPage.performLogin(R.TESTDATA.get("login"), R.TESTDATA.get("password"));
        Assert.assertEquals(accountPage.getUserName(), R.TESTDATA.get("user"), "Failed to display correct username");
    }
}
