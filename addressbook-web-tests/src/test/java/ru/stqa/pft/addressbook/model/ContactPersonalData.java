package ru.stqa.pft.addressbook.model;

public class ContactPersonalData {
    private final String firstname;
    private final String middlename;
    private final String surname;
    private final String nickname;

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
