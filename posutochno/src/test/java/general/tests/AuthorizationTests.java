package general.tests;

import general.TestBase;
import org.testng.annotations.Test;

/**
 * Created by user on 10-Nov-16.
 */
public class AuthorizationTests extends TestBase{

    @Test
    public void correctLogin(){
        app.goToLoginPage();
        app.fillLoginForm("katerynas@ua.fm","123456");
        app.approveLogIn();
        app.successfulLogIn();
    }

    @Test
    public void invalidLogin(){
        app.goToLoginPage();
        app.fillLoginForm("katery@ua.fm","0987654");
        app.approveLogIn();
        app.invalidLoginOrPassword();
    }
}
