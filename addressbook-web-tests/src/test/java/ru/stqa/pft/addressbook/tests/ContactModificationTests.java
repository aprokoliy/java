package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AdditionalInfo;
import ru.stqa.pft.addressbook.model.ContactAddressData;
import ru.stqa.pft.addressbook.model.ContactPersonalData;

/**
 * Created by user on 26-Apr-16.
 */
public class ContactModificationTests extends TestBase {


    @Test
    public void testContactModification(){
        if(!app.getContactHelper().isContactExist()){
            app.getContactHelper().createNewContact(new ContactPersonalData("ann", "no", "Prokoliy", "anno"));
            app.goTo().HomePage();
        }
        app.group().selectCheckBox();
        app.group().initModificationContact();
        app.getContactHelper().fill(new ContactPersonalData("kolia", "hoo", "Mikituk", "mik"));
        app.getContactHelper().fillAddressData(new ContactAddressData("Lvov"));
        app.getContactHelper().fillAdditionalInfo(new AdditionalInfo("0661738633", "ann.prok@gmail.com", "1983"));
        app.group().submitGroupModification();
        app.goTo().HomePage();

    }

}
