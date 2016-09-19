package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;
import static org.openqa.selenium.remote.BrowserType.IE;

/**
 * Created by user on 22-Apr-16.
 */
public class ApplicationManager {

    private SessionHelper sessionHelper;
    private WebDriver wd;
    private NavigationHelper navigationHelper;
    private GroupHelper groupHelper;
    private ContactHelper contactHelper;
    private String browser;
    private DBHelper dbHelper;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }


    public void init() {

        dbHelper = new DBHelper();
        /*
        if (browser.equals(BrowserType.FIREFOX)) {
            wd = new FirefoxDriver();
        } else if (browser.equals(BrowserType.CHROME)) {
            wd = new ChromeDriver();
        } else if (browser.equals(BrowserType.IE)) {
            wd = new InternetExplorerDriver();
        }*/

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

       // wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/addressbook/");
        //wd.get(properties.)
        groupHelper = new GroupHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        sessionHelper = new SessionHelper(wd);
        contactHelper = new ContactHelper(wd);
        sessionHelper.login("admin", "secret");

    }

    public void stop() {
        wd.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public ContactHelper contact()
    {
        return contactHelper;
    }

    public DBHelper db(){

        return dbHelper;
    }
}