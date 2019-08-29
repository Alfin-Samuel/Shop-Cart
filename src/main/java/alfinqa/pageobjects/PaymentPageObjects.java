package alfinqa.pageobjects;

import alfinqa.framework.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by alfinsamuel on 2019-08-28.
 */
public class PaymentPageObjects extends TestBase {
    WebDriver driver;

    public PaymentPageObjects(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".cart_item")
    public WebElement cartSummaryTable;

    public void verifyIfItemIsPresent(String itemName) {
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(cartSummaryTable));
        Assert.assertTrue(getDriver().findElement(By.linkText(itemName)).isDisplayed());
    }
}
