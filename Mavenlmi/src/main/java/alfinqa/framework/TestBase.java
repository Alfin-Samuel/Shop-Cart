package alfinqa.framework;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.*;

/**
 * Created by alfinsamuel
 */
public class TestBase {

    private static Logger log= LogManager.getLogger(TestBase.class.getName());
    public static WebDriver driver;

    /**
     * This method will open the URL mentioned in the input.properties file
     * @param browser This parameter is used to mention browser in which URL need to be maintained
     * @throws IOException
     */

    public void openURL(String browser) throws IOException
    {
        String currentDir = System.getProperty("user.dir");
        File file = new File(currentDir+"/input.properties");
        log.info("Launching page...");
        log.error("Launching page...");
        String canonicalPath=file.getCanonicalPath();
        Properties prop=new Properties();
        FileInputStream fis=new FileInputStream(canonicalPath);
        prop.load(fis);
               String browserToUse=browser;
               log.info("Tests are going to run in "+browserToUse );
        //String browserToUse=prop.getProperty("Browser");


        if(browserToUse.equalsIgnoreCase("firefox"))
        {
            FirefoxDriverManager.getInstance().setup();
            driver = new FirefoxDriver();

        }
        else if (browserToUse.equalsIgnoreCase("chrome"))
        {
            ChromeDriverManager.getInstance().version("76").setup();
            driver=new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            log.info("Opened the Chrome Browser");

        }
        driver.manage().window().maximize();
        log.info("Window is maximised");
        driver.get(prop.getProperty("URL"));
        log.info("Opening the Page "+ prop.getProperty("URL"));


    }

    public WebDriver getDriver() {
        return driver;

    }
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isExists(WebElement e) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(e));
        boolean result=false;
        if(element.isDisplayed()){
            result=true;}
        return result;
    }
    public static String email(){
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Date date = new Date();
        String name=dateFormat.format(date);
        String email=name+"@amail.com";
        return email;
    }
    public void click(WebElement e) throws InterruptedException {
        if(isExists(e)){
            e.click();
                   }
    }
    public void enterText(WebElement e,String text) throws InterruptedException {
        e.clear();
        e.sendKeys(text);

    }
}
