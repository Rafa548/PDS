package Ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;


public class Readbinario implements ContactsStorageInterface{

    private List<Contact> list;

    public List<Contact> loadContacts() {
        return list;
    }


    public boolean saveContacts(List<Contact> list) {
        this.list = list;
        File file = new File("contacts.bin");
        try {
            FileWriter fw = new FileWriter(file);
            for (Contact c : list) {
                //convertendo para binario
                String name = c.getName();
                String phone = c.getPhone();
                String Space = " ";
                byte[] nameByte = name.getBytes();
                byte[] phoneByte = phone.getBytes();
                byte[] spaceByte = Space.getBytes();
                String name_bin = prettyBinary(convertByteArraysToBinary(nameByte),8," ");
                String phone_bin = prettyBinary(convertByteArraysToBinary(phoneByte), 8 , " ");
                String Space_bin = prettyBinary(convertByteArraysToBinary(spaceByte), 8 , " ");
                String tab_bin = "00001001";
                
                //escrevendo no arquivo
                fw.write(name_bin + " " + Space_bin + " " + phone_bin + " " + tab_bin + " ");
            }
            fw.close();
            return true;
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
            return false;
        }
    }
    
    public static String convertByteArraysToBinary(byte[] input) {

        StringBuilder result = new StringBuilder();
        for (byte b : input) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                result.append((val & 128) == 0 ? 0 : 1);      // 128 = 1000 0000
                val <<= 1;
            }
        }
        return result.toString();

    }

    public static String prettyBinary(String binary, int blockSize, String separator) {

        List<String> result = new ArrayList<>();
        int index = 0;
        while (index < binary.length()) {
            result.add(binary.substring(index, Math.min(index + blockSize, binary.length())));
            index += blockSize;
        }

        return result.stream().collect(Collectors.joining(separator));
    }
}
