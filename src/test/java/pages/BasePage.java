package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.URL;

public class BasePage {
    WebDriver driver;
    String url = "https://www.saucedemo.com/";
    public BasePage(WebDriver driver){
        this.driver = driver;
    }
}
