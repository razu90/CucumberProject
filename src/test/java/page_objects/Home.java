package page_objects;

import command_providers.Action;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {
    private final By InputHomeValue = By.id("homeval");
    private final By DownPayment = By.id("downpayment");
    private final By SelectPaymentType = By.name("param[downpayment_type]");
    private final By AmountOfLoan = By.id("loanamt");
    private final By APR = By.id("intrstsrate");
    private final By YearsOfLoan = By.id("loanterm");
    private final By StartMonth = By.name("param[start_month]");
    private final By StartYear = By.id("start_year");
    private final By TAX = By.id("pptytax");
    private final By PMI = By.id("pmi");
    private final By HomeIns = By.id("hoi");
    private final By HOA = By.id("hoa");
    private final By LoanType = By.name("param[milserve]");
    private final By BuyOrRefi = By.name("param[refiorbuy]");
    private final By Calculator = By.name("cal");

    private static final Logger LOGGER = LogManager.getLogger(Home.class);

    public WebDriver driver;

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public Home enterHomePrice (String value) {
        LOGGER.debug("Enter the home price" +value);
        Action.element(driver, InputHomeValue).setValue("900000");
        return this;
    }
    public Home enterDownPayment (String value) {
        LOGGER.debug("Enter the down payment" +value);
        Action.element(driver,DownPayment).setValue("200000");
        return this;
    }
    public Home selectDownPaymentInDollar () {
        LOGGER.debug("Select the dollar sign");
        Action.element(driver, SelectPaymentType).click();
        return this;
    }
    public Home enterAmountOfLoan (String value) {
        LOGGER.debug("Enter Loan amount" +value);
        Action.element(driver,AmountOfLoan).setValue("700000");
        return this;
    }
    public Home enterApr (String value) {
        LOGGER.debug("Enter Apr" + value);
        Action.element(driver,APR).setValue("3.5");
        return this;
    }
    public Home enterYearsOfLoan (String value) {
        LOGGER.debug("Enter Years Of Loan" +value);
        Action.element(driver,YearsOfLoan).setValue("30");
        return this;
    }
    public Home selectMonth (String month) {
        LOGGER.debug("Select month" +month);
        Action.element(driver,StartMonth).selectValue("Mar");
        return this;
    }
    public Home selectYear (String year) {
        LOGGER.debug("Select year" +year);
        Action.element(driver,StartYear).setValue("2022");
        return this;
    }
    public Home enterPropertyTax (String value) {
        LOGGER.debug("Enter yearly TAX" +value);
        Action.element(driver,TAX).setValue("10000");
        return this;
    }
    public Home enterPmi (String value) {
        LOGGER.debug("Enter Pmi" +value);
        Action.element(driver,PMI).setValue("0.5");
        return this;
    }
    public Home enterHomeInsurance (String value) {
        LOGGER.debug("Enter Monthly Home Insurance" +value);
        Action.element(driver,HomeIns).setValue("1000");
        return this;
    }
    public Home enterHoa (String value) {
        LOGGER.debug("Enter monthly HOA" +value);
        Action.element(driver,HOA).setValue("500");
        return this;
    }
    public Home selectLoanType (String value) {
        LOGGER.debug("Select loan type" +value);
        Action.element(driver,LoanType).selectValue("FHA");
        return this;
    }
    public Home selectBuyOrRefOption (String value) {
        LOGGER.debug("Select Type" +value);
        Action.element(driver,BuyOrRefi).selectValue("Buy");
        return this;
    }
    public Home clickCalculator () {
        LOGGER.debug("Click on calculator");
        Action.element(driver,Calculator).click();
        return this;
    }
    public Home validateTotalMonthlyPayment(String expectedTotalMonthlyPayment) {
        String formattedXpath = String.format("//h3[text()='$%s']", expectedTotalMonthlyPayment);
        By monthlyPayment = By.xpath(formattedXpath);
LOGGER.debug("Validating that the total monthly payment is" + expectedTotalMonthlyPayment);
        AssertThat.elementAssertions(driver,monthlyPayment).elementIsDisplayed();
        return this;

    }
}
