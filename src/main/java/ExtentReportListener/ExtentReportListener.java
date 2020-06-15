package ExtentReportListener;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import ExtentManager.Driverhandle;

public class ExtentReportListener extends Driverhandle{

	public static ExtentReports extent=null;
	public static ExtentHtmlReporter report=null;
	public static ExtentTest test=null;
	public static final String reportname="./ExtentReport/Report.html";
	
	
	public static ExtentReports setupreport(){
		  report = new ExtentHtmlReporter(reportname);
		  report.config().setDocumentTitle("Automation Report");
		  report.config().setReportName("Smoke Report");
		  report.config().setTheme(Theme.DARK);
		  report.config().setAutoCreateRelativePathMedia(true);
		  report.start();
		  extent = new ExtentReports();
		  extent.attachReporter(report);
		  extent.setSystemInfo("Operating System", System.getProperty("os.name"));
		  extent.setSystemInfo("Author", System.getProperty("user.name"));
		return extent;
		
	}
	
	/*public static void teststephandle(String teststatus, WebDriver driver, ExtentTest test, Throwable t){
		switch(teststatus){
		case "FAIL":
			test.fail(MarkupHelper.createLabel("Test case Failed", ExtentColor.RED));
			test.error(t.getMessage());	
			try {
				test.fail("Fail", 
						MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			} catch (IOException e) {
				e.printStackTrace();
			}
		
	case "PASS":
		test.pass(MarkupHelper.createLabel("Test case Passed", ExtentColor.GREEN));
		test.error(t.getMessage());	
	}
		
	}*/
	
	
}
