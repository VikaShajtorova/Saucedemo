package tests;

import static org.testng.Assert.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    @Test
    public void comparePriceOfProductInCartWithPriceInCatalog() {
        loginPage.logInWithValidData();
        inventoryPage.addItemToCartByItemName("Sauce Labs Bike Light");
        String priceInCatalog = inventoryPage.getPrice("Sauce Labs Bike Light");
        inventoryPage.clickCartButton();

        assertEquals(cartPage.getPriceInCartByNameProduct("Sauce Labs Bike Light"),priceInCatalog,
                "Цена не совпадает");

    }

    @Test
    public void pressContinueShoppingButton() {
        loginPage.logInWithValidData();
        inventoryPage.addItemToCartByItemName("Sauce Labs Backpack");
        inventoryPage.clickCartButton();
        cartPage.pressContinueShoppingButton();

        assertTrue(inventoryPage.titleVisible(), "Пользователь не вернулся на страницу inventory");
    }

    @Test
    public void pressRemoveButton() {
        loginPage.logInWithValidData();
        inventoryPage.addItemToCartByItemName("Sauce Labs Backpack");
        inventoryPage.addItemToCartByItemName("Sauce Labs Bike Light");
        inventoryPage.clickCartButton();
        String quantityOfProductsInCart = String.valueOf(cartPage.getTextInCart());
        cartPage.pressRemoveButton("Sauce Labs Backpack");

        assertNotEquals(cartPage.getTextInCart(),quantityOfProductsInCart,"Товар не удален из корзины");

    }

    @Test
    public void pressCheckoutButton() {
        loginPage.logInWithValidData();
        inventoryPage.addItemToCartByItemName("Sauce Labs Backpack");
        inventoryPage.clickCartButton();
        cartPage.pressCheckoutButton();

        assertTrue(checkoutPage.titleOnCheckoutPageIsVisible(), "Пользователь не перешел на страницу Checkout");
    }

    @Test
    public void vhfhfhf(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("hot-spot"))).build().perform();
        Alert alert = driver.switchTo().alert();

    }

}
