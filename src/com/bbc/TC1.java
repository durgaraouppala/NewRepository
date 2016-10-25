package com.bbc;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TC1 {
	public static boolean dStatus;
	@Test
	public static void latestNewsValidation(){
		try{
			dStatus = AppFunc.launchBBCWord("ff");
			Assert.assertEquals(dStatus, true, "BBC World launch not peroformed successfully");
			dStatus = AppFunc.validateLatestNewsNavigation();
			Assert.assertEquals(dStatus, true, "Validation of Latest new got exception");
			GeneralFunc.tearDown();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
