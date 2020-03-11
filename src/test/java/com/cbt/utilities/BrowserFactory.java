package com.cbt.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {
    static WebDriver driver;
    public static void main(String[] args) {






    }
    public static WebDriver getDriver (String browserName){
        if(browserName.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().version("79.0").setup();
            driver = new ChromeDriver();

        }else if(browserName.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        }else if(browserName.equalsIgnoreCase("edge")){
            if(System.getProperty("os.name").startsWith("Mac")){
                driver = null;
            }else{
                WebDriverManager.edgedriver().setup();
                 driver = new EdgeDriver();


            }

            }else if (browserName.equalsIgnoreCase("safari")){
            if(System.getProperty("os.name").startsWith("Windows")){
                driver=null;

            }else{
                 driver = new SafariDriver();


            }

        }


        return driver;
    }


}
