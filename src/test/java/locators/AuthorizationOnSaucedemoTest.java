package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

import java.util.List;

public class AuthorizationOnSaucedemoTest extends BaseTest {
    String userName = "user-name";
    String password = "password";
    String loginButton = "login-button";
    String cartButton = "//a[@class='shopping_cart_link']";

    @Test
    public void logInWithValidData() {
        driver.get(url);
        driver.findElement(By.id(userName)).sendKeys("standard_user");
        driver.findElement(By.id(password)).sendKeys("secret_sauce");
        driver.findElement(By.id(loginButton)).click();
        String text = driver.findElement(By.xpath("//span[@class='title']")).getText();

        assertEquals(text, "Products", "Epic sadface: You can only access '/inventory.html' when you are logged");

    }

    @Test
    public void addProductToCart() {
        driver.get(url);
        driver.findElement(By.id(userName)).sendKeys("standard_user");
        driver.findElement(By.id(password)).sendKeys("secret_sauce");
        driver.findElement(By.id(loginButton)).click();
        String nameProduct = driver.findElement(By.xpath
                ("//div[@class='inventory_item_name' and text()='Sauce Labs Backpack']")).getText();
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        assertEquals(nameProduct, "Sauce Labs Backpack", "товар отсутствует в корзине");

    }

    @Test
    public void checkPriceOfProductInCart(){
        driver.get(url);
        driver.findElement(By.id(userName)).sendKeys("standard_user");
        driver.findElement(By.id(password)).sendKeys("secret_sauce");
        driver.findElement(By.id(loginButton)).click();
        String price = driver.findElement(By.xpath
                ("//button[@id='add-to-cart-sauce-labs-backpack']/../div[@class='inventory_item_price']")).getText();
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCartButton.click();
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();

        assertEquals(price,"$29.99","Цена не совпадает");

    }

    @Test
    public void checkProductDisplaySignInShoppingCart(){
        driver.get(url);
        driver.findElement(By.id(userName)).sendKeys("standard_user");
        driver.findElement(By.id(password)).sendKeys("secret_sauce");
        driver.findElement(By.id(loginButton)).click();
        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"));
        addToCartButton.click();
        boolean redCircleInCart = driver.findElement(By.xpath
                ("//span[@class='shopping_cart_badge' and text()='1']")).isDisplayed();

        assertTrue(redCircleInCart, "Товар не отображается в корзине, круг пустой");

    }




}

