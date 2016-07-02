package ru.stqa.pft.addressbook.model;

import java.io.File;

public class ContactPersonalData {
    private final String firstname;
    private final String middlename;
    private final String surname;
    private final String nickname;
    private File photo;

    public ContactPersonalData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public File getPhoto() {
        return photo;
    }

    public ContactPersonalData(String firstname, String middlename, String surname, String nickname) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.surname = surname;
        this.nickname = nickname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getSurname() {
        return surname;
    }

    public String getNickname() {
        return nickname;
    }
}
