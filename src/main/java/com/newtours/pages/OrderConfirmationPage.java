package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderConfirmationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public OrderConfirmationPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//font[contains(text(),'Confirmation')]")
    private WebElement flightconfirmationHeader;

    @FindBy(xpath = "//font[contains(text(),'USD')]")
    private List<WebElement> amounts;

    public String getPrice(){
        this.wait.until(ExpectedConditions.visibilityOf(this.flightconfirmationHeader));
        System.out.println("flightconfirmationHeader " + this.flightconfirmationHeader.getText());
        System.out.println("amount is " +this.amounts.get(1).getText());
        String price=this.amounts.get(1).getText();
        return price;


    }


}
