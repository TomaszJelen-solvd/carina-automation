package com.solvd.pages.desktop;

import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.HomePageBase;
import com.solvd.pages.common.LoginPageBase;
import com.solvd.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase {
    @FindBy(css = "a.menu_home")
    private ExtendedWebElement homeButton;

    @FindBy(id = "main_menu")
    private ExtendedWebElement homeMenu;

    @FindBy(xpath = "//a[text()='Login or register']")
    private ExtendedWebElement loginButton;

    @FindBy(id = "filter_keyword")
    private ExtendedWebElement searchInput;

    @FindBy(className = "button-in-search")
    private ExtendedWebElement searchButton;

    @FindBy(className = "block_7")
    private ExtendedWebElement cartButton;

    @FindBy(className = "productcart")
    private List<ExtendedWebElement> productNames;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void hoverOverHomeButton() {
        hoverOver(homeButton);
    }

    @Override
    public boolean isHomeMenuVisible() {
        return isDisplayed(homeMenu);
    }

    @Override
    public void enterSearchQuery(String query) {
        sendKeys(searchInput, query);
    }

    @Override
    public void addProductToCart(int index) {
        clickElement(productNames.get(index));
    }

    @Override
    public void addSeveralProductsToCart(int index, int quantity) {
        for (int i = 0; i < quantity; i++) {
            addProductToCart(index);
        }
    }

    @Override
    public LoginPageBase clickLogin() {
        clickElement(loginButton);
        return initPage(driver, LoginPageBase.class);
    }

    @Override
    public CartPageBase clickCart() {
        clickElement(cartButton);
        return initPage(driver, CartPageBase.class);
    }

    @Override
    public SearchPageBase clickSearch() {
        clickElement(searchButton);
        return initPage(driver, SearchPageBase.class);
    }


}
