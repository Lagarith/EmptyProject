package Helpers;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import org.apache.commons.io.FileUtils;
import org.hamcrest.core.Is;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.List;

import static Helpers.Locators.content_title_xpath;
import static Helpers.Locators.title_x_margin_from_top;
import static Helpers.Locators.title_y_margin_from_left;
import static Helpers.Settings.browser;

public class PageElement {

    public static boolean ContentText(String element_xpath) {
        boolean error_status = false;
        try {
            browser.findElement(By.xpath(element_xpath)).isDisplayed();
        } catch (Exception e) {
            error_status = true;
        }

        return error_status;
    }


/*
    public static boolean ContentMainImage(String element_) {
        boolean error_status = false;

        String image_url = browser.findElement(By.cssSelector("#material > div > div > img")).getAttribute("src");
        System.out.println("url = " + image_url);

        try {
            URL url = new URL(image_url);
            System.out.println("All is not fucked, but anyway sorry");
        } catch (Exception e) {
            System.out.println("All is fucked, sorry");
        }

        Image image = null;

        try {
            image = ImageIO.read(image_url);
            if (image == null) {
                System.out.println("The file could not be opened and you are faggot");
            } else System.out.println("Everything is cool");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return error_status;
    }
*/


    public static boolean MaterialDateAdd(String element_) {
        boolean error_status = false;
        return error_status;
    }



    public static boolean MaterialTags(String element_) {
        boolean error_status = false;
        return error_status;
    }



    public static boolean MaterialElementPosition(String element_) {
        boolean error_status = false;

        int x_position = browser.findElement(By.cssSelector(element_)).getSize().getWidth();
        int y_position = browser.findElement(By.cssSelector(element_)).getSize().getHeight();

        if (x_position == title_x_margin_from_top) {
            System.out.println("Normal");
        } else {
            error_status = true;
        }

        return error_status;
    }



    public static boolean JSPageErrors() {
        boolean error_status = false;

        //String jsErrors = browser.manage().logs().get(LogType.BROWSER).toString();

/*        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
            //do something useful with the data
        }*/

        LogEntries logEntries = browser.manage().logs().get(LogType.BROWSER);

        for (LogEntry logEntry : logEntries) {
            System.out.println(new Date(logEntry.getTimestamp() + " " + logEntry.getLevel() + " " + logEntry.getMessage()));
        }

        //System.out.println(jsErrors);


        return error_status;
    }



    public static boolean IsDisplayed(String elementXpath) {
        boolean error_status = false;

        try {
            browser.findElement(By.xpath(elementXpath)).isDisplayed();
        } catch (Exception e) {
            System.out.println("Cannot find element");
            error_status = true;
        }

        return error_status;
    }



    public static boolean SendKeys(String elementXpath, String message) {
        boolean error_status = false;

        System.out.println("Searching is element exist");

        if ( IsDisplayed(elementXpath) ) {
            System.out.println("Element exist. Trying to send keys: " + message);
            try {
                browser.findElement(By.xpath(elementXpath)).sendKeys(message);
            } catch (Exception e) {
                System.out.println("Something went wrong. Cannot send keys to element:" + elementXpath);
                e.printStackTrace();
            }
        } else {
            System.out.println("Cannot find element by xPath: " + elementXpath);
        }

        return error_status;
    }



    public static boolean Click (String elementXpath) {
        boolean error_status = false;

        if (IsDisplayed(elementXpath)) browser.findElement(By.xpath(elementXpath)).click();

        return error_status;
    }



    public static boolean GetAttribute (String elementXpath, String elementAttribute) {
        boolean error_status = false;

        if (IsDisplayed(elementXpath)) browser.findElement(By.xpath(elementXpath)).getAttribute("" + elementAttribute + "");

        return error_status;
    }



    public static boolean CreateReport (String filePath) {
        boolean error_status = false;

        String extentReportFile = System.getProperty("user.dir")
                + "\\extentReportFile.html";
        String extentReportImage = System.getProperty("user.dir")
                + "\\extentReportImage.png";

        return error_status;
    }



    public static List<WebElement> GetAllLinks() {
        java.util.List<WebElement> links = browser.findElements(By.tagName("a"));

        System.out.println(links.size());

        for (int i = 1; i<=links.size(); i=i+1)

        {
            System.out.println(links.get(i).getText());
        }

        return links;
    }



    public static boolean LoadPage(String pageURL) {
        boolean error_status = true;

        System.out.println("Trying to open: " + pageURL);

        try {
            browser.get(pageURL);
        } catch (Exception e) {
            e.printStackTrace();
            error_status = false;
            System.out.println("Page cannot be opened.");
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return error_status;
    }



    public static boolean Check(String fileName) {
        boolean error_status = true;

        LayoutReport layoutReport = null;
        try {
            layoutReport = Galen.checkLayout(browser, "specs/" + fileName + ".spec", Arrays.asList("desktop"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Create a tests list
        List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();

        String title = browser.getTitle();

        //Create a GalenTestInfo object
        GalenTestInfo test = GalenTestInfo.fromString(title + " layout");

        //Get layoutReport and assign to test object
        test.getReport().layout(layoutReport, "Check " + title + " layout");

        //Add test object to the tests list
        tests.add(test);

        //Create a htmlReportBuilder object
        HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();

        //Create a report under /target folder based on tests list
        try {
            htmlReportBuilder.build(tests, "target");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //If layoutReport has errors Assert Fail
        if (layoutReport.errors() > 0)
        {
            Assert.fail("Layout test failed");
        }

        return error_status;
    }



    public static void RefreshPage() throws Exception {
        browser.navigate().refresh();
        Thread.sleep(2000);
    }



    public static boolean HoverAndCick(String hoverXpath, String clickXpath) {
        boolean error_status = true;
        Actions actions = new Actions(browser);

        // SEARCH AND HOVER MENU
        try {
            WebElement menu = browser.findElement(By.xpath(hoverXpath));
            actions.moveToElement(menu);
        }catch (Exception e) {
            error_status = false;
        }

        // SEARCH AND CLICK SUBMENU ELEMENT
        if (error_status) {
            try {
                WebElement subMenu = browser.findElement(By.xpath(clickXpath));
                actions.moveToElement(subMenu);
                actions.click().build().perform();
            } catch (Exception e) {
                error_status = false;
            }
        }

        return error_status;
    }



    public static boolean IsNotDisplayed(String elementXpath) {
        boolean error_status = true;

        try {
            browser.findElements(By.xpath(elementXpath)).isEmpty();
        } catch (Exception e) {
            error_status = false;
        }

        return error_status;
    }




}
