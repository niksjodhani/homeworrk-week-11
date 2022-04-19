package testsuite;

import browserfactory.BaseTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

//before run this class  pls run RegisterTest class once
public class LoginTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void navigateToLogin() {
        //find login link and click on login link
        WebElement loginlink = driver.findElement(By.linkText("Log in"));
        loginlink.click();
        // find the welcome element and get text
        String expectedmessage = "Welcome, Please Sign In!";
        WebElement actulMessageElement = driver.findElement(By.xpath("//div[@class='master-wrapper-content']//div[@class='page-title']"));
        String actuleMessage = actulMessageElement.getText();

        // validate actual and expected message
        Assert.assertEquals("not navigate to login page", expectedmessage, actuleMessage);
    }

    //before run this methode pls run RegisterTest class once
    @Test
    public void loginverify() {

        driver.findElement(By.linkText("Log in")).click();
        WebElement emailField = driver.findElement(By.id("Email"));
        //sending email to email field element
        emailField.sendKeys("prime1234561@gmail.com");
        //Find the password field element
        WebElement passwordField = driver.findElement(By.name("Password"));
        //sending password to password field element
        passwordField.sendKeys("123456@");

        WebElement loginLink1 = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginLink1.click();
        String expectedErrorMessage = "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        WebElement actualErrorMessageElement = driver.findElement(By.xpath("//div[@class=\"message-error validation-summary-errors\"]"));
        String actualMessageError = actualErrorMessageElement.getText();
        Assert.assertEquals("error occured", expectedErrorMessage, actualMessageError);
    }

    @Test
    public void logout() {

        driver.findElement(By.linkText("Log in")).click();
        WebElement emailField = driver.findElement(By.id("Email"));
        //sending email to email field element
        emailField.sendKeys("prime1234561@gmail.com");
        //Find the password field element
        WebElement passwordField = driver.findElement(By.name("Password"));
        //sending password to password field element
        passwordField.sendKeys("123456@");

        WebElement loginLink1 = driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
        loginLink1.click();

        String expectedmessage = "Log out";
        WebElement actulMessageElement = driver.findElement(By.xpath("//div[@class='header-links']//a[@href='/logout']"));
        String actuleMessage = actulMessageElement.getText();
        System.out.println(actuleMessage);
        //validate actual and expected message
        Assert.assertEquals("no user have account", expectedmessage, actuleMessage);
        driver.findElement(By.xpath("//div[@class='header-links']//a[@href='/logout']")).click();
    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}