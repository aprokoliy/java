package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.AdditionalInfo;
import ru.stqa.pft.addressbook.model.ContactAddressData;
import ru.stqa.pft.addressbook.model.ContactPersonalData;

/**
 * Created by user on 26-Apr-16.
 */
public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public  void fillAdditionalInfo(AdditionalInfo additionalInfo) {
        type(By.name("mobile"),additionalInfo.getPhone());
        type(By.name("email"),additionalInfo.getEmail());
        type(By.name("byear"),additionalInfo.getByear());
    }

    public  void fillAddressData(ContactAddressData groupAddressData) {
        type(By.name("address"), groupAddressData.getAddress());

    }

    public void fillPersonalData(ContactPersonalData groupPersonalData) {
        type(By.name("firstname"),groupPersonalData.getFirstname());
        type(By.name("middlename"),groupPersonalData.getMiddlename());
        type(By.name("lastname"),groupPersonalData.getSurname());
        type(By.name("nickname"),groupPersonalData.getNickname());

    }
    
    public void submitContactCreation(){
        click(By.xpath("//div[@id='content']/form/input[21]"));
}

    public boolean isContactExist() {
        return isElementPresent(By.name("selected[]"));
    }

    public void createNewContact(ContactPersonalData  contact) {
        initUserCreation();
        fillPersonalData(contact);
        submitContactCreation();


    }
}

