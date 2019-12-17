package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "passCount")
    private WebElement passcount;

    @FindBy(name = "findFlights")
    private  WebElement submitButton;

    public  FlightDetailsPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void selectPassCount(String nuberofpassengers){
        this.wait.until(ExpectedConditions.elementToBeClickable(passcount));
        Select select=new Select(passcount);
        select.selectByValue(nuberofpassengers);
    }

    public void findFlightsPage(){
        this.submitButton.click();
    }




}
