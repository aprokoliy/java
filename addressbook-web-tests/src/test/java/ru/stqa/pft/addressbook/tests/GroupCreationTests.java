package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation () {

        app.goTo().groupPage();
        List<GroupData> before = app.group().getGroupList();
        GroupData group = new GroupData().withName("test45");
        app.group().create(group);
        List<GroupData> after = app.group().getGroupList();
        Assert.assertEquals(after.size(), before.size() + 1);

        group.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(),o2.getId())).get().getId());
        before.add(group);
       // Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }

}
