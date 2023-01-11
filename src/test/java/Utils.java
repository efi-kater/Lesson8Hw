import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {

    public static ChromeDriver newChromeDriver(){
        System.setProperty("webdriver.chrome.driver", Constants.CHROMEDRIVER_PATH);
        ChromeDriver chromeDriver = new ChromeDriver();
        return chromeDriver;
    }

    public static FirefoxDriver newFireFoxDriver(){
        System.setProperty("webdriver.gecko.driver", Constants.FIREFOXDRIVER_PATH);
        FirefoxDriver firefoxDriver = new FirefoxDriver();
        return firefoxDriver;
    }
}
