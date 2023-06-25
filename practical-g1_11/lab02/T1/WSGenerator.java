import java.io.*;
import java.util.*;
public class WSGenerator {
    public Random rand = new Random();

    public static void main(String[] args) throws IOException {
        int outputControl = 0; //to check if an output file is passed

        String inputFile = args[Arrays.asList(args).indexOf("-i")+1]; // file with the words
        Scanner wordsFile = new Scanner(new File(inputFile));

        int puzzleSize = Integer.parseInt(args[Arrays.asList(args).indexOf("-s")+1]); // size of the word search puzzle

        if (args.length > 4) {
            outputControl = 1; 
            File f = new File(args[Arrays.asList(args).indexOf("-o")+1]);
            f.createNewFile();
            FileWriter outputFile = new FileWriter(f); // open file writer
        }



        ArrayList<String> wordsArrayList = new ArrayList<String>();

        while (wordsFile.hasNextLine()) {
            String linha = wordsFile.nextLine();
            linha = linha.strip();
            String[] arrOfWords = linha.split("[\\s,;]+");

            for (String a : arrOfWords) {
                wordsArrayList.add(a);
            }

        
        }

        // Check if a word has less than 3 letters.
        int numWords = wordsArrayList.size();
        for (int i=0; i<numWords; i++){
            String oneWord = wordsArrayList.get(i);
            if (oneWord.length() < 3){
                System.out.println("Words must have at least 3 characters.");
                System.exit(0);
            }
        }
    }
}
