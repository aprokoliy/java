package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AdditionalInfo;
import ru.stqa.pft.addressbook.model.ContactAddressData;
import ru.stqa.pft.addressbook.model.ContactPersonalData;

/**
 * Created by user on 26-Apr-16.
 */
public class ContactModificationTest extends TestBase {


    @Test
    public void testContactModification(){
        if(!app.contact().isContactExist()){
            app.contact().createNewContact(new ContactPersonalData("ann", "no", "Prokoliy", "anno"));
            app.goTo().HomePage();
        }
        int before = app.contact().count();
        app.group().selectCheckBox(before-1);
        app.group().initModificationContact();
        app.contact().fill(new ContactPersonalData("kolia", "hoo", "Mikituk", "mik"));
        app.contact().fillAddressData(new ContactAddressData("Lvov"));
        app.contact().fillAdditionalInfo(new AdditionalInfo("0661738633", "ann.prok@gmail.com", "1983"));
        app.group().submitGroupModification();
        app.goTo().HomePage();
        int after = app.contact().count();
        Assert.assertEquals(before, after);

    }

}
