import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemo {

	@Test
	public void loginTest() throws IOException {
		System.out.println("Login on ConversationHealth");
		
		ExtentHtmlReporter Reporter = new ExtentHtmlReporter("./Reports/lexi_report.html");
		
		ExtentReports extent = new ExtentReports();
		
		extent.attachReporter(Reporter);
		
		ExtentTest logger = extent.createTest("Login LEXI chat");
		
		logger.log(Status.INFO, "Login to conversationHealth"); 
		
		logger.log(Status.PASS, "Title Verified"); //Even if single test Pass it will show as Testcase Pass
		
		extent.flush();// This will write the content to the report
		
		ExtentTest logger2 = extent.createTest("Logoff LEXI chat");
		
		logger2.log(Status.FAIL, "Title Verified");// JUST intentionally Failing this testcase to show the range of Report.
		
		logger2.fail("Failed Because of some issues",MediaEntityBuilder.createScreenCaptureFromPath("./Reports/ConversationHealth_logo.jpg").build());
		
		extent.flush();
		
	}

}
