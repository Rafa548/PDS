package Ex2;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class TextReader implements TextReaderInterface{

    private File fname;
    private Scanner sc;
    
    public TextReader(File fname) throws FileNotFoundException{
        this.fname = fname;
        sc = new Scanner(fname);
    }

    public boolean hasNext(){
        return sc.hasNextLine();
    }
    
    public String next(){
        return sc.nextLine();
    }

}
