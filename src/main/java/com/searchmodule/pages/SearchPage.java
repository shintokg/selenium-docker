package com.searchmodule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "search_form_input_homepage")
    private WebElement searchTxt;

    @FindBy(id = "search_button_homepage")
    private WebElement searchBtn;

    @FindBy (linkText = "Videos")
    private WebElement videoLink;


    @FindBy(linkText = "Java Programming")
    private List<WebElement> allvideos;


    public SearchPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver,80);
        PageFactory.initElements(driver,this);


    }

    public void goTo(){
        driver.get("https://duckduckgo.com");
    }

    public void doSearch(String keyword){
       this.wait.until(ExpectedConditions.visibilityOf(this.searchTxt));
       this.searchTxt.sendKeys(keyword);
       this.searchBtn.click();
    }

    public void goToVideos(){
        this.wait.until(ExpectedConditions.visibilityOf(videoLink));
        this.videoLink.click();
    }

    public int printResults(){
        By by=By.className("tile__media");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by,0));
        System.out.println(allvideos.size());
        return allvideos.size();
    }


}
