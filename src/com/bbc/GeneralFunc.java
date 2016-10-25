package com.bbc;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;



public class GeneralFunc {
	public static WebDriver driver = null;

	public static boolean sStatus;

	//Selects the browser and returns the driver
	public static WebDriver selectBrowser(String browserName,String url){

		try{

			if(browserName.trim().toLowerCase().equalsIgnoreCase("ff")){
				driver = new FirefoxDriver();
			}
			else if(browserName.trim().toLowerCase().equalsIgnoreCase("gc")){
				System.setProperty("webdriver.chrome.driver", "E:\\Durga_maven\\chromedriver.exe");
				driver = new ChromeDriver();
			}
			else if(browserName.trim().toLowerCase().equalsIgnoreCase("ie")){
				System.setProperty("webdriver.ie.driver", "Drivers\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			else{
				System.out.println("The provided browser type is not exist");
			}
			driver.navigate().to(url);
			driver.manage().window().maximize();
			return driver;
		}
		catch(Exception e){

		}
		return null;
	}
	//Waits for specific element
	public static boolean waitForElement(By dLocator){
		try{
			WebDriverWait wait = new WebDriverWait(driver, Global.dDelay) ;
			wait.until(ExpectedConditions.visibilityOfElementLocated(dLocator));
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	//clicks on element
	public static boolean clickElement(String sLocator){
		try{
			
			WebElement element = driver.findElement(By.xpath(sLocator));
			Actions sct = new Actions(driver);
			sct.moveToElement(element).build().perform();
			driver.findElement(By.xpath(sLocator)).click();
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}

	@AfterSuite
	public static void tearDown(){
		driver.close();
		driver.quit();
	}
	//Halts Selenium for 20 seconsds
	public static void wait(int dTimeInSeconds){
		try{
			Thread.sleep(dTimeInSeconds);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


}
