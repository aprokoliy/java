package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation () {

        app.goTo().groupPage();
        Groups before = (Groups) app.group().all();
        GroupData group = new GroupData().withName("test45");
        app.group().create(group);
        Groups after = (Groups) app.group().all();
        assertThat(app.group().count(),equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

    }


    @Test
    public void testBadGroupCreation () {

        app.goTo().groupPage();
        Groups before = (Groups) app.group().all();
        GroupData group = new GroupData().withName("test45'");
        app.group().create(group);
        Groups after = (Groups) app.group().all();
        assertThat(app.group().count(),equalTo(before.size()));
        assertThat(after, equalTo(before));

    }

}
