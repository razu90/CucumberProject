package step_definitions;

import command_providers.Action;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import page_objects.NavigationBar;
import page_objects.RealApr;
import utilities.ReadConfigFiles;

import java.util.List;
import java.util.Map;

public class RealAprSteps {
    WebDriver driver = Hooks.driver;


    @Given("^user is in mortgage calculator home page$")
    public void navigateToMortgageCalculatorHomePage() {
        Action.browserActions(driver).openBrowser(ReadConfigFiles.getPropertyValues("MortgageUrl"));
    }

    @And("^user is navigated to Real Apr page$")
    public void navigateToRealAprPage() {
        new NavigationBar(driver)
                .mouseHoverToRates()
                .navigateToRealApr();
    }

    @When("^user click on calculate button upon entering the data$")
    public void clicksCalculateButtonUponEnteringTheData(DataTable table) {
        List<Map<String, String>> dataTable = table.asMaps(String.class, String.class);
        for (Map<String, String> cells : dataTable) {
            new RealApr(driver)
                    .enterHomePrice(cells.get("HomePrice"))
                    .enterDownPayment(cells.get("Down Payment"))
                    .enterInterestRate(cells.get("InterestRate"))
                    .clickCalculatorButton();
        }
    }

    @Then("the real apr rate is \"(.+?)\"$")
    public void validateRealAprRate(String realApr) {
        new RealApr(driver)
                .validateRealApr(realApr);

    }
}
