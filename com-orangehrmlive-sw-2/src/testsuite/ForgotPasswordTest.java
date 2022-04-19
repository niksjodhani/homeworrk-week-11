package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {
    @Before
    public void setup() {
        openbrowser("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {

        WebElement forgotPassword = driver.findElement(By.xpath("//a[contains(text(),'Forgot your password?')]"));
        forgotPassword.click();//click on the link

        String expectedText = "Forgot Your Password?";
        //find text on webpage
        WebElement actualForgotText = driver.findElement(By.tagName("h1"));
        String actualText = actualForgotText.getText();
        //validate actual and expected text
        Assert.assertEquals("'Forgot Your Password?' text not found", expectedText, actualText);

    }


}
