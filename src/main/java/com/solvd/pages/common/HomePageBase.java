package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends PageBase {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void hoverOverHomeButton();

    public abstract boolean isHomeMenuVisible();

    public abstract void enterSearchQuery(String query);

    public abstract void addProductToCart(int index);

    public abstract void addSeveralProductsToCart(int index, int quantity);

    public abstract LoginPageBase clickLogin();

    public abstract CartPageBase clickCart();

    public abstract SearchPageBase clickSearch();

}
