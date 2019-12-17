package com.tests.BaseTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    protected WebDriver driver;
    private String browser;

    @BeforeTest
    public void setupDriver(ITestContext context) throws MalformedURLException {
        String browser=System.getProperty("BROWSER");
        String hub_hots=System.getProperty("HUB_HOST");
        //browser="Chrome";
        DesiredCapabilities capabilities=new DesiredCapabilities();

        if(browser == null || browser.equals("Chrome")){
            capabilities=DesiredCapabilities.chrome();
            String currenttest=context.getCurrentXmlTest().getName();
            capabilities.setCapability("name", currenttest);
            //.setProperty("webdriver.chrome.driver", "/Users/shigovin/Downloads/chromedriver");
            //this.driver=new ChromeDriver();
        }else if (browser.equals("firefox")){
            capabilities=DesiredCapabilities.firefox();
        }

        if (hub_hots == null){
            hub_hots="localhost";
        }

       String compleurl="http://" + hub_hots + ":4444/wd/hub";
       this.driver=new RemoteWebDriver(new URL(compleurl),capabilities);


    }

    @AfterTest
    public void quite(){
        this.driver.quit();
    }

}
