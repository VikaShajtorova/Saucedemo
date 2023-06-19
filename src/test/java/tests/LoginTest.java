package tests;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Test
    public void logInWithValidData(){
        loginPage.logInWithValidData();
        assertTrue(inventoryPage.titleVisible());
    }

    @Test
    public void leaveUserFieldEmpty(){
        loginPage.openWebsite();
        loginPage.authorization("","secret_sauce");
        assertEquals(loginPage.getErrorMassage(),"Epic sadface: Username is required",
                "Текст сообщения неверный или отсутствует");
    }

    @Test
    public void leavePasswordFieldEmpty(){
        loginPage.openWebsite();
        loginPage.authorization("standard_user","");
        assertEquals(loginPage.getErrorMassage(),"Epic sadface: Password is required",
                "Текст сообщения неверный или отсутствует");
    }

    @Test
    public void lockedOutUser(){
        loginPage.openWebsite();
        loginPage.authorization("locked_out_user","secret_sauce");
        assertEquals(loginPage.getErrorMassage(),"Epic sadface: Sorry, this user has been locked out.",
                "Текст сообщения неверный или отсутствует");
    }

}
