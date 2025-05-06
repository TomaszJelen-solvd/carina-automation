package com.solvd.pages.desktop;

import com.solvd.pages.common.CartPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = CartPageBase.class)
public class CartPage extends CartPageBase {
    @FindBy(xpath = "//td[contains(@class,'align_left')]/a")
    private List<ExtendedWebElement> productsNames;

    @FindBy(xpath = "//div[contains(@class,'input-group') and contains(@class,'input-group-sm')]/input")
    private List<ExtendedWebElement> productsQuantity;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public String getProductName(int index) {
        return getText(productsNames.get(index));
    }

    @Override
    public String getProductQuantity(int index) {
        return getValue(productsQuantity.get(index));
    }
}
