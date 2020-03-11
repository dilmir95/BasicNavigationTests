package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.*;

public class TitleVerification2 {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com/", "https://walmart.com/",
                "https://westelm.com/");


        WebDriver driver = BrowserFactory.getDriver("chrome");

        for (String each : urls){
            driver.get(each);
            BrowserUtil.wait(1);
            
            verifyURLcontainsTitle(driver.getCurrentUrl(),driver.getTitle());
        }
        driver.quit();
    }

    public static void verifyURLcontainsTitle(String url, String title) {
        title = title.replace(" ", "").toLowerCase();

        if (url.contains(title)) {
            System.out.println("Test Passed");
            System.out.println("url = " + url);
            System.out.println("title = " + title);
            System.out.println();
        } else {
            System.out.println("Test Failed");
            System.out.println("url = " + url);
            System.out.println("title = " + title);
            System.out.println();
        }
    }

}