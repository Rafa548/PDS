package Ex2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException{
        //create a new contact

        Contact c1 = new Contact("John", "123456789");
        Contact c2 = new Contact("Mary", "987654321");
        Contact c3 = new Contact("Peter", "1234789");
        Contact c4 = new Contact("Johnana", "98765421");
        Contact c5 = new Contact("Marybach", "123456789");
        Contact c6 = new Contact("Peterson", "9874321");
        Contact c7 = new Contact("Johnathan", "123456789");
        Contact c8 = new Contact("Maryson", "97654321");
       
        //add the contact to the list
        List<Contact> list = new ArrayList<Contact>();
        list.add(c1);
        list.add(c2);
        list.add(c3);
        list.add(c4);
        list.add(c5);
        list.add(c6);
        list.add(c7);
        list.add(c8);

        ReadTXT txt = new ReadTXT();
        txt.saveContacts(list);
        System.out.println(txt.loadContacts());

        Readbinario bin = new Readbinario();
        bin.saveContacts(list);
        System.out.println(bin.loadContacts());

    }
    
}
