package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    public static final By YOUR_CART_TITLE = By.xpath("//span[text()='Products']");
    public static final By CONTINUE_SOPPING_BUTTON = By.id("continue-shopping");
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By REMOVE_BUTTON = By.id("remove-sauce-labs-backpack");
    public static final By BACK_TO_PRODUCTS_BUTTON = By.id("back-to-products");
    public static final By CART_BUTTON_ON_PAGE_CART = By.xpath("//a[@class='shopping_cart_link']");
    String nameProductInCart = "//div[@class='inventory_item_name' and text()='%s']";
    String productPriceInCart = "//div[text()='%s']//ancestor::div[@class='cart_item_label']//div[@class='inventory_item_price']";
    String removeButton = "//div[text()='%s']//ancestor::div[@class='cart_item_label']//button";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpen() {
        return isExist(YOUR_CART_TITLE);
    }

    public int getSizeListProduct(){
        List<WebElement> webElementList = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        return webElementList.size();
    }

    public String getProductNameInBasketByIndex(int index) {
        List<WebElement> productsInShoppingCart = driver.findElements(By.xpath
                ("//div[@class='inventory_item_name' and text()]//ancestor::div[@class='cart_item_label']"));
        return productsInShoppingCart.get(index).getText();
    }

    public String getNameProductInCart(String itemName) {
        return driver.findElement(By.xpath(String.format(nameProductInCart, itemName))).getText();
    }

    public String getPriceInCartByNameProduct(String itemName) {
        return driver.findElement(By.xpath(String.format(productPriceInCart, itemName))).getText();
    }

    public void clickContinueShoppingButton() {
        driver.findElement(CONTINUE_SOPPING_BUTTON).click();
    }

    public void clickRemoveButton(String itemName) {
        driver.findElement(By.xpath(String.format(removeButton, itemName))).click();
    }

    public void clickCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void clickBackToProductsButton() {
        driver.findElement(BACK_TO_PRODUCTS_BUTTON).click();
    }

    public String getTextInCart() {
        return driver.findElement(CART_BUTTON_ON_PAGE_CART).getText();
    }

}
