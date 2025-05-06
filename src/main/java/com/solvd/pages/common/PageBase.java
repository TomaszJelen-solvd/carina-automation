package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class PageBase extends AbstractPage {
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public PageBase(WebDriver driver) {
        super(driver);
    }

    protected void hoverOver(ExtendedWebElement element) {
        element.hover();
        logger.info("Performed hovering over element: {}", element);
    }

    protected boolean isDisplayed(ExtendedWebElement element) {
        logger.info("Performing display check for element: {}", element);
        return element.isDisplayed();
    }

    protected void sendKeys(ExtendedWebElement element, String query) {
        element.type(query);
        logger.info("Performed sending keys to element: {}", element);
    }

    protected void clickElement(ExtendedWebElement element) {
        element.click();
        logger.info("Performed element clicking");
    }

    protected String getText(ExtendedWebElement element) {
        return element.getText();
    }

    protected String getValue(ExtendedWebElement element) {
        logger.info("Performed value reading");
        return element.getAttribute("value");
    }

}
