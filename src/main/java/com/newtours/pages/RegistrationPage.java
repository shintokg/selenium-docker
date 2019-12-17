package com.newtours.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "firstName")
    private WebElement firstelement;

    @FindBy(name = "lastName")
    private WebElement lastelement;

    @FindBy(name = "email")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(name = "confirmPassword")
    private WebElement confirmpwd;

    @FindBy(name = "register")
    private  WebElement submit;



    public RegistrationPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

   public void goTo(){
        System.out.println("############" +driver.toString());
        this.driver.get("http://www.newtours.demoaut.com/mercuryregister.php");
        this.wait.until(ExpectedConditions.visibilityOf(firstelement));
    }

    public void enteruserDetails(String firstname, String lastname){
        this.firstelement.sendKeys(firstname);
        this.lastelement.sendKeys(lastname);
    }

    public void enteruserCredentials(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        this.confirmpwd.sendKeys(password);
    }

    public void clickSubmit(){
        this.submit.click();
    }


}
