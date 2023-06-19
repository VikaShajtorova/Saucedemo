package tests;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class InventoryTest extends BaseTest{
    @Test
    public void addItemToCart(){
        loginPage.logInWithValidData();
        inventoryPage.addItemToCartByItemName("Sauce Labs Bike Light");
        inventoryPage.clickCartButton();
        assertEquals("Sauce Labs Bike Light",cartPage.getNameProductInCart("Sauce Labs Bike Light"),
                "Имя товара не совпадает");
    }
    @Test
    public void checkSignDisplayOfProductInCart(){
        loginPage.logInWithValidData();
        inventoryPage.addItemToCartByItemName("Sauce Labs Bike Light");
        inventoryPage.clickCartButton();
        assertEquals(inventoryPage.checkSignDisplayOfProductInCart(),"1",
                "Товар не отображается в красном круге корзины");
    }
    @Test
    public void getPrice(){
        loginPage.logInWithValidData();
        inventoryPage.getPrice("Sauce Labs Bike Light");
    }


}
