package page_objects;

import command_providers.Action;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {

    private final By HomePage = By.xpath("//a/img[@alt='Logo']");
    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");

    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);

    public WebDriver driver;
    public NavigationBar (WebDriver driver) {
        this.driver = driver;
    }

//Navigate to the Home Page

    public Home navigateToHome() {
        LOGGER.debug("Go to the Home Page");
        Action.element(driver, HomePage).click();
        return new Home(driver);
    }


//Mouse Hover to the Rates Link

        public NavigationBar mouseHoverToRates() {
        LOGGER.debug("Mouse hover to rate link");
        Action.element(driver, RatesLink).mouseHover();
        return this;
        }


//Navigate to the Real APR page
        public RealApr navigateToRealApr () {
        LOGGER.debug("Navigate to real apr");
        Action.element(driver, RealAprLink).click();
        return new RealApr(driver);
            }


        }


