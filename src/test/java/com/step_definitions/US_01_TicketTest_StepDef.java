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

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.security.Key;

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




      /* if (planetTicketPage.popUp.isDisplayed()){
            BrowserUtils.waitForClickablility(planetTicketPage.izinVerButton,5);
            planetTicketPage.izinVerButton.click();
            BrowserUtils.waitForClickablility(planetTicketPage.neredenButton,5);
            planetTicketPage.neredenButton.click();
        }else {
            BrowserUtils.waitForClickablility(planetTicketPage.neredenButton,5);
            planetTicketPage.neredenButton.click();
        }
*/


    }

    @And("the user types From {string}")
    public void theUserTypesFrom(String fromInput) {
        planetTicketPage.neredenButton.sendKeys(fromInput);
        BrowserUtils.waitFor(2);
        planetTicketPage.neredenButton.sendKeys(Keys.DOWN,Keys.ENTER);
    }

    @And("the user types To {string}")
    public void theUserTypesTo(String toInput) {
        planetTicketPage.nereyeButton.sendKeys(toInput);
        BrowserUtils.waitFor(2);
        planetTicketPage.nereyeButton.sendKeys( Keys.TAB);

    }

    @And("the user click Gidiş Tarihi")
    public void theUserClickGidişTarihi() {
      /*  BrowserUtils.waitFor(2);

        WebElement dateArea = Driver.getDriver().findElement(By.className("first-date"));
        dateArea.click();*/
    }

    @And("user chooses departure date June 13 th")
    public void userChoosesDepartureDateJune13Th() {


        BrowserUtils.waitFor(2);


            String formattedFullDate = planetTicketPage.getFormattedFullDateByDayCount(9);
            String cssSelector = "[data-fulldate='"+formattedFullDate+"']";

        BrowserUtils.waitFor(2);

        WebElement willSelectDateElement = Driver.getDriver().findElement(By.cssSelector(cssSelector));

        BrowserUtils.waitForClickablility(willSelectDateElement,2);
            willSelectDateElement.click();







    }

    @And("user chooses return date June 20 th")
    public void userChoosesReturnDateJune20Th() {

        BrowserUtils.waitFor(1);

        String formattedFullDate = planetTicketPage.getFormattedFullDateByDayCount(12);
        String cssSelector = "[data-fulldate='"+formattedFullDate+"']";

        WebElement willSelectDateElement = Driver.getDriver().findElement(By.cssSelector(cssSelector));
        BrowserUtils.clickWithJS(willSelectDateElement);
    }

    @And("user selects the number of passengers as adult {string}")
    public void userSelectsTheNumberOfPassengersAsAdult(String expextedPassengers) {
      //  assertEquals(expextedPassengers,planetTicketPage.personNumber.getText());
    }

    @And("user click Hemen Ara Button")
    public void userClickHemenAraButton() {
        actions.moveToElement(planetTicketPage.hemenAraButton).click();
    }

    @Then("user should see {string} title")
    public void userShouldSeeTitle(String expectedResultTitle) {
        BrowserUtils.waitFor(5);
        BrowserUtils.scrollToElement(planetTicketPage.resultTitle);
        String a = planetTicketPage.resultTitle.getText();
        System.out.println(a);
        assertEquals(expectedResultTitle,planetTicketPage.resultTitle.getText());

    }
}
