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
public class AuthorizationUITests extends TestBase{

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
        app.clickOnElement("//img[@src='images/lang-en.png']");
        Assert.assertTrue(app.isElementPresent("//img[@src='images/lang-en.png']"));
        Assert.assertEquals("EN", app.getTextOfElement("//span[@class='lang-link active']"),"Text of image is not EN");
    }

    //test for checking is EN clickable
    @Test
    public void isEnClickable(){
        app.goToLoginPage();
        Assert.assertTrue(app.isElementClickable("//img[@alt='en']"));
    }

   //test for checking is Registration link and text present
    @Test
    public void isRegistrationLinkPresent() {
        app.goToLoginPage();
        Assert.assertTrue(app.isElementPresent("//a[ @data-ui-sref='signup']"));
        Assert.assertEquals("Регистрация", app.getTextOfElement("//a[ @data-ui-sref='signup']"),"Text of link is not Регистрация");

    }
  
}
