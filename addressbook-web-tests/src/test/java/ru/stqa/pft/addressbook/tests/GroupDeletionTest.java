package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

public class GroupDeletionTest extends TestBase {


@BeforeMethod
    public void ensurePreconditions() {
         app.goTo().groupPage();
         if (!app.group().isThereGroup()) {
        app.group().create(new GroupData().withName("tst2"));
    }
}
    @Test
    public void testGroupDeletion() {
        int before = app.group().count();
        app.group().selectCheckBox(before-1);
        app.group().deleteSelectedGroup();
        app.group().returnToGroupPage();
        int after = app.group().count();
        Assert.assertEquals(after, before-1);
    }


}