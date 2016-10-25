package com.bbc;

import org.openqa.selenium.By;

public class Locators {

	public static class Headers{
		public static final By dLatestBusinessNews = By.xpath("//h2[text()='Latest Business News']"); 
	}
	public static class CommonX{
		public static final By dXLatestBusinessNews = By.xpath("//h2[text()='Latest Business News']/following-sibling::ul/li");
	}
}
