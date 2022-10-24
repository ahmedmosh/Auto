package Scenarios;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.build.Plugin;
import org.apache.hc.core5.reactor.Command;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;


public class UserRegistration {
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
//        else{
//    void setup() {
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.get("https://automationexercise.com/");
//        driver.manage().window().maximize();
//
//    }
     }

    @Test(priority = 1)
        // Verify that page is visible
    void pageVisibility() {
        String pageTitle = "Automation Exercise";
        String title = driver.getTitle();
        Assert.assertEquals(title, pageTitle);

    }

    @Test(priority = 2)
        // click signup
    void clickSignUp() {
        driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']")).click();

    }

    @Test(priority = 3)
        // Verify 'new user sign up' is visible
    void newUser() {
        String signUp = "New User Signup!";
        String heading2 = driver.findElement(By.xpath("//div[@class='signup-form']/h2")).getText();
        Assert.assertEquals(heading2, signUp);
    }

    @Test(priority = 4)
        // enter name and email address
    void fillForm() throws AWTException, InterruptedException {
        robot = new Robot();
        WebElement name = driver.findElement(By.xpath("//div[@class='signup-form']//input[contains(@placeholder,'Name')]"));
        name.click();
        // Thread.sleep(3000);
        name.sendKeys("abbey");
        // Thread.sleep(3000);
        WebElement email = driver.findElement(By.xpath("//div[@class='signup-form']//input[contains(@placeholder,'Email Address')]"));
        email.click();
        email.sendKeys("zatabbey@gmail.com");
        Thread.sleep(3000);

    }

    @Test(priority = 5)
        // click signup button
    void signUpCTA() throws AWTException, InterruptedException {
        WebElement signupButton = driver.findElement(By.xpath("//div[@class='signup-form']//button[normalize-space()='Signup']"));
        signupButton.click();
    }

    @Test(priority = 6)
        // Verify that enter 'account information' is visible
    void accountInfo() {
        String exAcctInfo = "ENTER ACCOUNT INFORMATION";
        String acctInfo = driver.findElement(By.xpath("//div//h2/b[normalize-space()=\"Enter Account Information\"]")).getText();
        Assert.assertEquals(acctInfo, exAcctInfo);
    }

    @Test(priority = 7)
        // fill details
    void fillDetails1() throws AWTException, InterruptedException {
        mouse = new Actions(driver);
        robot = new Robot();
        driver.findElement(By.xpath("//label[normalize-space()='Mr.']//input")).click();
        WebElement nameField = driver.findElement(By.xpath("//div[@class='required form-group']//input[@id='name']"));
        nameField.click(); // clicks on name field
        robot.keyPress(KeyEvent.VK_TAB);  // navigates to next field
        driver.switchTo().activeElement().sendKeys("abiodun");
        Thread.sleep(3000);
        mouse.sendKeys(Keys.PAGE_DOWN).build().perform();
        Thread.sleep(3000);
        robot.keyPress(KeyEvent.VK_TAB);  // navigates to next field
        driver.switchTo().activeElement().click();
        driver.findElement(By.xpath("//select[@id='days']/option[@value='12']")).click();
        robot.keyPress(KeyEvent.VK_TAB);
        driver.switchTo().activeElement().click();
        driver.findElement(By.xpath("//select[@id='months']//option[normalize-space()='December']")).click();
        robot.keyPress(KeyEvent.VK_TAB);
        driver.switchTo().activeElement().click();
        driver.findElement(By.xpath("//select[@id='years']//option[normalize-space()='1992']")).click();

    }

    @Test(priority = 8)
        // Select checkbox 'sign up for our newsletter'
    void newsletterSignUp() {
        driver.findElement(By.xpath("//div//input[@id='newsletter']")).click();  //clicking the checkbox
    }

    @Test(priority = 9)
        // fill provided details in address information'
    void fillDetails2() throws InterruptedException, AWTException {
        robot = new Robot();
        mouse = new Actions(driver);
        WebElement addrName = driver.findElement(By.xpath("//input[@id=\'first_name\']"));
        addrName.click();
        addrName.sendKeys("Moshood");
        robot.keyPress(KeyEvent.VK_TAB);
        driver.switchTo().activeElement().sendKeys("Ahmed");
        robot.keyPress(KeyEvent.VK_TAB);
        driver.switchTo().activeElement().sendKeys("The Bulb Africa");
        robot.keyPress(KeyEvent.VK_TAB);
        driver.switchTo().activeElement().sendKeys("3b watch Tower street ajegunle Lagos");
        robot.keyPress(KeyEvent.VK_TAB);
        mouse.sendKeys(Keys.PAGE_DOWN).build().perform();
        driver.switchTo().activeElement().sendKeys("3b watch Tower street ajegunle Lagos");
        robot.keyPress(KeyEvent.VK_TAB);
        robot.keyPress(KeyEvent.VK_ENTER);
        Thread.sleep(3000);
        driver.switchTo().activeElement();
        driver.findElement(By.xpath("//select[@id='country']/option[normalize-space()='Canada']")).click();
        Thread.sleep(3000);
//        WebElement EdFrame =driver.findElement(By.xpath("/html/body/ins[2]/div[1]//ins/span/svg/g"));
//        driver.switchTo().frame(EdFrame);
//        EdFrame.click();
        robot.keyPress(KeyEvent.VK_TAB);
        driver.switchTo().activeElement().sendKeys("Lagos");
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        driver.switchTo().activeElement().sendKeys("alimosho");
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        driver.switchTo().activeElement().sendKeys("10000001");
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        driver.switchTo().activeElement().sendKeys("+2348038929267");
        Thread.sleep(2000);
        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(5000);

    }

    @Test(priority = 10)
        // click 'create account button'
    void clickCreateAccount() throws InterruptedException {
        WebElement button = driver.findElement(By.xpath("//button[normalize-space()='Create Account']"));
        button.click();
        Thread.sleep(3000);
    }

    @Test(priority = 11)
        // Verify that account created is visible
    void accountCreatedVisibility() throws InterruptedException {
        String expecting = "ACCOUNT CREATED!";
        String created = driver.findElement(By.xpath("//h2//b")).getText();
        Assert.assertEquals(created, expecting);
        Thread.sleep(3000);

    }

    @Test(priority = 12)
        // Click 'continue button'
    void continueButton() throws InterruptedException {
        WebElement cont = driver.findElement(By.xpath("//div[@class='pull-right']/a"));
        cont.click();
        Thread.sleep(3000);
    }

    @Test(priority = 13)
        // Verify that 'logged in as username is visible'
    void loggedInPageVisibility() throws InterruptedException {
        String abbey = "Logged in as abbey";
        String loggedIn = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[10 ]")).getText();
        Assert.assertEquals(loggedIn, abbey);
        Thread.sleep(3000);
    }

    @Test(priority = 14)
        // click 'delete account' button
    void deleteAccount() throws InterruptedException {
        WebElement deleteButton = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[5 ]/a"));
        deleteButton.click();
        Thread.sleep(3000);
    }

    @Test(priority = 15)
        // Verify that 'account deleted' is visible and click 'Continue'
    void accountDeleted() throws InterruptedException {
        String expectedDelMsg = "ACCOUNT DELETED!";
        String actualDelMsg = driver.findElement(By.xpath("//div[@class='col-sm-9 col-sm-offset-1']/h2/b")).getText();
        Assert.assertEquals(actualDelMsg,expectedDelMsg);
        Thread.sleep(3000);
    }

    //@AfterClass
    void tearDown() {
        driver.quit();
    }

}
