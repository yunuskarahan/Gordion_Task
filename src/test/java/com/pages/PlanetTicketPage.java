package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlanetTicketPage extends BasePage{

    public PlanetTicketPage(){
        PageFactory.initElements(Driver.getDriver(),this);}

        @FindBy(xpath = "//div[@class='element-list']//div[@class='list destination-departure completed']")
        public WebElement neredenButton;

        @FindBy(xpath = "//div[@class='list date completed']/div[@class='date-row']")
        public WebElement dateRow;

        @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td[@class=' highlight selected' and @data-fulldate='6132023']")
        public WebElement firsDate;

        @FindBy(xpath = "//table[@class='ui-datepicker-calendar']/tbody/tr/td[@class=' highlight selected' and @data-fulldate='6202023']")
        public WebElement lastDate;

        @FindBy(xpath = "//div[@class='in-button']/span[@class='big-title active']")
        public WebElement personNumber;

        @FindBy(xpath = "(//div[@class='list action-button'])[7]")
        public WebElement hemenAraButton;

}
