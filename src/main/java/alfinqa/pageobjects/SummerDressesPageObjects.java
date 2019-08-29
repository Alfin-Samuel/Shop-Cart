package alfinqa.pageobjects;

import alfinqa.framework.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alfinsamuel on 2019-08-26.
 */
public class SummerDressesPageObjects extends TestBase {
    WebDriver driver;

    public SummerDressesPageObjects(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void quickViewDress(String dressType) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(getDriver().findElement(By.cssSelector("a.product_img_link [title='"+ dressType+"']"))).perform();
        String quickViewCsSelector = "a[title='"+dressType+"']+div+a.quick-view";
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        WebElement quickView = getDriver().findElement(By.cssSelector(quickViewCsSelector));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(quickViewCsSelector)));
        quickView.click();

    }
}
