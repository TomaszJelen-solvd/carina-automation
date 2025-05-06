package com.solvd;

import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class AbstractTest implements IAbstractTest {
    protected final Logger logger = LoggerFactory.getLogger(getClass());
    WebDriver driver;

    @Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setUp(String browser) {
        if (browser.equalsIgnoreCase("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--kiosk");
            driver = getDriver("firefox", firefoxOptions);
        } else {
            driver = getDriver();
        }
        logger.info("WebDriver created for thread: {}", Thread.currentThread().getId());
    }
}
