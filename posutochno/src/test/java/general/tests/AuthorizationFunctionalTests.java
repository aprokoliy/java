package general.tests;

import general.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by user on 29-Nov-16.
 */
public class AuthorizationFunctionalTests extends TestBase {

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

