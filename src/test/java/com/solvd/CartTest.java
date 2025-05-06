package com.solvd;

import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.HomePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import static com.solvd.ProductService.*;


public class CartTest extends AbstractTest {
    //    CID1
    @Test
    public void testDisplayChosenProductInCart() {
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.open();

        homePage.addProductsToCart(List.of(
                new AbstractMap.SimpleEntry<>(SKINSHEEN_BRONZER_STICK.getIndex(), 1)
        ));
        CartPageBase cartPage = homePage.clickCart();
        assertProductsInCart(cartPage, List.of(
                new AbstractMap.SimpleEntry<>(SKINSHEEN_BRONZER_STICK.getName(), "1")
        ));
    }

//    CID2
    @Test
    public void testDisplayDifferentChosenProductsInCart() {
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.open();

        homePage.addProductsToCart(List.of(
                new AbstractMap.SimpleEntry<>(SKINSHEEN_BRONZER_STICK.getIndex(), 1),
                new AbstractMap.SimpleEntry<>(TREATMENT_SPF_15.getIndex(), 1)
        ));
        CartPageBase cartPage = homePage.clickCart();
        assertProductsInCart(cartPage, List.of(
                new AbstractMap.SimpleEntry<>(SKINSHEEN_BRONZER_STICK.getName(), "1"),
                new AbstractMap.SimpleEntry<>(TREATMENT_SPF_15.getName(), "1")
        ));
    }

//    CID3
    @Test
    public void testDisplayDifferentMultipleChosenProductsInCart() {
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.open();

        homePage.addProductsToCart(List.of(
                new AbstractMap.SimpleEntry<>(SKINSHEEN_BRONZER_STICK.getIndex(), 2),
                new AbstractMap.SimpleEntry<>(TREATMENT_SPF_15.getIndex(), 1)
        ));
        CartPageBase cartPage = homePage.clickCart();
        assertProductsInCart(cartPage, List.of(
                new AbstractMap.SimpleEntry<>(SKINSHEEN_BRONZER_STICK.getName(), "2"),
                new AbstractMap.SimpleEntry<>(TREATMENT_SPF_15.getName(), "1")
                ));
    }

    private static void assertProductsInCart(CartPageBase cartPage, List<Map.Entry<String,String>> expectedProducts) {
        int i = 0;
        for(Map.Entry<String,String> entry : expectedProducts) {
            Assert.assertEquals(cartPage.getProductName(i), entry.getKey(), "Failed to display correct product");
            Assert.assertEquals(cartPage.getProductQuantity(i), entry.getValue(), "Failed to display correct product quantity");
            i++;
        }
    }
}
