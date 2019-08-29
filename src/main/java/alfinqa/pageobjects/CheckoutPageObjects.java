package alfinqa.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by alfinsamuel on 2019-08-28.
 */
public class CheckoutPageObjects {
    WebDriver driver;

    public CheckoutPageObjects(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".cart_navigation a[title='Proceed to checkout']")
    public WebElement proceedToCheckout;

    public void clickProceedToCheckout() {
        proceedToCheckout.click();
    }
}
