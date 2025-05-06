package com.solvd.pages.common;

import org.openqa.selenium.WebDriver;

public abstract class SearchPageBase extends PageBase {

    public SearchPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean areAllProductNamesMatching(String name);
}
