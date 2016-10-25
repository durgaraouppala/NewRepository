package com.bbc;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class AppFunc {
	public static boolean dStatus;
	public static boolean launchBBCWord(String dBrowserName){
		try{
			GeneralFunc.selectBrowser(dBrowserName, Global.dUrl);
			dStatus = GeneralFunc.waitForElement(Locators.Headers.dLatestBusinessNews);
			Assert.assertEquals(dStatus, true,"The provided URL is not opened properly");
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public static boolean validateLatestNewsNavigation(){
		try{
			String dTitle = "";
			List<WebElement> itensfromApp;
			int itemsCount = GeneralFunc.driver.findElements(Locators.CommonX.dXLatestBusinessNews).size();
			List<String> listOfValues = new ArrayList<String>();
			for(int i =1;i< itemsCount;i++){
			listOfValues.add(GeneralFunc.driver.findElement(By.xpath("//h2[text()='Latest Business News']/following-sibling::ul/li["+i+"]//h3")).getText());
			}
			itensfromApp = GeneralFunc.driver.findElements(Locators.CommonX.dXLatestBusinessNews);
			
			for(int i = 1; i < itensfromApp.size(); i++){
				String itemFromApp = GeneralFunc.driver.findElement(By.xpath("//h2[text()='Latest Business News']/following-sibling::ul/li["+i+"]//h3")).getText();
				if(!itemFromApp.trim().equalsIgnoreCase(listOfValues.get(i-1).trim())){
					System.out.println("The expected and actual Latest news values are not matching");
				}
				else{
					GeneralFunc.clickElement("//h2[text()='Latest Business News']/following-sibling::ul/li["+i+"]");
					GeneralFunc.wait(Global.dDelayMSeconds);
					dTitle = GeneralFunc.driver.getTitle();
					System.out.println(dTitle);
					System.out.println("--------------");
					System.out.println(dTitle);
					if(!dTitle.trim().equalsIgnoreCase(listOfValues.get(i-1)+" "+"- BBC News".trim())){
						System.out.println("The titles are not matching");
					}
					else{
						System.out.println("*********************");
						System.out.println(GeneralFunc.driver.getTitle());
						GeneralFunc.wait(Global.dDelayMSeconds);
						GeneralFunc.driver.navigate().back();
						GeneralFunc.wait(Global.dDelayMSeconds);
					}
				}
			}
			
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
}