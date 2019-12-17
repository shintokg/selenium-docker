package com.newtours.pages;

import com.newtours.pages.RegistrationPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistarationConrimationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "sign-in")
    private WebElement signintext;

    @FindBy(linkText = "Flights")
    private WebElement flights;

    public RegistarationConrimationPage(WebDriver driver){
        this.driver=driver;
        wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void flightdetailpage(){
        wait.until(ExpectedConditions.visibilityOf(this.signintext));
        this.flights.click();
    }
}

