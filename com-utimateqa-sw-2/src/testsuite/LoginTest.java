package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://courses.ultimateqa.com/";

    @Before
    public void open() {

        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {

        driver.findElement(By.linkText("Sign In")).click();
        String expectedResult = "Welcome Back!";
        WebElement element = driver.findElement(By.xpath("//h1[@class='page__heading']"));
        String actualResult = element.getText();

        Assert.assertEquals("error occured", expectedResult, actualResult);

    }

    @Test
    public void verifyTheErrorMessage() {
        driver.findElement(By.linkText("Sign In")).click();
        driver.findElement(By.id("user[email]")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("user[password]")).sendKeys("123456");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        String expectedresult = "Invalid email or password.";
        WebElement element = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));

        String actualResult = element.getText();
        Assert.assertEquals("Error occured", expectedresult, actualResult);

    }


    @After
    public void close() {
        closeBrowser();
    }


}
