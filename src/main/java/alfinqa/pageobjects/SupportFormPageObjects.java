package alfinqa.pageobjects;

import alfinqa.framework.TestBase;
import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by alfinsamuel on 2018-08-11.
 */
public class SupportFormPageObjects extends TestBase {
    private static Logger log = LogManager.getLogger(SupportFormPageObjects.class.getName());
    WebDriver driver;

    public SupportFormPageObjects(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".sf-menu a[title='Women']")
    public WebElement womenTab;

    @FindBy(css = "li [title='Women'] + ul li a[title='Summer Dresses']")
    public WebElement summerDresses;

    @FindBy(css=".shopping_cart a")
    public WebElement shoppingCart;

    @FindBy(css="#button_order_cart")
    public WebElement checkOut;

    // Method to verify if the filed is Mandatory or Optional
    public String findOptionalOrNot(WebElement e){
        log.info("Checking the status of "+e.getText());
      String labelText = e.getText();
      if(labelText.contains("*"))
          return "Mandatory" ;
     else
         return "Optional" ;
    }

    // Method to generate French Name
    public String frenchName(){
        Fairy frFairy = Fairy.create();
        Person person = frFairy.person();
        String frenchFullName=person.getFirstName();
        return frenchFullName;
    }

    // Method to generate English Name
    public String englishName(){
        Fairy enFairy = Fairy.create();
        Person person1 = enFairy.person();
        String englishFullName=person1.getFullName();
        return englishFullName;
    }

    /**
     *
     * @param mainCategory This parameter will mention the main category of the clothes available
     * @param subCategory This parameter will mention the sub category of the clothes available
     */
    public void chooseDressType(WebElement mainCategory, WebElement subCategory) {
        Actions action = new Actions(driver);
        action.moveToElement(mainCategory).perform();
        action.click(subCategory).perform();
    }

    public void checkoutCart() {
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(shoppingCart));
        shoppingCart.click();
    }

}
