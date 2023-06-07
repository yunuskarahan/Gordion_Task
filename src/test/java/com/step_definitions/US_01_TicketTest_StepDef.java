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

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class US_01_TicketTest_StepDef {

    HomePage homePage = new HomePage();
    PlanetTicketPage planetTicketPage = new PlanetTicketPage();
    Actions actions = new Actions(Driver.getDriver());

    @Given("the user is on the home page")
    public void theUserIsOnTheHomePage() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }
    @Then("the user should see {string} in the title of the homepage")
    public void theUserShouldSeeInTheTitleOfTheHomepage(String expectedHomePageTitle) {
        BrowserUtils.waitForPageToLoad(10);

        assertEquals(expectedHomePageTitle,homePage.homePageTittle.getAttribute("title"));

    }

    @When("the user click Uçak Bileti link")
    public void theUserClickUçakBiletiLink() {
       BrowserUtils.waitForClickablility(homePage.uçakBiletiLink,10);
        homePage.uçakBiletiLink.click();
    }

    @Then("the user should see Uçak Bileti Page")
    public void theUserShouldSeeUçakBiletiPage() {
        String expectedUçakBiletiPageUrl ="https://www.jollytur.com/ucak-bileti";
        BrowserUtils.verifyURLContains(expectedUçakBiletiPageUrl);
        
    }

    @And("the user clicks on the round trip button")
    public void theUserClicksOnTheRoundTripButton() {
        if (planetTicketPage.roundTrip.isSelected()){
            assertTrue(planetTicketPage.roundTrip.isSelected());
        }else {
            planetTicketPage.roundTrip.click();
        }

    }

    @Then("the user should see the Dönüş Tarihi Option")
    public void theUserShouldSeeTheDönüşTarihiOption() {
        assertTrue(planetTicketPage.dönüşTarihi.isDisplayed());
    }

    @And("the user clicks on the Nereden input")
    public void theUserClicksOnTheNeredenInput() {

      try{
          planetTicketPage.popUp.isDisplayed();
          BrowserUtils.waitForClickablility(planetTicketPage.izinVerButton,5);
          planetTicketPage.izinVerButton.click();
          actions.moveToElement(planetTicketPage.neredenButton).click().perform();

      }catch (Exception e){

          actions.moveToElement(planetTicketPage.neredenButton).click().perform();
      }




      /*  if (planetTicketPage.popUp.isDisplayed()){
            BrowserUtils.waitForClickablility(planetTicketPage.izinVerButton,5);
            planetTicketPage.izinVerButton.click();
            BrowserUtils.waitForClickablility(planetTicketPage.neredenButton,5);
            planetTicketPage.neredenButton.click();
        }else {
            BrowserUtils.waitForClickablility(planetTicketPage.neredenButton,5);
            planetTicketPage.neredenButton.click();
        }*/



    }

    @And("the user types From {string}")
    public void theUserTypesFrom(String fromInput) {
        planetTicketPage.neredenButton.sendKeys(fromInput);
    }

    @And("the user presses the down key and  tab key on the keyboard")
    public void theUserPressesTheDownKeyAndTabKeyOnTheKeyboard() {
        planetTicketPage.neredenButton.sendKeys(Keys.ARROW_DOWN , Keys.ARROW_DOWN , Keys.TAB);
    }
    @And("the user types To {string}")
    public void theUserTypesTo(String toInput) {
        planetTicketPage.nereyeButton.sendKeys(toInput);

    }

    @And("the user click Gidiş Tarihi")
    public void theUserClickGidişTarihi() {
        BrowserUtils.waitForClickablility(planetTicketPage.dateRow,5);
        actions.moveToElement(planetTicketPage.dateRow).click().perform();
    }

    @And("user chooses departure date June 13 th")
    public void userChoosesDepartureDateJune13Th() {

        BrowserUtils.clickWithJS(planetTicketPage.firsDate);

    }

    @And("user chooses return date June 20 th")
    public void userChoosesReturnDateJune20Th() {

        BrowserUtils.clickWithJS(planetTicketPage.lastDate);
    }

    @And("user selects the number of passengers as adult {string}")
    public void userSelectsTheNumberOfPassengersAsAdult(String expextedPassengers) {
        assertEquals(expextedPassengers,planetTicketPage.personNumber.getText());
    }

    @And("user click Hemen Ara Button")
    public void userClickHemenAraButton() {
        BrowserUtils.waitForClickablility(planetTicketPage.hemenAraButton,5);
        planetTicketPage.hemenAraButton.click();
    }

    @Then("user should see {string} title")
    public void userShouldSeeTitle(String expectedResultTitle) {
        BrowserUtils.waitForPageToLoad(5);

    }
}
