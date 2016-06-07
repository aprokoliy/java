package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.AdditionalInfo;
import ru.stqa.pft.addressbook.model.ContactAddressData;
import ru.stqa.pft.addressbook.model.ContactPersonalData;

public class NewContactCreation extends TestBase {

    @Test
    public void newContactCreation() {
        app.goTo().initUserCreation();
        app.contact().fill(new ContactPersonalData("ann", "no", "Prokoliy", "anno"));
        app.contact().fillAddressData(new ContactAddressData("Kharkov"));
        app.contact().fillAdditionalInfo(new AdditionalInfo("0661738633", "ann.prok@gmail.com", "1983"));
        app.contact().submitContactCreation();
    }

}
