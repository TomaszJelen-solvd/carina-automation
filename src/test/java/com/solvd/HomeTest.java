package com.solvd;

import com.solvd.pages.common.HomePageBase;
import com.solvd.pages.common.SearchPageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

//Implementation of Web Automation Java Task 1
public class HomeTest extends AbstractTest {
    @Test
    public void testDisplayMainMenuOnHover() {
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.open();

        homePage.hoverOverHomeButton();
        Assert.assertTrue(homePage.isHomeMenuVisible(), "Main menu was not visible after hovering over Home button");
    }

//    CID1
    @Test
    public void testDisplaySearchedProducts() {
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.open();

        String productName = "bronzer";
        homePage.enterSearchQuery(productName);
        SearchPageBase searchPage = homePage.clickSearch();
        Assert.assertTrue(searchPage.areAllProductNamesMatching(productName), "Failed to find only searched product");
    }


}
