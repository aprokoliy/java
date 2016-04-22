package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import org.openqa.selenium.*;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation () {

        app.gotoGroupPage();
        app.initGroupCreation();
        app.fillGroupForm(new GroupData("test1", "test2", "test3"));
        app.submitGroupCreation();
        app.returtToGroupPage();
    }
    /*
    public void testNewUserCreation() {
        app.initUserCriation();
        app.findElement(By.name("firstname")).click();
        app.wd.findElement(By.name("firstname")).clear();
        app.wd.findElement(By.name("firstname")).sendKeys("1");
        app.wd.findElement(By.name("middlename")).click();
        app.wd.findElement(By.name("middlename")).clear();
        app.wd.findElement(By.name("middlename")).sendKeys("1");
        app.wd.findElement(By.name("lastname")).click();
        app.wd.findElement(By.name("lastname")).clear();
        app.wd.findElement(By.name("lastname")).sendKeys("1");
        app.wd.findElement(By.name("nickname")).click();
        app.wd.findElement(By.name("nickname")).clear();
        app.wd.findElement(By.name("nickname")).sendKeys("1");
        app.wd.findElement(By.name("email")).click();
        app.wd.findElement(By.name("email")).clear();
        app.wd.findElement(By.name("email")).sendKeys("1.11.@df.fg");
        app.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
        app.wd.findElement(By.id("content")).click();
    }
*/
}
