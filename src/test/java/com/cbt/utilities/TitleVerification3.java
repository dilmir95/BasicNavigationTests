package com.cbt.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    static WebDriver driver;
    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com/",
                "http://westelm.com/");




        for (int i = 0; i <urls.size() ; i++) {

                driver = BrowserFactory.getDriver("chrome");
                driver.get(urls.get(i));
                TitleVerification2.verifyURLcontainsTitle(driver.getCurrentUrl(),driver.getTitle());
                driver.quit();



        }

    }
}
