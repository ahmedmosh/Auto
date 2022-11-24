package Scenarios;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**The program verifies that user can login using correct email and password.
 * It uses data Listeners from listener package.
 */

public class Positive extends PreReq {
    // Click on Sign up
    @Test(priority = 1)
    void LoginUserButton(){
        WebElement signup = driver.findElement(By.xpath("//ul[@class='nav navbar-nav']//li[4]//a"));
        signup.click();
    }
    // verify that 'Login to your account' is visible
    @Test(priority = 2)
    void LoginVisibility(){
        String expectedLoginVis = "Login to your account";
        String actualLoginVis = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']")).getText();
        Assert.assertEquals(actualLoginVis,expectedLoginVis);
    }
    // Verify that user can login using registered credentials
    // @DataProvider (name = DataListeners.datalist)
    @Test(priority = 3)
    void Login(){
        WebElement LoginEmailField = driver.findElement(By.xpath("//input[2][@name='email']"));
        LoginEmailField.sendKeys("abiodunmoshood1000@gmail.com");
        WebElement LoginPwdField = driver.findElement(By.xpath("//input[3][@name='password']"));
        LoginPwdField.sendKeys("abiodun");
    }
}
