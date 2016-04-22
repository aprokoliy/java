package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class NewContactcreation extends TestBase {


    
    @Test
    public void newContactcreation() {

        app.initUserCriation();
        app.fillPersonalData(new GroupPersonalData("ann", "no", "Prokoliy", "anno"));
        app.fillAddressData(new GroupAddressData("Kharkov"));
        app.fillAdditionalInfo(new AdditionalInfo("0661738633", "ann.prok@gmail.com", "1983"));
       // app.wd.findElement(By.xpath("//div[@id='content']/form/input[21]")).click();
    }


}
