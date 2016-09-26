package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertEquals;

/**
 * Created by user on 26-Apr-16.
 */
public class GroupModificationTest extends TestBase {

    @BeforeMethod
    public void ensurePreconditions(){
       if( app.db().groups().size()==0){
           app.goTo().groupPage();
           app.group().create(new GroupData().withName("test2"));
        }
    }

    @Test
    public void testGroupModification(){
        Groups before = app.db().groups();
        GroupData  modifiedGroup = before.iterator().next();
        GroupData group;
        group = new GroupData().withId(modifiedGroup.getId()).withName("test3").withHeader("test2").withFooter("test3");
        app.goTo().groupPage();
       app.group().modify(group);
        assertEquals(app.group().count(),before.size());
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(modifiedGroup).withAdded(group)));
        verifyGroupListInUI();
    }


}