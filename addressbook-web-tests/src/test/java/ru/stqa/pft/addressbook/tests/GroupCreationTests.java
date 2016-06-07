package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation () {

        app.goTo().groupPage();
        List<GroupData> before = app.group().getGroupList();
        app.group().create(new GroupData().withName("test2"));
        List<GroupData> after = app.group().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

    }

}
