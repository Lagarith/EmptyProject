package Helpers;

import java.util.Arrays;
import java.util.HashSet;

public class Locators extends Settings {

    //LINKS
    public static final String LoginPage = "http://test-case.vats.atwinta.ru/login/";



    //DATA
    public static final String Login = "director@test-case-company.com";
    public static final String Password = "password";



    //LOGIN PAGE ELEMENTS
    public static final String EmailInput = "/html/body/div/div/div[2]/div[1]/form/div[2]/div/div[2]/input";
    public static final String PasswordInput = "/html/body/div/div/div[2]/div[1]/form/div[3]/div/div[2]/input";
    public static final String LoginButton = "/html/body/div/div/div[2]/div[1]/form/button";



    //EMPLOYERS PAGE
    public static final String EmployersTitleH1 = "//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div[1]/div/div[1]/span";





    public static final String reportPath = "";
    public static final String reportFilePath = "c:/tests/HomePage/extentReportFile.html";

    static final String shortMessage50 = "";
    static final String mediumMessage255 = "";
    static final String longMessage500 = "";
    static final String trashMessage = "";

    static final String xssString1 = "";
    static final String xssString2 = "";
    static final String xssString3 = "";

    //Page elements
    public static final String content_title_xpath = "/html/body/div[1]/div[6]/div[1]/div[1]/header/h1";
    public static final String content_text_selector = "#material > div";

    //Elements margins
    public static final int title_x_margin_from_top = 200;
    public static final int title_y_margin_from_left = 200;

    static final HashSet<Character> PUNCT_SET = new HashSet<Character>(Arrays.asList(
            '!', '"', '#', '$', '%', '&', '\'', '(', ')', '*', '+', ',', '-',
            '.', '/', ':', ';', '<', '=', '>', '?', '@', '[', '\\', ']', '^',
            '_', '`', '{', '|', '}', '~'
    ));
}
