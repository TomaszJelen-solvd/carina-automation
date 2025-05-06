package com.solvd;

import com.solvd.pages.common.AccountPageBase;
import com.solvd.pages.common.HomePageBase;
import com.solvd.pages.common.LoginPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AbstractTest {

    public static final String LOGIN = "autologin";
    public static final String PASSWORD = "autopassword";
    public static final String USERNAME = "a";

    //    CID4
    @Test
    public void testCorrectLogin() {
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.open();

        LoginPageBase loginPage = homePage.clickLogin();
        AccountPageBase accountPage = loginPage.performLogin(LOGIN, PASSWORD);
        Assert.assertEquals(accountPage.getUserName(), USERNAME, "Failed to display correct username");
    }
}
