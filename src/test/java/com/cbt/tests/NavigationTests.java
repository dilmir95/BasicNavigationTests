package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtil;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {

    public static void main(String[] args) {
        allInOneTest("safari");
        //chromeTest();
        //safariTest();
       // firefoxTest();


    }
    public static void chromeTest(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://google.com");
        BrowserUtil.wait(1);
        String titleGoogle = driver.getTitle();
        driver.get("https://etsy.com");
        BrowserUtil.wait(1);
        String titleEtsy = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(driver.getTitle(),titleGoogle);
        driver.navigate().forward();
        StringUtility.verifyEquals(driver.getTitle(),titleEtsy);
        driver.quit();

    }
    public static void safariTest(){
        WebDriver driver = BrowserFactory.getDriver("safari");
        driver.get("https://google.com");
        BrowserUtil.wait(1);
        String titleGoogle = driver.getTitle();
        driver.get("https://etsy.com");
        BrowserUtil.wait(1);
        String titleEtsy = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(driver.getTitle(),titleGoogle);
        driver.navigate().forward();
        StringUtility.verifyEquals(driver.getTitle(),titleEtsy);
        driver.quit();

    }
    public static void firefoxTest(){
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.get("https://google.com");
        BrowserUtil.wait(1);
        String titleGoogle = driver.getTitle();
        driver.get("https://etsy.com");
        BrowserUtil.wait(1);
        String titleEtsy = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(driver.getTitle(),titleGoogle);
        driver.navigate().forward();
        StringUtility.verifyEquals(driver.getTitle(),titleEtsy);
        driver.quit();

    }
    public static void allInOneTest(String browserName){
        WebDriver driver = BrowserFactory.getDriver(browserName);
        driver.get("https://google.com");
        BrowserUtil.wait(1);
        String titleGoogle = driver.getTitle();
        driver.get("https://etsy.com");
        BrowserUtil.wait(1);
        String titleEtsy = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(driver.getTitle(),titleGoogle);
        driver.navigate().forward();
        StringUtility.verifyEquals(driver.getTitle(),titleEtsy);

        driver.quit();
    }
}
