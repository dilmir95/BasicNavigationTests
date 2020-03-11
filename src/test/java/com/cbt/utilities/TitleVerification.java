package com.cbt.utilities;

import org.openqa.selenium.WebDriver;

import java.util.*;

public class TitleVerification {

    public static void main(String[] args) {

        List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        List<String> titles = new ArrayList<>();

        for(String eachUrl : urls){
            driver.get(eachUrl);
            BrowserUtil.wait(2);
            titles.add(driver.getTitle());

        }
        System.out.println("verifySameTitle = " + verifySameTitle(titles));
        System.out.println("verifyUrlStartWith = " + verifyUrlStartWith(urls, "http://practice.cybertekschool.com"));

        driver.quit();

    }
    public static boolean verifySameTitle(List<String> titles){
        for (int i = 0; i <titles.size()-1 ; i++) {
            if(!titles.get(i).equals(titles.get(i+1))){
                return false;
            }
        }
        return true;
    }
    public static boolean verifyUrlStartWith(List<String> urls, String startsWith) {
        for(String each: urls){
            if(!each.startsWith(startsWith)){
                return false;
            }


        }
        return true;
    }
}
