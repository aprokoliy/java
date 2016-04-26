package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by user on 25-Apr-16.
 */
public class NavigationHelper extends HelperBase{


    public NavigationHelper(FirefoxDriver wd) {
        super(wd);
    }

    public  void gotoGroupPage() {
        click(By.linkText("groups"));
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

    public  void initUserCreation() {
        click(By.linkText("add new"));
    }

}
