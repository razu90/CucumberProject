package page_objects;

import command_providers.Action;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RealApr {
    private final By RateLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");
    private final By Calculator = By.xpath("//label[text()='Calculator']");
    private final By HomePrice = By.name("HomeValue");
    private final By PaymentType = By.id("DownPaymentSel0");
    private final By DownPayment = By.name("DownPayment");
    private final By InterestRate = By.name("Interest");
    private final By YersOfLoan = By.name("Length");
    private final By DiscountPoint = By.name("Points");
    private final By LoanOriginationFees = By.name("Loan Origination Fees: ");
    private final By OtherClosingCosts = By.name("Closing");
    private final By CalculateButton = By.name("calculate");
    private final By ActualAPR = By.xpath("//*[@id=\"analysisDiv\"]/table/tbody/tr/td/strong[text()='Actual APR:']/../../td[2]/strong");

    private static final Logger LOGGER = LogManager.getLogger(RealApr.class);

    public WebDriver driver;

    public RealApr (WebDriver driver) {
        this.driver = driver;
    }

    public RealApr WaitForPage() {
        Action.wait(driver,Calculator).waitForElementToBeVisible();
        return this;
    }

    public RealApr enterHomePrice (String value) {
        LOGGER.debug("Enter home price" +value);
     Action.element(driver, HomePrice).setValue("900000");
     return this;
 }
     public RealApr selectPaymentType () {
     Action.element(driver,PaymentType).click();
     return this;
 }
     public RealApr enterDownPayment (String value) {
     LOGGER.debug("Enter Down payment" +value);
     Action.element(driver, DownPayment).setValue("200000");
     return this;
 }
     public RealApr enterInterestRate (String Value) {
        LOGGER.debug("Enter Apr" +Value);
     Action.element(driver,InterestRate).setValue("3.5");
     return this;
 }
   public RealApr clickCalculatorButton () {
    Action.element(driver,CalculateButton).click();
    return this;
}
        public RealApr validateRealApr(String expectedAprRate) {
            String actualRealAprRate = driver.findElement(ActualAPR).getText();
            Assert.assertEquals(expectedAprRate, actualRealAprRate);
            return this;
        }
}

