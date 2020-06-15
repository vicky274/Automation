package Listeners;

import java.io.IOException;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGListener;
import org.testng.ITestResult;
import org.testng.internal.annotations.IListeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import ExtentManager.Driverhandle;
import ExtentReportListener.ExtentReportListener;
import Utility.Capturescreenshot;

public class Listeners extends ExtentReportListener implements ITestListener,ISuiteListener{
	
	public static ExtentTest test=null;
	@Override
	public void onFinish(ITestContext test) {
	
	}

	@Override
	public void onStart(ITestContext test) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		try {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test Case Failed", ExtentColor.RED));
			test.fail(result.getName()+" Failed", 
			MediaEntityBuilder.createScreenCaptureFromPath(Capturescreenshot.capturescreenshot(result.getName(), driver)).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		
		
	}

	@Override
	public void onTestStart(ITestResult result) {
		test= extent.createTest(result.getName());
		test.log(Status.INFO, result.getName()+" Started Execution");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		try {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
			test.pass(result.getName()+" Passed", 
			MediaEntityBuilder.createScreenCaptureFromPath(Capturescreenshot.capturescreenshot(result.getName(), driver)).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite arg0) {
		extent.flush();
		
		
	}

	@Override
	public void onStart(ISuite arg0) {
		setupreport();
		
	}

}
