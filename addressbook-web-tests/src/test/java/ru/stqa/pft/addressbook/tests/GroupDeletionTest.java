package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupDeletionTest extends TestBase {


@BeforeMethod
    public void ensurePreconditions() {
         app.goTo().groupPage();
         if (!app.group().isThereGroup()) {
        app.group().create(new GroupData().withName("test2"));
    }
}
    @Test
    public void testGroupDeletion() {
        List<GroupData> before = app.group().getGroupList();
        app.group().selectCheckBox(before.size()-1);
        app.group().deleteSelectedGroup();
        app.group().returnToGroupPage();
        List<GroupData> after = app.group().getGroupList();
        Assert.assertEquals(after.size(), before.size()-1);

        before.remove(before.size()-1);
        Assert.assertEquals(before,after);

    }


}