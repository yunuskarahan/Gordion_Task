package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@class='logo']")
    public WebElement homePageTittle;

    @FindBy(xpath = "//div[@class=\'tabs-area\']/span[@data-index=\'6\']")
    public WebElement uçakBiletiOptions;

    @FindBy(linkText = "Uçak Bileti")
    public WebElement uçakBiletiLink;
















}
