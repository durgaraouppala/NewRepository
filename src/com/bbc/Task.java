package com.bbc;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Task {
    public static void main(String[] args) {
        //Driver Launch
    	System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        
        //Navigate to bbc Home page
        driver.get("http://www.bbc.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        //Navigate to Latest Business news using mouse hover operation
        String Businessnews="//div[@class='most-popular']";
        mouseOverOperation(driver,Businessnews);
        
            
        //Store Business news WebElement
        List<WebElement> lst=driver.findElements(By.xpath("//div[@class='most-popular']/div[@class='top-list']/ul/li"));
        
        //intialize business news values
        String name,title;
        WebElement element;
        
        
        //Write all the business news by navigating to the page
        for(int i=0;i<lst.size();i++)
        {
            element= lst.get(i);
            
            name=element.getText();
            
            System.out.println("Get Text: "+name);
            
            element.click();

            title=driver.getTitle();

            System.out.println("Page tittle: "+title);
            
            
            driver.navigate().back();
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            
            lst=driver.findElements(By.xpath("//div[@class='most-popular']/div[@class='top-list']/ul/li"));

        }

        driver.close();
    }
    
    public static void mouseOverOperation(WebDriver driver, String webElementXpath){
        Actions action = new Actions(driver);
        WebElement ele = driver.findElement(By.xpath(webElementXpath));
        action.moveToElement(ele).build().perform();
    }

}

