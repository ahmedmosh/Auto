package Scenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.awt.*;

public class PreReq {
    WebDriver driver;
    Robot robot;
    Actions mouse;

    @BeforeClass
    /** Setup browser
     * Test prerequisite; browser setup
     * @param browser
     * @param app
     */
    @Parameters({"browser", "url"})
    void setup(String browser, String app) {
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        }
        driver.get(app);
        driver.manage().window().maximize();
//        else{
//    void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://automationexercise.com/");
//        driver.manage().window().maximize();
//
//    }
        }

        @Test
        // Verify that page is visible
        void pageVisibility () {
            String pageTitle = "Google";
            String title = driver.getTitle();
            Assert.assertEquals(title, pageTitle);

        }

    }

