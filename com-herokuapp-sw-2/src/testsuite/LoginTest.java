package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {
        //from BaseTest class.. calling method
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find userName WebElement by id
        WebElement emailField = driver.findElement(By.id("username"));
        ///Sending userName filed value
        emailField.sendKeys("tomsmith");
        //to find the password field element
        //find password field webelement by name
        WebElement passfeild = driver.findElement(By.name("password"));
        //Sending password to password filed element
        passfeild.sendKeys("SuperSecretPassword!");

       //find login element and click
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();
        //find 'Secure Area' text on webpage
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[contains(text(),'Secure Area')]"));
        String actualText = actualTextElement.getText();

        String expectedText ="Secure Area";
        //validate actual and expected text
        Assert.assertEquals("'Secure Area' text not found ",expectedText,actualText);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        WebElement emailField = driver.findElement(By.id("username"));//find userName WebElement by id
        emailField.sendKeys("tomsmith1");///Sending userName filed value
        //to find the password field element
        WebElement passwordFeild = driver.findElement(By.name("password"));//find password field webelement by name
        passwordFeild.sendKeys("SuperSecretPassword!"); //Sending password to password filed element

       //find login element and click
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();
        //find 'Your username is invalid!' erroe message on webpage
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualText = actualTextElement.getText();
        String actualTextFinal=actualText.substring(0,25);//get the exact actual message as required

        String expectedText ="Your username is invalid!";
        //validate actual and expected text
        Assert.assertEquals("'Your username is invalid!' error message not found ",expectedText,actualTextFinal);
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        WebElement emailField = driver.findElement(By.id("username"));//find userName WebElement by id
        emailField.sendKeys("tomsmith");///Sending userName filed value
        //to find the password field element
        WebElement passwordFeild = driver.findElement(By.name("password"));//find password field webelement by name
        passwordFeild.sendKeys("SuperSecretPassword"); //Sending password to password filed element

        //find login element and click
        WebElement loginButton = driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']"));
        loginButton.click();
        //find 'Your username is invalid!' erroe message on webpage
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));
        String actualText = actualTextElement.getText();
        String actualTextFinal=actualText.substring(0,25);//get the exact actual message as required

        String expectedText ="Your password is invalid!";
        //validate actual and expected text
        Assert.assertEquals("'Your password is invalid!' error message not found ",expectedText,actualTextFinal);

    }
    @After
    public void tearDown() {
        closeBrowser();
    }
}