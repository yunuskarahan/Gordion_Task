package com.step_definitions;

import com.pages.HomePage;
import com.pages.PlanetTicketPage;
import com.utilities.BrowserUtils;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.interactions.Actions;

public class US_01_TicketTest_StepDef {

    HomePage homePage = new HomePage();
    PlanetTicketPage planetTicketPage = new PlanetTicketPage();
    Actions actions = new Actions(Driver.getDriver());

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        BrowserUtils.waitForPageToLoad(10);
    }
    @Then("the user should see {string} in the title of the homepage")
    public void theUserShouldSeeInTheTitleOfTheHomepage(String expectedHomePageTitle) {
        String actualHomePageTitle = homePage.homePageTittle.getText();
        assertEquals(expectedHomePageTitle,actualHomePageTitle);

    }

    @When("the user click Uçak Bileti link")
    public void theUserClickUçakBiletiLink() {
       BrowserUtils.waitForClickablility(homePage.uçakBiletiLink,10);
        homePage.uçakBiletiLink.click();
    }

    @Then("the user should see Uçak Bileti Page")
    public void theUserShouldSeeUçakBiletiPage() {
        
    }

    @And("the user clicks on the round trip button")
    public void theUserClicksOnTheRoundTripButton() {
    }

    @Then("the user should see the Dönüş Tarihi Option")
    public void theUserShouldSeeTheDönüşTarihiOption() {
    }

    @And("the user clicks on the Nereden input")
    public void theUserClicksOnTheNeredenInput() {
    }

    @And("the user types From {string}")
    public void theUserTypesFrom(String fromInput) {
    }

    @And("the user presses the down key and  tab key on the keyboard")
    public void theUserPressesTheDownKeyAndTabKeyOnTheKeyboard() {
    }
    @And("the user types To {string}")
    public void theUserTypesTo(String toInput) {
    }

    @And("the user click Gidiş Tarihi")
    public void theUserClickGidişTarihi() {
    }

    @And("user chooses departure date June 13 th")
    public void userChoosesDepartureDateJune13Th() {
    }

    @And("user chooses return date June 20 th")
    public void userChoosesReturnDateJune20Th() {
    }

    @And("user selects the number of passengers as adult {int}")
    public void userSelectsTheNumberOfPassengersAsAdult(int expextedPassengers) {
    }

    @And("user click Hemen Ara Button")
    public void userClickHemenAraButton() {
    }

    @Then("user should see {string} title")
    public void userShouldSeeTitle(String expectedResultTitle) {
    }
}
