package Ex2;

import java.io.File;
import java.io.FileNotFoundException;

import Ex2.NormalizationFilter;


public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        File f = new File("Ex2/ran.txt");
        TextReaderInterface tr = new TextReader(f);
        TermFilter tr2 = new TermFilter(tr);
        NormalizationFilter tr3 = new NormalizationFilter(tr2);
        /* while(tr.hasNext()){
            System.out.println(tr.next());
            System.out.println();
        } */

        /* while(tr2.hasNext()){
            System.out.println(tr2.next());
            System.out.println();
        } */

        while(tr3.hasNext()){
            System.out.println(tr3.next());
            System.out.println();
        }
        System.out.println("-----------------------");

        //VowelFilter tr4 = new VowelFilter(tr3);
        /* while(tr4.hasNext()){
            System.out.println(tr4.next());
            System.out.println();
        } */
        TextReaderInterface tr9 = new TextReader(f);
        
        NormalizationFilter tr6 = new NormalizationFilter(tr9);
        CapitalizationFilter tr5 = new CapitalizationFilter(tr6);
        while(tr5.hasNext()){
            System.out.println(tr5.next());
            System.out.println();
        }
    }
}
