package com.solvd.pages.desktop;

import com.solvd.pages.common.AccountPageBase;
import com.solvd.pages.common.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {
    @FindBy(id = "loginFrm_loginname")
    private ExtendedWebElement loginNameForm;

    @FindBy(id = "loginFrm_password")
    private ExtendedWebElement loginPasswordForm;

    @FindBy(xpath = "//button[@title='Login']")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected void enterLogin(String login) {
        sendKeys(loginNameForm, login);
    }

    @Override
    protected void enterPassword(String password) {
        sendKeys(loginPasswordForm, password);
    }

    @Override
    protected AccountPageBase clickLogin() {
        clickElement(loginButton);
        return initPage(driver, AccountPageBase.class);
    }

    @Override
    public AccountPageBase performLogin(String login, String password) {
        enterLogin(login);
        enterPassword(password);
        return clickLogin();
    }
}
