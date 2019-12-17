package com.searchmodules.tests;

import com.searchmodule.pages.SearchPage;
import com.tests.BaseTest.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {


    @Test
    @Parameters ({"keyword"})
    public void search(String keyword){
        SearchPage page=new SearchPage(driver);
        page.goTo();
        page.doSearch(keyword);
        page.goToVideos();
        int count=page.printResults();
        Assert.assertTrue(count>0);
    }

}
