
package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
//import java.net.URL;
import java.net.URL;

//Extent report 5.x...//version

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.HtmlEmail;
import org.apache.commons.mail.ImageHtmlEmail;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;

	String repName;

	public void onStart(ITestContext testContext) {

		/*
		 * SimpleDateFormat df=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss"); Date dt=new
		 * Date(); String currentdatetimestamp=df.format(dt);
		 */

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());// time stamp
		repName = "Test-Report-" + timeStamp + ".html";
		sparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);// specify location of the report

		sparkReporter.config().setDocumentTitle("HIMS Automation Report"); // Title of report
		sparkReporter.config().setReportName("HIMS Functional Testing"); // name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		extent.setSystemInfo("Application", "HIMS");
		extent.setSystemInfo("Module 1", "Admin");
		extent.setSystemInfo("Module 2", "OP");
		extent.setSystemInfo("Module 3", "Warehouse");
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Environemnt", "QA");

		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", os);

		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", browser);

		List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
		if (!includedGroups.isEmpty()) {
			extent.setSystemInfo("Type Of Testing", includedGroups.toString());
		}
	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); // to display groups in report
		test.log(Status.PASS, result.getName() + " got successfully executed");

	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());

		test.log(Status.FAIL, result.getName() + " got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());

		try {
			String imgPath = new BaseClass().captureScreen(result.getName());
			test.addScreenCaptureFromPath(imgPath);

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + " got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext) {

		extent.flush();

		String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
		File extentReport = new File(pathOfExtentReport);

		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}

//		try {
//			URL url = new URL("file:///" + System.getProperty("user.dir") + "\\reports\\" + repName);
//
//			// Create the email message
//			ImageHtmlEmail email = new ImageHtmlEmail();
//			email.setDataSourceResolver(new DataSourceUrlResolver(url));
//			email.setHostName("smtp.googlemail.com");
//			email.setSmtpPort(465);
//			email.setAuthenticator(new DefaultAuthenticator("shanmugamsenthil247@gmail.com", "wmhc sktk vvvc bvfu"));
//			email.setSSLOnConnect(true);
//			email.setFrom("shanmugamsenthil247@gmail.com"); // Sender
//			email.setSubject("Test Results");
//			email.setMsg("Please find Attached Report....");
//			email.addTo("ajithkumar@eoxys.com"); // Receiver
//			email.addTo("bercilinjose@eoxys.com"); // Receiver2
//			email.attach(url, "Extent Report", "please check report...");
//			
//			 // Create the attachment with content type set to "text/html"
//		    EmailAttachment attachment = new EmailAttachment();
//		    attachment.setPath(url.getPath());  // Set path of the report
//		    attachment.setName("Test-Report.html");  // Ensure the attachment has .html extension
//		    attachment.setDescription("Test Execution Report");
//		    attachment.setDisposition(EmailAttachment.ATTACHMENT);
//		    attachment.setContentType("text/html");  // Specify content type as HTML
//
//		    // Attach the HTML report
//		    email.attach(attachment);
//			email.send(); // send the email
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		//below is my actual correct code
		/*
		try {
            // Create the URL for the generated HTML report file
            URL url = new URL("file:///" + System.getProperty("user.dir") + "\\reports\\" + repName);

            // Create the email message
            HtmlEmail email = new HtmlEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("shanmugamsenthil247@gmail.com", "your-app-password"));
            email.setSSLOnConnect(true);
            email.setFrom("shanmugamsenthil247@gmail.com"); // Sender email
            email.setSubject("Test Results");
            email.setMsg("Please find attached the test report in HTML format.");

            // Add multiple recipients
            email.addTo("ajithkumar@eoxys.com"); // Receiver 1
            email.addTo("bercilinjose@eoxys.com"); // Receiver 2

            // Create the attachment
            EmailAttachment attachment = new EmailAttachment();
            attachment.setPath(url.getPath());  // Set path of the report
            attachment.setName("Test-Report.html");  // Ensure the attachment has .html extension
            attachment.setDescription("Test Execution Report");
            attachment.setDisposition(EmailAttachment.ATTACHMENT);
            
            // Attach the HTML report (no need for setMimeType here)
            email.attach(attachment);

            // Send the email
            email.send();
        } catch (Exception e) {
            e.printStackTrace();
        }
*/

	}

}

