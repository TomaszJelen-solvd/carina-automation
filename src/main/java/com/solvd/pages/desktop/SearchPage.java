package com.solvd.pages.desktop;


import com.solvd.pages.common.SearchPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.DESKTOP, parentClass = SearchPageBase.class)
public class SearchPage extends SearchPageBase {
    @FindBy(className = "prdocutname")
    private List<ExtendedWebElement> productNames;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean areAllProductNamesMatching(String name) {
        if(StringUtils.isEmpty(name)) {
            logger.info("Attempted check with empty name of product");
            return false;
        }
        List<ExtendedWebElement> displayedProductNames = productNames.stream().filter(this::isDisplayed).toList();
        for (ExtendedWebElement productName : displayedProductNames) {
            String productText = getText(productName);
            logger.info("Checking name of product: {}", productText);
            if(!productText.toLowerCase().contains(name.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

}
