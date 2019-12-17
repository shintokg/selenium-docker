package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {
    private WebDriver driver;
    public WebDriverWait wait;

    @FindBy(name = "reserveFlights")
    private WebElement fistSubmitButton;

    @FindBy(name = "buyFlights")
    private WebElement buyFlights;


    public FindFlightPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);

    }

    public void submitFirstPage(){
        wait.until(ExpectedConditions.elementToBeClickable(this.fistSubmitButton));
        this.fistSubmitButton.click();
    }

    public void gotoConfirmationPage(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.buyFlights));
        this.buyFlights.click();
    }

}
