import java.io.IOException;
import alfinqa.framework.TestBase;
import alfinqa.pageobjects.*;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class EndToEndShoppingWorkflowTests extends TestBase {

SupportFormPageObjects supportFormPageObjects ;
SummerDressesPageObjects summerDressesPageObjects;
DressDetailsPageObjects dressDetailsPageObjects;
CheckoutPageObjects checkoutPageObjects;
SignInPageObjects signInPageObjects;
AddressPageObjects addressPageObjects;
ShippingPageObjects shippingPageObjects;
PaymentPageObjects paymentPageObjects;

    @Test
    public void open() throws IOException, InterruptedException {
        //Step #1
        openURL("chrome");

        //Step #2
        supportFormPageObjects = new SupportFormPageObjects(getDriver());
        supportFormPageObjects.chooseDressType(supportFormPageObjects.womenTab, supportFormPageObjects.summerDresses);

        //Step #3
        summerDressesPageObjects = new SummerDressesPageObjects(getDriver());
        summerDressesPageObjects.quickViewDress("Printed Chiffon Dress");

        //Step #4
        dressDetailsPageObjects = new DressDetailsPageObjects(getDriver());
        dressDetailsPageObjects.selectSizeAndAddToCart("M");

        //Step #5 and #6
        supportFormPageObjects = new SupportFormPageObjects(getDriver());
        supportFormPageObjects.checkoutCart();

        //Step #7
        checkoutPageObjects = new CheckoutPageObjects(getDriver());
        checkoutPageObjects.clickProceedToCheckout();

        //Step #8 and #9
        signInPageObjects = new SignInPageObjects(getDriver());
        signInPageObjects.createAccount();
        signInPageObjects.fillMandatoryFieldsAndRegister();

        //Step #10
        addressPageObjects = new AddressPageObjects(getDriver());
        addressPageObjects.proceed();

        //Step #11
        shippingPageObjects = new ShippingPageObjects(getDriver());
        shippingPageObjects.acceptTermsAndProceedToCheckout();

        //Step #12
        paymentPageObjects = new PaymentPageObjects(getDriver());
        paymentPageObjects.verifyIfItemIsPresent("Printed Chiffon Dress");

    }

    @AfterTest
    public void quitBrowser() {
        getDriver().quit();
    }

}

