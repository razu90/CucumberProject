package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;

public class Hooks {
    private static final Logger LOGGER = LogManager.getLogger (Hooks.class);
    public static WebDriver driver;
    @Before
    public void openBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = DriverFactory.getInstance().getDriver();
        LOGGER.info("Launch Chrome Browser");
    }
        @After
        public void closeBrowser () {
            DriverFactory.getInstance().removeDriver();
            LOGGER.info("Close Chrome Browser");
        }
    }