import Helpers.PageElement;
import Helpers.Settings;
import Helpers.Locators.*;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.sun.deploy.ref.Helpers;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import static Helpers.Locators.*;
import static Helpers.PageElement.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HomePage_test extends Settings {


    @BeforeClass
    public static void setUp() throws Exception {
        SetBrowserFirefox();
        browser.manage().window().setSize(new Dimension(1366, 768));
    }



    @Test
    public void a_test() throws Exception {
        LoadPage(LoginPage);

        Check("loginpage");
    }



    @Test
    public void b_log_in_test() throws Exception {
        LoadPage(LoginPage);

        SendKeys(EmailInput, Login);
        SendKeys(PasswordInput, Password);
        Click(LoginButton);

        IsDisplayed(EmployersTitleH1);
    }



    @AfterClass
    public static void setDown() throws Exception {
        browser.quit();
    }


//    Create report file
    //    String extentReportFile = System.getProperty("user.dir") + "\\extentReportFile.html";
    //    String extentReportImage = System.getProperty("user.dir") + "\\extentReportImage.png";

//    Create object of extent report and specify the report file path.
    //    ExtentReports extent = new ExtentReports(extentReportFile, false);

//    Start the test using the ExtentTest class object.
    //    ExtentTest extentTest = extent.startTest("Open " + domens[i],
    //            "Open " + domens[i] + "\nExpected: " + expected[i]);

//    Add logs
    //    extentTest.log(LogStatus.INFO, "Trying to open " + domens[i]);

//    Add logs as error
    //    extentTest.log(LogStatus.ERROR, "FAILURE! Expected result not found"
    //        + extentTest.addScreenCapture("C:/tests/HomePage/images/"
    //              + domens[i] + ".jpg"));

//    Add logs as success
    //    extentTest.log(LogStatus.PASS, "Home page opened and expected result found");
    //    delete_screenshot("C:/tests/HomePage/images/" + domens[i] + ".jpg");


}