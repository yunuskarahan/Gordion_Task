package com.pages;
import java.time.LocalDate;
import com.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.LocalDateTime;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css="div[class='loader-mask shown']")
    @CacheLookup
    protected WebElement loaderMask;

    public void waitUntilLoaderScreenDisappear() {
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 25);
            wait.until(ExpectedConditions.invisibilityOf(loaderMask));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @FindBy(xpath = "//div[@class='bar']")
    public WebElement loadingBar;

    public void waitLoadingBar(){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.invisibilityOf(loadingBar));
    }

    public String getFormattedFullDateByDayCount(int dayCount){
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");

        LocalDate currentDate = LocalDate.now().plusDays(dayCount);
        System.out.println(currentDate.toString());

        var tempArr = currentDate.toString().split("-");

        var year = tempArr[0].toString();

        var month = tempArr[1].toString();

        if(month.startsWith("0")){
            month = month.replace("0","");
        }

        var day = tempArr[2].toString();

        if(day.startsWith("0")){
            day = day.replace("0","");
        }

        String fullDate = month + day + year;

        return fullDate;
    }

}


