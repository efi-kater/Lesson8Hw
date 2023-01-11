import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class TestsFireFox {
    private static WebDriver driver;
    @BeforeMethod
    public void initTestsFireFox(){

        driver = Utils.newFireFoxDriver();
    }
    @Test
    public void openYnetTest(){
        driver.get(Constants.YNET_SITE);
    }

    @Test
    public void findButtonByIdSearchSong(){
        driver.get(Constants.YUOTUBE_SITE);
        System.out.println(driver.findElement(By.id("search-icon-legacy")));
        driver.findElement(By.cssSelector("input[id=search]")).sendKeys("What if god was one of us");
        driver.findElement(By.cssSelector("input[id=search]")).sendKeys(Keys.ENTER);

    }

    @Test
    public void logToFacebook(){
        driver.get(Constants.FACEBOOK_SITE);
        driver.findElement(By.cssSelector("input[id=email]")).sendKeys("someEmail");
        driver.findElement(By.cssSelector("input[type=password]")).sendKeys("somepPassword");
        driver.findElement(By.cssSelector("input[type=password]")).sendKeys(Keys.ENTER);

    }

    @Test
    public void findTextByName(){
        driver.get(Constants.SELENIUM_SITE);
        System.out.println(driver.findElement(By.name("cmd")));

    }
    @AfterMethod
    public void closeSession(){
        driver.quit();
    }
}
