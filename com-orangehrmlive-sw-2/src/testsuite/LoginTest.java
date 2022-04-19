package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setup() {
        openbrowser(baseUrl);
    }

    @Test
    public void login() {
        //find username filed and send values
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        //find password field and send values
        WebElement password = driver.findElement(By.id("txtPassword"));
        password.sendKeys("admin123");
        //find element for Login button and click
        WebElement click = driver.findElement(By.xpath("//input[@class='button']"));
        click.click();

        WebElement welcome = driver.findElement(By.id("welcome"));
        String actualText = welcome.getText();//get text value and store it
        //check 'welcome' is displayed or not.
     if(welcome.isDisplayed()){
            System.out.println("'welcome' is displayed");
        }else {
            System.out.println("'welcome' is not displayed");
        }
        String requiredActualText =actualText.substring(0,7);//get first 7 letter -- 'welcome'
        System.out.println(requiredActualText);
        String expectedText = "Welcome";
      //  validate actual and expected text
        Assert.assertEquals("'welcome' text not found ", expectedText, requiredActualText);


    }

}

