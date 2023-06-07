package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlanetTicketPage extends BasePage {

    public PlanetTicketPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "travelDestinationDepartureSearch")
    public WebElement neredenButton;

    @FindBy(id = "travelDestinationReturnSearch")
    public WebElement nereyeButton;

    @FindBy(xpath = "//div[@class='list date completed']/div[@class='date-row']")
    public WebElement dateRow;

    @FindBy(xpath = "//div[@class='col last-date returning ']")
    public WebElement dönüşTarihi;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td[@class=' highlight selected' and @data-fulldate='6132023']")
    public WebElement firsDate;

    @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td[@class=' highlight selected' and @data-fulldate='6202023']")
    public WebElement lastDate;

    @FindBy(xpath = "//div[@class='in-button']/span[@class='big-title active']")
    public WebElement personNumber;

    @FindBy(xpath = "(//div[@class='list action-button'])[7]")
    public WebElement hemenAraButton;

    @FindBy(xpath = "(//div[@class='in']/span)[1]")
    public WebElement roundTrip;

    @FindBy(xpath = "//div[@style='display: table-row;']")
    public WebElement popUp;

    @FindBy(id = "web_push_evet")
    public WebElement izinVerButton;

}
