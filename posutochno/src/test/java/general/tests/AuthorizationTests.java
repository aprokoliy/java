package general.tests;

import general.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

/**
 * Created by Ann Prokoliy on 10-Nov-16.
 */
public class AuthorizationTests extends TestBase{

    //test for checking is present on Log in page
    @Test(priority = 1)
    public void isLogoPresent(){
        app.goToLoginPage();
        Assert.assertTrue(app.isElementPresent("//img[@title='Посуточно']"));
    }

    //test for checking is Logo clickable
    @Test(priority = 2)
    public void isLogoClickable(){
        app.goToLoginPage();
        Assert.assertTrue(app.isElementClickable("//img[@title='Посуточно']"));
    }

    //test for checking whether action passes to Main page after clicking on Logo
    @Test(priority = 3)
    public void isActionPassToMainPage(){
        app.goToLoginPage();
        app.clickOnElement("//img[@title='Посуточно']");
        Assert.assertEquals("Снять квартиру посуточно в Москве",app.getTextOfElement("//h1"));
    }

    //test check is RU and image present
    @Test
    public void ruIsPresent() {
        app.goToLoginPage();
        Assert.assertTrue(app.isElementPresent("//img[@alt='ru']"));
        Assert.assertEquals("RU", app.getTextOfElement("//span[@class='lang-text']"),"Text of image is not RU");
    }

    //test for checking is RU clickable
    @Test(priority = 2)
    public void isRuClickable(){
        app.goToLoginPage();
        Assert.assertTrue(app.isElementClickable("//img[@alt='ru']"));
    }

    //test check is EN and image present
    @Test
    public void isEnPresent() {
        app.goToLoginPage();
        app.clickOnElement("//img[@alt='en']");
        Assert.assertTrue(app.isElementPresent("//img[@alt='en']"));
        Assert.assertEquals("EN", app.getTextOfElement("//span[@class='lang-link active']"),"Text of image is not EN");
    }
    
    //test for checking is EN clickable
    @Test
    public void isEnClickable(){
        app.goToLoginPage();
        Assert.assertTrue(app.isElementClickable("//img[@alt='en']"));
    }

    //test for checking log in with valid, correct data
    @Test
    public void correctLogin(){
        app.goToLoginPage();
        app.fillLoginForm("katerynas@ua.fm","123456");
        app.approveLogIn();
        app.successfulLogIn();
    }

    //test for checking error text, when log in as unregistered user
    @Test(priority = 4)
    public void invalidLogin(){
        app.goToLoginPage();
        app.fillLoginForm("katery@ua.fm","0987654");
        app.approveLogIn();
        Assert.assertEquals("Неверный email или пароль.",app.getErrorMessage());
    }

    //test for checking error text, when try to log in without filling in any fields
    @Test(enabled = false)
    public void emptyFields(){
        app.goToLoginPage();
        app.approveLogIn();
        Assert.assertEquals("Неверный email или пароль.",app.getErrorMessage());
    }

     //test for checking error text, when enter invalid format of email while log in
    @Test(priority = 5)
    public void incorrectEmailFormat(){
        app.goToLoginPage();
        app.fillLoginForm("katerua.fm","123456");
        app.approveLogIn();
        Assert.assertEquals("Неверный email или пароль.",app.getErrorMessage());
    }

    @Test(priority = 6)
    public void incorrectPasswordFormat(){
        app.goToLoginPage();
        app.fillLoginForm("katerynas@ua.fm","1");
        app.approveLogIn();
        Assert.assertEquals("Неверный email или пароль.",app.getErrorMessage());
    }
}
