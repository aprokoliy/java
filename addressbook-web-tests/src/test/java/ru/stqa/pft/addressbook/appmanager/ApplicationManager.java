package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.tests.AdditionalInfo;
import ru.stqa.pft.addressbook.tests.GroupAddressData;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.tests.GroupPersonalData;

import java.util.concurrent.TimeUnit;

/**
 * Created by user on 22-Apr-16.
 */
public class ApplicationManager {
    FirefoxDriver wd;

    public static boolean isAlertPresent(FirefoxDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    public void init() {
        wd = new FirefoxDriver();
        wd.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wd.get("http://localhost/addressbook/addressbook/");
        login("admin", "secret");
    }

    public  void login(String username, String password) {
        wd.findElement(By.name("user")).click();
        wd.findElement(By.name("user")).clear();
        wd.findElement(By.name("user")).sendKeys(username);
        wd.findElement(By.name("pass")).click();
        wd.findElement(By.name("pass")).clear();
        wd.findElement(By.name("pass")).sendKeys(password);
        wd.findElement(By.xpath("//form[@id='LoginForm']/input[3]")).click();
    }

    public  void returtToGroupPage() {
        wd.findElement(By.linkText("group page")).click();
    }

    public  void submitGroupCreation() {
        wd.findElement(By.name("submit")).click();
    }

    public  void fillGroupForm(GroupData groupData) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
    }

    public  void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }

    public  void gotoGroupPage() {
        wd.findElement(By.linkText("groups")).click();
    }

    public  void stop() {
        wd.quit();
    }

    public  void deleteSelectedGroup() {
        wd.findElement(By.name("delete")).click();
    }

    public  void selectGroup() {
        wd.findElement(By.name("selected[]")).click();
    }

    public  void fillAdditionalInfo(AdditionalInfo additionalInfo) {
        wd.findElement(By.name("mobile")).click();
        wd.findElement(By.name("mobile")).clear();
        wd.findElement(By.name("mobile")).sendKeys(additionalInfo.getPhone());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(additionalInfo.getEmail());
        wd.findElement(By.name("byear")).click();
        wd.findElement(By.name("byear")).clear();
        wd.findElement(By.name("byear")).sendKeys(additionalInfo.getByear());
    }

    public  void fillAddressData(GroupAddressData groupAddressData) {
        wd.findElement(By.name("address")).click();
        wd.findElement(By.name("address")).clear();
        wd.findElement(By.name("address")).sendKeys(groupAddressData.getAddress());
    }

    public void fillPersonalData(GroupPersonalData groupPersonalData) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(groupPersonalData.getFirstname());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(groupPersonalData.getMiddlename());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(groupPersonalData.getSurname());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(groupPersonalData.getNickname());
    }

    public  void initUserCriation() {
        wd.findElement(By.linkText("add new")).click();
    }
}
