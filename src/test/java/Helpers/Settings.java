package Helpers;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.*;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.BufferedInputStream;
import java.io.File;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class Settings {

    protected static WebDriver browser;


    protected static void SetBrowserFirefox() throws Exception {
        File appDir = new File(System.getProperty("user.dir"));

        DesiredCapabilities caps = DesiredCapabilities.firefox();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable(LogType.BROWSER, Level.ALL);
        caps.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);

        FirefoxProfile profile = new FirefoxProfile();
        profile.setEnableNativeEvents(true);
        profile.setPreference("javascript.enabled",true);

        browser = new FirefoxDriver(profile);
        System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//        browser.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }


    protected static void SetBrowserChrome() throws Exception {
        System.setProperty("webdriver.chrome.driver", "user.dir/chromedriver.exe");
        browser = new ChromeDriver();
    }



    protected static void Take_screenshot(String file_name) throws Exception {
        System.out.println(file_name);
        File scrFile = ((TakesScreenshot)browser).getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(scrFile, new File(file_name + ".jpg"));
    }

    protected static void delete_screenshot(String FILE_PATH) throws Exception {
        File file = new File(FILE_PATH + ".jpg");
        file.delete();
    }

    public static void sendmail() {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("lagarit@gmail.com", "233246646992");
                    }
                });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("lagarit@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse("lagarit@gmail.com"));
            message.setSubject("Report");
            System.out.println("Form message");

            MimeBodyPart messageBodyPart = new MimeBodyPart();
            Multipart multipart = new MimeMultipart();
            messageBodyPart = new MimeBodyPart();
            String file = "c:/tests/HomePage/extentReportFile.html";
            String fileName = "extentReportFile.html";
            DataSource source = new FileDataSource(file);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport.send(message);

            } catch (MessagingException e) {
                e.printStackTrace();
            }

        }

    public static void getSomehing() throws Exception {
        String response = "";
        BufferedInputStream buffer=null;
        HttpURLConnection connection=null;
        String urlRequest = "https://cloud-api.yandex.net/v1/disk/resources/download ? %200043_3.avi.sfk";
        try {
            URL ur=new URL(urlRequest);
            connection = (HttpURLConnection) ur.openConnection();
            connection.setRequestMethod("GET");
            connection.addRequestProperty("Authorization", "OAuth 30ef86399e4f4aba895c98a152e3340a");
            buffer=new BufferedInputStream(connection.getInputStream());
            connection.connect();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(response);
//        return response;
    }



    @Before
    public void beforeTest() throws Exception {
    }

    @After
    public void afterTest() throws Exception {
    }

    @Rule
    public TestRule printTests = new TestWatcher() {
        protected void starting(Description description) {
            System.out.println("  StartTest: " + description.getMethodName());
        }

        protected void finished(Description description) {
            System.out.println("  FinishTest: " + description.getMethodName());
        }
    };

}