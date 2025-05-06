package com.solvd.pages.desktop;

import com.solvd.pages.common.AccountPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = AccountPageBase.class)
public class AccountPage extends AccountPageBase {
    @FindBy(className = "subtext")
    private ExtendedWebElement userName;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getUserName() {
        return getText(userName);
    }
}
