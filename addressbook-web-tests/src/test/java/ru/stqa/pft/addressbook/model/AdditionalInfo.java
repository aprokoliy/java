package ru.stqa.pft.addressbook.model;

public class AdditionalInfo {
    private final String phone;
    private final String email;
    private final String byear;

    public AdditionalInfo(String phone, String email, String byear) {
        this.phone = phone;
        this.email = email;
        this.byear = byear;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getByear() {
        return byear;
    }
}
