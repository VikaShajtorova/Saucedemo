package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{
    public static final By INVENTORY_TITLE = By.xpath("//span[text()='Products']");
    public static final By CART_BUTTON = By.xpath("//a[@class='shopping_cart_link']");
    public static final By SING_PRODUCT_DISPLAY_IN_CART = By.xpath("//span[@class='shopping_cart_badge']");
    String addButtonByItemName = "//div[text()='%s']//ancestor::div[@class='inventory_item']//button";
    String productPrice = "//div[text()='%s']//ancestor::div[@class='inventory_item']//div[@class='inventory_item_price']";


    public InventoryPage(WebDriver driver) {
        super(driver);
    }
    public boolean titleVisible(){
        return driver.findElement(INVENTORY_TITLE).isDisplayed();
    }
    public void addItemToCartByItemName(String itemName){
        driver.findElement(By.xpath(String.format(addButtonByItemName,itemName))).click();
    }

    public String getPrice(String itemName){
        return driver.findElement(By.xpath(String.format(productPrice,itemName))).getText();
    }
    public void clickCartButton(){
        driver.findElement(CART_BUTTON).click();
    }
    public String checkSignDisplayOfProductInCart(){
       return driver.findElement(SING_PRODUCT_DISPLAY_IN_CART).getText();
    }



}
