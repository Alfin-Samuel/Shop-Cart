package alfinqa.pageobjects;

import alfinqa.framework.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alfinsamuel on 2019-08-28.
 */
public class ShippingPageObjects extends TestBase {
    WebDriver driver;

    public ShippingPageObjects(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="#uniform-cgv")
    public WebElement agreeTermsCheckBox;

    @FindBy(name="processCarrier")
    public WebElement proceedToCheckoutButton;

    public void acceptTermsAndProceedToCheckout() {
       WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(agreeTermsCheckBox));
        if(!agreeTermsCheckBox.isSelected())
            agreeTermsCheckBox.click();
        proceedToCheckoutButton.click();
    }
}
