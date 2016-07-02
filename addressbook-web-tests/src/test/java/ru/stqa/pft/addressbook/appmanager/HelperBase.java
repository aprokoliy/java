package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import java.io.File;


/**
 * Created by user on 26-Apr-16.
 */
public class HelperBase {

   protected final WebDriver wd;
    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
       wd.findElement(locator).click();
    }

    public void type(By locator, String text) {
        click(locator);
        if (text != null) {
            String existingText = wd.findElement(locator).getAttribute("value");
            if (!text.equals(existingText)) {
                wd.findElement(locator).clear();
                wd.findElement(locator).sendKeys(text);
            }
        }
    }
    public void attach(By locator, File file) {
        if (file != null) {
            wd.findElement(locator).sendKeys(file.getAbsolutePath());
            }
        }

    public boolean isAlertPresent() {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    protected boolean isElementPresent(By locator) {
        try{

            wd.findElement(locator);
            return true;
        }catch (NoSuchElementException e){
            return false;
        }
    }

    public  void initUserCreation() {
        click(By.linkText("add new"));
    }

    public int count() {
       return  wd.findElements (By.name("selected[]")).size();
    }

    public void deleteSelectedGroup()
    {click(By.name("delete"));
    }

    public void selectCheckBox(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();

    }
    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='"+ id +"']")).click();

    }

    public void pathToDelete(){
        click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
        wd.switchTo().alert().accept();
    }
}
