package delhi.android.nit.com.terratechnica.Contact;

import java.util.List;

/**
 * Created by directioner on 10/4/17.
 */

public class CategChild {

    private String personName;
    private String personContactNo;
    private String personImage;
    private String personSupportLevel;
    ContactsData contactsData;

    public ContactsData getContactsData() {
        return contactsData;
    }

    public void setContactsData(ContactsData contactsData) {
        this.contactsData = contactsData;
        personName = contactsData.getPersonName();
        personContactNo = contactsData.getPersonContactNo();
        personImage = contactsData.getPersonImage();
        personSupportLevel = contactsData.getPersonSupportLevel();
    }

    private String position; // The level of support they are providing!

    private List<Object> childList;

    public CategChild() {
    }

    public CategChild(ContactsData contactsData) {
        personName = contactsData.getPersonName();
        personContactNo = contactsData.getPersonContactNo();
        personImage = contactsData.getPersonImage();
        personSupportLevel = contactsData.getPersonSupportLevel();
    }


    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonContactNo() {
        return personContactNo;
    }

    public void setPersonContactNo(String personContactNo) {
        this.personContactNo = personContactNo;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPersonImage() {
        return personImage;
    }

    public void setPersonImage(String personImage) {
        this.personImage = personImage;
    }

    public String getPersonSupportLevel() {
        return personSupportLevel;
    }

    public void setPersonSupportLevel(String personSupportLevel) {
        this.personSupportLevel = personSupportLevel;
    }

}
