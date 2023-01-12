
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.JavascriptExecutor;


import java.util.ArrayList;
import java.util.List;

public class TestsChrome {

    private static WebDriver driver;
    @BeforeMethod
    public void initTestsChorme(){

        driver = Utils.newChromeDriver();
    }
    @Test
    public void openWallaTest(){
        driver.get(Constants.WALLA_SITE);
    }

    @Test
    public void findTranslationBoxBy2Methods(){
        driver.get(Constants.GOOGLETRANSLATE_SITE);
        System.out.println(driver.findElement(By.tagName("textarea")));
        System.out.println(driver.findElement(By.xpath("/html/body/c-wiz/div/div[2]/c-wiz/div[2]/c-wiz/div[1]/div[2]/div[3]/c-wiz[1]/span/span/div/textarea")));
        driver.findElement(By.tagName("textarea")).sendKeys("משהו בעברית");
    }

    @Test
    public void findTitle()  {
        driver.get(Constants.AMAZON_SITE);
        String expectedTitle = "Amazon.com : Leather Shoes";
        driver.findElement(By.cssSelector("input[id=twotabsearchtextbox]")).sendKeys("Leather Shoes");
        driver.findElement(By.id("nav-search-submit-button")).click();
        Assert.assertEquals(driver.getTitle(),expectedTitle);

    }

    @Test
    public void findTitleWithScript()  {
        driver.get(Constants.AMAZON_SITE);
        String expectedTitle = "Amazon.com : Leather Shoes";
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript( "document.getElementById('twotabsearchtextbox').value='Leather Shoes'");
        WebElement submitSearch = driver.findElement(By.id("nav-search-submit-button"));
        js.executeScript("arguments[0].click()",submitSearch);
        Assert.assertEquals(driver.getTitle(),expectedTitle);

    }


    @AfterMethod
    public void closeSession(){
        driver.quit();
    }
}
