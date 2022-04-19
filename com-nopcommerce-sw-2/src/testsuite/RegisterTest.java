package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }


    @Test
    public void register() {
        WebElement register1 = driver.findElement(By.linkText("Register"));
        register1.click();
        //    driver.findElement(By.xpath("//input[@id='gender-male']")).click();
        WebElement Male = driver.findElement(By.xpath("//label[@for='gender-male']"));
        WebElement Female = driver.findElement(By.xpath("//label[@for='gender-female']"));
        if (!Male.isSelected()) {
            Male.click();
        } else {

            Female.click();
        }
        //first name
        WebElement firstname = driver.findElement(By.id("FirstName"));
        firstname.sendKeys("prime");
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("Testing");
        //identify dropdown
        WebElement date = driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        date.sendKeys("28");
        WebElement month = driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        month.sendKeys("08");
        WebElement year = driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        year.sendKeys("1990");
        WebElement emailid = driver.findElement(By.id("Email"));
        emailid.sendKeys("prime1234561@gmail.com");
        WebElement company = driver.findElement(By.id("Company"));
        company.sendKeys("primetesting");
        WebElement password = driver.findElement(By.id("Password"));
        password.sendKeys("123456@");
        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("123456@");
        driver.findElement(By.xpath("//button[@id='register-button']")).click();

    }
    @After
    public void tearDown() {
       closeBrowser();
    }
}
