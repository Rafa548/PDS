package Ex2;

import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

public class ReadTXT implements ContactsStorageInterface {

    private List<Contact> list;

    public ReadTXT() {
        list = new ArrayList<Contact>();
    }

    public List<Contact> loadContacts() {
        return list;
    }

    public boolean saveContacts(List<Contact> list) {
        this.list = list;
        File file = new File("contacts.txt");
        try {
            FileWriter fw = new FileWriter(file);
            for (Contact c : list) {
                fw.write(c.getName() + " " + c.getPhone() + "\t");
            }
            fw.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }

}
