package locators;

import locators.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class LocatorsTest extends BaseTest {
    String userName = "user-name";
    String password = "password";
    String loginButton = "login-button";
    String cartButton = "//a[@class='shopping_cart_link']";

    @Test
    public void checkLocators() {
        driver.get(url);
        driver.findElement(By.id(userName)).sendKeys("standard_user");
        driver.findElement(By.id(password)).sendKeys("secret_sauce");
        driver.findElement(By.id(loginButton)).click();
        String nameProduct = driver.findElement(By.xpath
                ("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']")).getText();
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        WebElement continueShoppingButton = driver.findElement(By.name("continue-shopping"));
        WebElement checkoutButton = driver.findElement(By.id("checkout"));
        WebElement firstName = driver.findElement(By.id("first-name"));
        WebElement lastName = driver.findElement(By.id("last-name"));
        WebElement postalCode = driver.findElement(By.id("postal-code"));
        WebElement continueButton = driver.findElement(By.id("continue"));
        WebElement footer = driver.findElement(By.tagName("footer"));
        WebElement socialTwitter = driver.findElement(By.className("social_twitter"));
        WebElement twitter = driver.findElement(By.linkText("Twitter"));
        WebElement linkedIn = driver.findElement(By.partialLinkText("In"));

        WebElement burgerMenuButton = driver.findElement(By.cssSelector(".bm-burger-button"));
        WebElement allItemsInBurgerMenu = driver.findElement(By.cssSelector("#inventory_sidebar_link"));
        WebElement aboutInBurgerMenu = driver.findElement(By.cssSelector(".bm-menu .bm-item-list a#about_sidebar_link"));
        WebElement resetAppStateInBurgerMenu = driver.findElement(By.cssSelector("#reset_sidebar_link"));
        WebElement shoppingCart = driver.findElement(By.cssSelector("a.shopping_cart_link"));
        WebElement twitterLink = driver.findElement(By.cssSelector("[href='https://twitter.com/saucelabs']"));
        List<WebElement> allLinks = driver.findElements(By.cssSelector("[target~=\"_blank\"]"));
        WebElement photoT_Shirt = driver.findElement(By.cssSelector("[id*='1_img']"));
        WebElement sortByAz = driver.findElement(By.cssSelector("[value|=\"az\"]"));
        WebElement sortHighToLow = driver.findElement(By.cssSelector("[value$=\"o\"]"));
        WebElement sortLowToHigh = driver.findElement(By.cssSelector("[value^=\"l\"]"));

        WebElement sortButton = driver.findElement(By.xpath("//select[@data-test='product_sort_container']"));
        WebElement sortAtoZ = driver.findElement(By.xpath("//select[@data-test='product_sort_container']/option[1]"));
        String textFooter = driver.findElement(By.xpath("//div[contains(@class,'footer')]")).getText();
        WebElement findByText = driver.findElement(By.xpath("//div[text()='carry.allTheThings() with the " +
                "sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.']"));
        WebElement findByPartOfText = driver.findElement(By.xpath("//div[contains(text(),'This classic Sauce Labs t-shirt')]"));
        List<WebElement> sort = driver.findElements(By.xpath("//select[@class='product_sort_container']//ancestor::option"));
        WebElement buttonAddToCartBackpack = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        WebElement productPhoto = driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']"));
        String productName = driver.findElement
                (By.xpath("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']")).getText();
        WebElement sortButton1 = driver.findElement(By.xpath("//*[@class='product_sort_container' and @data-test='product_sort_container']"));
        String price = driver.findElement(By.xpath("//div[@class='inventory_item_price'][1]")).getText();
        WebElement fieldFirstName = driver.findElement(By.xpath
                ("//input[@class='input_error form_input' and @placeholder='First Name']"));
        WebElement fieldLastName = driver.findElement(By.xpath
                ("//input[@class='input_error form_input' and @placeholder='Last Name']"));
        WebElement fieldZipPostalCode = driver.findElement(By.xpath
                ("//input[@class='input_error form_input' and @placeholder='Zip/Postal Code']"));
        WebElement redCircleInCart = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        WebElement t_ShirtRed = driver.findElement(By.xpath
                ("//div[@class='inventory_item_name' and text()='Test.allTheThings() T-Shirt (Red)']"));


    }
}
