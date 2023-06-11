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

    @FindBy(css = "div[class='list date completed']")
    public WebElement dateRow;

    @FindBy(xpath = "//div[@class='col last-date returning ']")
    public WebElement dönüşTarihi;

    @FindBy(xpath = "//div[@id='flyDatepicker']//div//table//tr//td/a[.='23']")
    public WebElement firsDate;

    @FindBy(xpath = "//div[@id='flyDatepicker']//div//table//tr//td/a[.='27']")
    public WebElement lastDate;

    @FindBy(xpath = "//div[@class='in-button']/span[@class='big-title active']")
    public WebElement personNumber;

    @FindBy(xpath = "//div[@class='list action-button']")
    public WebElement hemenAraButton;

    @FindBy(xpath = "(//div[@class='in']/span)[1]")
    public WebElement roundTrip;

    @FindBy(xpath = "//div[@style='display: table-row;']")
    public WebElement popUp;

    @FindBy(id = "web_push_evet")
    public WebElement izinVerButton;


    @FindBy(xpath = "//div[@class='title']/h1")
    public  WebElement resultTitle;




}
