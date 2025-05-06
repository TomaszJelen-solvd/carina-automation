package com.solvd.pages.common;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public abstract class PageBase extends AbstractPage {
    public static final int TIMEOUT = 2;
    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public PageBase(WebDriver driver) {
        super(driver);
    }

    protected void hoverOver(ExtendedWebElement element) {
        waitForElementToBeVisible(element, TIMEOUT);
//        Actions action = new Actions(driver);
//        action.moveToElement(element).perform();
        element.hover();
        logger.info("Performed hovering over element: {}", element);
    }

    protected boolean isDisplayed(ExtendedWebElement element) {
        logger.info("Performing display check for element: {}", element);
        return element.isDisplayed();
    }

    protected void sendKeys(ExtendedWebElement element, String query) {
        waitForElementToBeVisible(element, TIMEOUT);
        element.type(query);
        logger.info("Performed sending keys to element: {}", element);
    }

    protected void clickElement(ExtendedWebElement element) {
        waitForElementToBeVisible(element, TIMEOUT);
        element.click();
        logger.info("Performed element clicking");
    }

    protected String getText(ExtendedWebElement element) {
        waitForElementToBeVisible(element, TIMEOUT);
        return element.getText();
    }

    protected String getValue(ExtendedWebElement element) {
        logger.info("Performed value reading");
        waitForElementToBeVisible(element, TIMEOUT);
        return element.getAttribute("value");
    }

    private void waitForElementToBeVisible(ExtendedWebElement element, int timeout) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
