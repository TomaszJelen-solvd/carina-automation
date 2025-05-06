package com.solvd;

import com.solvd.pages.common.CartPageBase;
import com.solvd.pages.common.HomePageBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static com.solvd.ProductService.*;


public class CartTest extends AbstractTest {
    //    CID1
    @Test
    public void testDisplayChosenProductInCart() {
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.open();

        homePage.addProductToCart(SKINSHEEN_BRONZER_STICK.getIndex());
        CartPageBase cartPage = homePage.clickCart();
        Assert.assertEquals(cartPage.getProductName(0), SKINSHEEN_BRONZER_STICK.getName(), "Failed to display correct product");
        Assert.assertEquals(cartPage.getProductQuantity(0), "1", "Failed to display correct product quantity");
    }

//    CID2
    @Test
    public void testDisplayDifferentChosenProductsInCart() {
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.open();

        homePage.addProductToCart(SKINSHEEN_BRONZER_STICK.getIndex());
        homePage.addProductToCart(TREATMENT_SPF_15.getIndex());
        CartPageBase cartPage = homePage.clickCart();
        assertProductsInCart(cartPage, new LinkedHashMap(Map.of(
                SKINSHEEN_BRONZER_STICK.getName(), "1",
                TREATMENT_SPF_15.getName(), "1"
        )));
    }

//    CID3
    @Test
    public void testDisplayDifferentMultipleChosenProductsInCart() {
        HomePageBase homePage = initPage(driver, HomePageBase.class);
        homePage.open();

        homePage.addSeveralProductsToCart(SKINSHEEN_BRONZER_STICK.getIndex(), 2);
        homePage.addProductToCart(TREATMENT_SPF_15.getIndex());
        CartPageBase cartPage = homePage.clickCart();
        assertProductsInCart(cartPage, new LinkedHashMap(Map.of(
                SKINSHEEN_BRONZER_STICK.getName(), "2",
                TREATMENT_SPF_15.getName(), "1"
                )));
    }

    private static void assertProductsInCart(CartPageBase cartPage, LinkedHashMap<String, String> expectedProducts) {
        int i = 0;
        for(Map.Entry<String, String> entry : expectedProducts.entrySet()) {
            Assert.assertEquals(cartPage.getProductName(i), entry.getKey(), "Failed to display correct product");
            Assert.assertEquals(cartPage.getProductQuantity(i), entry.getValue(), "Failed to display correct product quantity");
            i++;
        }
    }
}
