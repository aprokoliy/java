package ru.stqa.pft.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;


public class GroupCreationTest extends TestBase {



    @DataProvider
    public Iterator<Object[]> validGroupsFromXml() throws IOException {
        try( BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.xml")))){
            String xml = "";
            String line = reader.readLine();
            while(line!=null) {
                xml +=line;
                line= reader.readLine();
            }
            XStream xstream = new XStream();
            xstream.processAnnotations(GroupData.class);
            List<GroupData> groups = (List<GroupData>)xstream.fromXML(xml);
            return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @DataProvider
    public Iterator<Object[]> validGroupsFromJson() throws IOException {
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/groups.json")))){
            String json = "";
            String line = reader.readLine();
            while(line!=null) {
                json +=line;
                line= reader.readLine();
            }
            Gson gson = new Gson();
            List<GroupData> groups= gson.fromJson(json, new TypeToken<List<GroupData>>(){}.getType()); // List<GroupData>.class
            return groups.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
        }
    }

    @Test(dataProvider = "validGroupsFromJson")
    public void testGroupCreation (GroupData group) {

        app.goTo().groupPage();
        Groups before = app.db().groups();
        app.goTo().groupPage();
        app.group().create(group);
        Groups after = app.db().groups();
        assertThat(app.group().count(),equalTo(before.size() + 1));
        assertThat(after, equalTo(
                before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
        verifyGroupListInUI();

    }


    @Test
    public void testBadGroupCreation () {

        app.goTo().groupPage();
        Groups before = (Groups) app.db().groups();
        GroupData group = new GroupData().withName("test45'");
        app.goTo().groupPage();
        app.group().create(group);
        Groups after = (Groups) app.db().groups();
        assertThat(app.group().count(),equalTo(before.size()));
        assertThat(after, equalTo(before));
        verifyGroupListInUI();

    }

}