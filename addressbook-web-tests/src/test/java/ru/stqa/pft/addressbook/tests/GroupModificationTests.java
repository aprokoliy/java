package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;

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
        int before = app.group().count();
        app.group().selectCheckBox(before-1);
        app.group().initGrpoupModification();
        app.group().fill(new GroupData().withName("test2"));
        app.group().submitGroupModification();
        app.group().returnToGroupPage();
        int after = app.group().count();
        Assert.assertEquals(before, after);
    }


}
