package com.newtours.tests;

import com.newtours.pages.*;
import com.tests.BaseTest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest extends BaseTest {


    private String numberofpassengers;
    private String expectedprice;

    @Test
    @Parameters({"numberofpassengers","expectedprice"})
    public void setupParameters(String numberofpassengers,String expectedprice){

        this.numberofpassengers=numberofpassengers;
        this.expectedprice=expectedprice;


    }

    @Test
    public void registrationPagetest(){
        RegistrationPage registrationPage=new RegistrationPage(driver);
        registrationPage.goTo();
        registrationPage.enteruserCredentials("Selenium","passwrod");
        registrationPage.enteruserDetails("FirstName", "Lastname");
        registrationPage.clickSubmit();

    }

    @Test (dependsOnMethods = "registrationPagetest")
    public void registrationCnfirmation(){
        RegistarationConrimationPage conrimationPage=new RegistarationConrimationPage(driver);
        conrimationPage.flightdetailpage();

    }

    @Test (dependsOnMethods = "registrationCnfirmation")
    public void flightDetailsPage(){
        FlightDetailsPage flightDetailsPage=new FlightDetailsPage(driver);
        flightDetailsPage.selectPassCount(numberofpassengers);
        flightDetailsPage.findFlightsPage();
    }

    @Test (dependsOnMethods = "flightDetailsPage")
    public void findflightpage(){
        FindFlightPage findFlightPage=new FindFlightPage(driver);
        findFlightPage.submitFirstPage();
        findFlightPage.gotoConfirmationPage();
    }

    @Test (dependsOnMethods = "findflightpage")
    public void oderconfirmationpage(){
        OrderConfirmationPage orderConfirmationPage=new OrderConfirmationPage(driver);
        String price=orderConfirmationPage.getPrice();

    }
}
