package ru.stqa.pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.pft.addressbook.model.GroupData;


import java.util.Set;
import java.util.regex.Matcher;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class GroupCreationTests extends TestBase {

    @Test
    public void testGroupCreation () {

        app.goTo().groupPage();
        Set<GroupData> before = app.group().all();
        GroupData group = new GroupData().withName("test45");
        app.group().create(group);
        Set<GroupData> after = app.group().all();
        assertThat(after.size(),equalTo(before.size() + 1));
        group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
        before.add(group);

        assertThat(after, equalTo(before));

    }

}
