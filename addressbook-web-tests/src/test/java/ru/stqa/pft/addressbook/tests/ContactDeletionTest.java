package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactPersonalData;

/**
 * Created by user on 26-Apr-16.
 */
public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() {

        if(!app.contact().isContactExist()){
           app.contact().createNewContact(new ContactPersonalData("ann", "no", "Prokoliy", "anno"));
            app.goTo().HomePage();
        }
        int before = app.contact().count();
        app.contact().selectCheckBox(before-1);
        app.contact().pathToDelete();
        app.goTo().HomePage();
        int after = app.contact().count();
        Assert.assertEquals(after, before-1);
    }
}
