package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends PageBase {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    protected abstract void enterLogin(String login);

    protected abstract void enterPassword(String password);

    protected abstract AccountPageBase clickLogin();

    public abstract AccountPageBase performLogin(String login, String password);
}
