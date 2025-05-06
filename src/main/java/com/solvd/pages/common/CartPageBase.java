package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class CartPageBase extends PageBase {

    public CartPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getProductName(int index);

    public abstract String getProductQuantity(int index);
}
