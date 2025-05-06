package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public abstract class HomePageBase extends PageBase {

    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void hoverOverHomeButton();

    public abstract boolean isHomeMenuVisible();

    public abstract void enterSearchQuery(String query);

    public abstract void addProductToCart(int index);

    public void addSeveralProductsToCart(int index, int quantity) {
        for (int i = 0; i < quantity; i++) {
            addProductToCart(index);
        }
    }

    public void addProductsToCart(List<Map.Entry<Integer, Integer>> products) {
        for(Map.Entry<Integer,Integer> product : products) {
            addSeveralProductsToCart(product.getKey(), product.getValue());
        }
    }

    public abstract LoginPageBase clickLogin();

    public abstract CartPageBase clickCart();

    public abstract SearchPageBase clickSearch();

}
