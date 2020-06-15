package TestAuto;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import ExtentManager.Driverhandle;
import Listeners.Listeners;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import PageObject.LoginPageObject;
import TestData.TestDataFromExcel;
import Utility.Capturescreenshot;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class duplicatedata {
	
   @BeforeSuite
   public void beforeSuite() throws IOException 
   {
	   System.out.println("Before Suite");
	   
   }

   @Test(priority=0)
   public void test() throws Exception{
	   System.out.println("test method");
	    //TestDataFromExcel.getCellData("Sheet3");
	   //TestDataFromExcel.setCellData("Sheet2");
	   TestDataFromExcel.readandwritedata("Sheet1");
   }
  
 
  
  @AfterSuite
  public void afterSuite() {
	  System.out.println("After Suite");
	
  }
  
  
}
