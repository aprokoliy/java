package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AdditionalInfo;
import ru.stqa.pft.addressbook.model.ContactAddressData;
import ru.stqa.pft.addressbook.model.ContactPersonalData;

import java.io.File;

public class NewContactCreation extends TestBase {

    @Test
    public void newContactCreation() {
        app.goTo().initUserCreation();
        File photo=new File("src/test/resources/photo.jpeg");
        app.contact().fill(new ContactPersonalData("ann", "no", "Prokoliy", "anno").withPhoto(photo));
        app.contact().fillAddressData(new ContactAddressData("Kharkov"));
        app.contact().fillAdditionalInfo(new AdditionalInfo("0661738633", "ann.prok@gmail.com", "1983"));
        app.contact().submitContactCreation();
    }
    @Test
    public void currentDir(){
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo=new File("src/test/resources/photo.jpeg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }

}
