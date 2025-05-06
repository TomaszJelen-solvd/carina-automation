package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class AccountPageBase extends PageBase {

    public AccountPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getUserName();
}
