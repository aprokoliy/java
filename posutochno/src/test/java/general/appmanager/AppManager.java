package general.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static org.openqa.selenium.remote.BrowserType.IE;

/**
 * Created by user on 10-Nov-16.
 */
public class AppManager {

    private WebDriver wd;
    private String browser;


    public AppManager(String browser) {
        this.browser = browser;
    }

    public void init(){

        switch(browser){
            case FIREFOX:
                wd = new FirefoxDriver();
                break;
            case CHROME:
                wd = new ChromeDriver();
                break;
            case IE:
                wd = new InternetExplorerDriver();
                break;
            default:
                System.out.println("Browser is not chosen or another inner error occurs!");
        }
       // wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("https://www.posutochno.com/");
    }

    public void stop() {
      wd.quit();
    }

    public void goToLoginPage(){
        wd.findElement(By.xpath("//a[@data-ui-sref='login']")).click();
    }

    public void fillLoginForm(String email, String password){
        wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(email);
        wd.findElement(By.name("password")).clear();
        wd.findElement(By.name("password")).sendKeys(password);
    }

    public void approveLogIn(){
        wd.findElement(By.xpath("//button[@type='submit']")).click();
    }

    public void successfulLogIn(){
        wd.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        wd.findElement(By.xpath("//a[@data-ui-sref='create-venue']"));
    }

    public void invalidLoginOrPassword(){
        wd.findElement(By.xpath("//*[@id='messages']"));
    }
}

