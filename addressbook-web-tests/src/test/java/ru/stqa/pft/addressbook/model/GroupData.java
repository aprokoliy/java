package ru.stqa.pft.addressbook.model;

public class GroupData {
    private  String name;
    private  String header;
    private  String footer;

    public GroupData withHeader(String header) {
        this.header = header;
        return this;
    }

    public  GroupData withFooter(String footer) {
        this.footer = footer;
        return this;
    }

    public GroupData withName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }
}
