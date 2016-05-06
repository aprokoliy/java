package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactPersonalData;

/**
 * Created by user on 26-Apr-16.
 */
public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() {

        if(!app.getContactHelper().isContactExist()){
           app.getContactHelper().createNewContact(new ContactPersonalData("ann", "no", "Prokoliy", "anno"));
            app.getNavigationHelper().returnToHomePage();
        }
        app.getGroupHelper().selectCheckBox();
        app.getGroupHelper().pathToDelete();
        app.getNavigationHelper().returnToHomePage();
    }
}
