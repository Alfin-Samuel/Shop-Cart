package alfinqa.pageobjects;

import alfinqa.framework.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alfinsamuel on 2019-08-27.
 */
public class DressDetailsPageObjects extends TestBase {
    WebDriver driver;

    public DressDetailsPageObjects(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css="#group_1")
    public WebElement sizeDropDown;

    @FindBy(css="#quantity_wanted")
    public WebElement quantityDropDown;

    @FindBy(css="#add_to_cart button")
    public WebElement addToCartButton;

    @FindBy(css=".button-container .continue")
    public WebElement continueShopping;

    public void selectSize(String size) {
        Select drpCountry = new Select(sizeDropDown);
        drpCountry.selectByVisibleText(size);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public void selectSizeAndAddToCart(String size) {
        getDriver().switchTo().frame(getDriver().findElement(By.cssSelector(".fancybox-iframe")));
        selectSize("M");
        addToCart();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(continueShopping));
        continueShopping.click();
    }

}
