package alfinqa.pageobjects;

import alfinqa.framework.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by alfinsamuel on 2019-08-28.
 */
public class SignInPageObjects extends TestBase {
    WebDriver driver;

    public SignInPageObjects(WebDriver driver) {
        // TODO Auto-generated constructor stub
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name="email_create")
    public WebElement emailTextBox;

    @FindBy(css="#SubmitCreate")
    public WebElement createAccountButton;

    @FindBy(css="#customer_firstname")
    public WebElement firstNameTextBox;

    @FindBy(css="#customer_lastname")
    public WebElement lastNameTextBox;

    @FindBy(css="#passwd")
    public WebElement passwordTextBox;

    @FindBy(css="#address1")
    public WebElement addressTextBox;

    @FindBy(css="#city")
    public WebElement cityTextBox;

    @FindBy(css="#id_state")
    public WebElement stateDropDownBox;

    @FindBy(css="#postcode")
    public WebElement zipCodeTextBox;

    @FindBy(css="#phone_mobile")
    public WebElement mobilePhoneTextBox;

    @FindBy(css="#submitAccount")
    public WebElement registerButton;


    /**
     * In order to create a unique email address, system time is considered as there is no possibility for repetition
     */
    public void createAccount() {
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date date = new Date();
        String emailAddress = formatter.format(date)+"@ethoca.ca";
        emailTextBox.sendKeys(emailAddress);
        createAccountButton.click();
    }

    public void fillMandatoryFieldsAndRegister() {
        WebDriverWait wait = new WebDriverWait(getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(firstNameTextBox));
        firstNameTextBox.sendKeys("Ethoca");
        lastNameTextBox.sendKeys("Mastercard");
        passwordTextBox.sendKeys("100SheppardAv");
        addressTextBox.sendKeys("Software Company");
        cityTextBox.sendKeys("North York");
        Select state = new Select(stateDropDownBox);
        state.selectByIndex(3);
        zipCodeTextBox.sendKeys("12345");
        mobilePhoneTextBox.sendKeys("1234567890");
        registerButton.click();
    }


}
