package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopMenuTest extends BaseTest {
    String baseUrl = "https://demo.nopcommerce.com/";
    @Before
    public void setup() {
        openBrowser(baseUrl);
    }


    @Test
    public void userShouldNavigateToComputerPageSuccessfully() {

        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/computers']")).click();
        String expectedmessage = "Computers";
        WebElement actulMessageElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actuleMessage = actulMessageElement.getText();
        Assert.assertEquals("Not found", expectedmessage, actuleMessage);
    }

    @Test
    public void userShouldNavigateToElectronicsPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/electronics']")).click();
        String expectedmessage = "Electronics";
        WebElement actulMessageElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actuleMessage = actulMessageElement.getText();
        Assert.assertEquals("Not found", expectedmessage, actuleMessage);
    }

    @Test
    public void userShouldNavigateToApparelPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/apparel']")).click();
        String expectedmessage = "Apparel";
        WebElement actulMessageElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actuleMessage = actulMessageElement.getText();
        Assert.assertEquals("Not found", expectedmessage, actuleMessage);
    }

    @Test
    public void userShouldNavigateToDigitaldownloadsPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/digital-downloads']")).click();
        String expectedmessage = "Digital downloads";
        WebElement actulMessageElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actuleMessage = actulMessageElement.getText();
        Assert.assertEquals("Not found", expectedmessage, actuleMessage);
    }


    @Test
    public void userShouldNavigateToBooksPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/books']")).click();
        String expectedmessage = "Books";
        WebElement actulMessageElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actuleMessage = actulMessageElement.getText();
        Assert.assertEquals("Not found", expectedmessage, actuleMessage);


    } @Test
    public void userShouldNavigateToJewelryPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/jewelry']")).click();
        String expectedmessage = "Jewelry";
        WebElement actulMessageElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actuleMessage = actulMessageElement.getText();
        Assert.assertEquals("Not found", expectedmessage, actuleMessage);


    } @Test
    public void userShouldNavigateToGiftCardsPageSuccessfully() {
        driver.findElement(By.xpath("//ul[@class='top-menu notmobile']//a[@href='/gift-cards']")).click();
        String expectedmessage = "Gift Cards";
        WebElement actulMessageElement = driver.findElement(By.xpath("//div[@class='page-title']"));
        String actuleMessage = actulMessageElement.getText();
        Assert.assertEquals("Not found", expectedmessage, actuleMessage);


    }
    @After
    public void setupclose(){
        closeBrowser();
    }

}
