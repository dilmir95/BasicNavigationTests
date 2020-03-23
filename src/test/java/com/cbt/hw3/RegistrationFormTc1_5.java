package com.cbt.hw3;

import com.cbt.utilities.BrowserUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class RegistrationFormTc1_5 {
        WebDriver driver;
        By birthdayBy = By.name("birthday");
        By dobWarMsg  = By.xpath("//small[text()='The date of birth is not valid']");
        By firstNameBy = By.name("firstname");
        By firstNameWarMsg = By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']");
        By lastNameBy = By.name("lastname");
        By lastNameWarMsg = By.xpath("//small[text()='The last name must be more than 2 and less than 64 characters long']");
        List<WebElement> buttons;
        By usernameBy = By.name("username");
        By emailBy = By.name("email");
        By passwordBy = By.name("password");
        By phoneBy = By.name("phone");

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
         driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://practice-cybertekschool.herokuapp.com/");

         driver.findElement(By.linkText("Registration Form")).click();

    }
        @AfterMethod
    public void teardown(){
        if(driver!=null){
            BrowserUtil.wait(2);
            driver.quit();
            driver=null;
        }
    }

    @Test
    public void tc1(){
        driver.findElement(birthdayBy).sendKeys("wrong_dob");
        WebElement msg1 = driver.findElement(dobWarMsg);
        Assert.assertTrue(msg1.isDisplayed());
    }
    @Test
    public void tc2(){
      List<WebElement> checkboxes =  driver.findElements(By.cssSelector("label[class='form-check-label']"));
      for(WebElement each: checkboxes){
          Assert.assertTrue(each.isDisplayed(), "Not found, error 404");
          BrowserUtil.wait(1);
      }
    }
    @Test
    public void tc3(){
        driver.findElement(firstNameBy).sendKeys("a");
        WebElement msg2 = driver.findElement(firstNameWarMsg);
        Assert.assertTrue(msg2.isDisplayed(), "Not found, error 404");

    }
    @Test
    public void tc4(){
        driver.findElement(lastNameBy).sendKeys("a");
        WebElement msg3 = driver.findElement(lastNameWarMsg);
        Assert.assertTrue(msg3.isDisplayed());
    }
    @Test
    public void tc5(){
        driver.findElement(firstNameBy).sendKeys("dimka");
        driver.findElement(lastNameBy).sendKeys("dimka");
        driver.findElement(usernameBy).sendKeys("dimka95");
        driver.findElement(emailBy).sendKeys("dimkadimka95@mail.com");
        driver.findElement(passwordBy).sendKeys("FordEscape2015");
        driver.findElement(phoneBy).sendKeys("832-111-0000");
        buttons = driver.findElements(By.cssSelector("input[type='radio']"));
        buttons.get(0).click();
        BrowserUtil.wait(3);
        driver.findElement(birthdayBy).sendKeys("12/07/1995");
        Select depSelect = new Select(driver.findElement(By.name("department")));
        Select jobTitleSelect = new Select(driver.findElement(By.name("job_title")));
        depSelect.selectByVisibleText("Accounting Office");
        jobTitleSelect.selectByVisibleText("SDET");
        List<WebElement> checkBoxesLanguage = driver.findElements(By.cssSelector("input[class='form-check-input']"));
        checkBoxesLanguage.get(1).click();
        checkBoxesLanguage.get(2).click();
        BrowserUtil.wait(2);
        driver.findElement(By.id("wooden_spoon")).click();
        BrowserUtil.wait(3);
        String expected = "You've successfully completed registration!";
        String actual = driver.findElement(By.xpath("//p")).getText();
        Assert.assertEquals(actual,expected, "Sign up not successful");
    }

}
