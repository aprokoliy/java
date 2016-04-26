package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

/**
 * Created by user on 26-Apr-16.
 */
public class ContactDeletionTest extends TestBase {

    @Test
    public void testContactDeletion() {

        app.getGroupHelper().selectCheckBox();
        app.getGroupHelper().pathToDelete();
        app.getNavigationHelper().returnToHomePage();
    }
}
