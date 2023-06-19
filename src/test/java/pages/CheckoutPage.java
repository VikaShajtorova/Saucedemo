package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public static final By CHECKOUT_TITLE = By.xpath("//span[text()='Checkout: Your Information']");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    public boolean titleOnCheckoutPageIsVisible(){
        return driver.findElement(CHECKOUT_TITLE).isDisplayed();
    }

}
