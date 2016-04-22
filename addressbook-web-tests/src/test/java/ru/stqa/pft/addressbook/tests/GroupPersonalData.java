package ru.stqa.pft.addressbook.tests;

public class GroupPersonalData {
    private final String firstname;
    private final String middlename;
    private final String surname;
    private final String nickname;

    public GroupPersonalData(String firstname, String middlename, String surname, String nickname) {
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
