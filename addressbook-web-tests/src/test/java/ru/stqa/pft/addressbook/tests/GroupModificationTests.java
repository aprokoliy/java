package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;

/**
 * Created by user on 26-Apr-16.
 */
public class GroupModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().groupPage();
        if(!app.group().isThereGroup()){
            app.group().create(new GroupData().withName("test2"));
        }
    }

    @Test
    public void testGroupModification(){
        List<GroupData> before = app.group().getGroupList();
        app.group().selectCheckBox(before.size()-1);
        app.group().initGrpoupModification();
        GroupData group = new GroupData().withName("test3");
        app.group().fill(group);
        app.group().submitGroupModification();
        app.group().returnToGroupPage();
        List<GroupData> after = app.group().getGroupList();
        Assert.assertEquals(after.size(),before.size());

        before.remove(before.size()-1);
        before.add(group);
      //  Assert.assertEquals(new HashSet<Object>(before),new HashSet<Object>(after));
    }


}
