import java.io.*;
import java.util.*;

public class WSSolver {

  public static void main(String[] args) throws FileNotFoundException {

    Scanner fileName = new Scanner(new File(args[0]));

    // ------------------ GUARDAR AS INFORMAÇÕES NOS ARRAYS ---------------------

    // lineSize --> tamanho do array puzzle
    // numwords --> tamanho do array words
    String firstLine = fileName.nextLine();
    int lineSize = firstLine.length();

    // Check if the puzzle size isn't bigger than 40x40
    if (lineSize > 40) {
      System.out.println("The puzzle must have a maximum size of 40x40.");
      System.exit(0);
    }

    char[][] puzzle = new char[lineSize + 1][lineSize + 1];
    int numLines = 0;
    puzzle[0] = firstLine.toCharArray();

    ArrayList<String> wordsArrayList = new ArrayList<String>();

    while (fileName.hasNextLine()) {
      numLines++;
      String linha = fileName.nextLine();

      linha = linha.strip();

      if (linha.length() == lineSize) {
        if (linha.matches("[a-zA-Z]+")) {
          char[] linhaArray = linha.toCharArray();
          for (int i = 0; i < lineSize; i++) {
            char ch = linhaArray[i];
            puzzle[numLines][i] = ch;

          }
        }
      } else {
        if (linha.matches("[a-zA-Z]+")) {
          System.out.println("The puzzle is not square."); // Check if puzzle is square
          System.exit(0);
        } else {
          String[] arrOfWords = linha.split("[\\s,;]+");

          for (String a : arrOfWords) {
            wordsArrayList.add(a);

          }

        }
      }

    }

    int numWords = wordsArrayList.size();
    char[][] words = new char[numWords][lineSize];
    for (int k = 0; k < numWords; k++) {
      String oneWord = wordsArrayList.get(k);
      char[] wordCharArray = oneWord.toCharArray();
      int oneWordSize = oneWord.length();

      if (oneWordSize < 3) {
        System.out.println("The words must have at least 3 characters."); // Check if no word has less than 3 letters
        System.exit(0);
      }

      for (int ii = 0; ii < oneWordSize; ii++) {
        char ch1 = wordCharArray[ii];
        words[k][ii] = ch1;
      }

    }


    Solver crosswords = new Solver(puzzle, words);
    crosswords.printArrays();
    crosswords.solve();



    /// PRINTING RESULT

    for (int jj=0; jj<numWords; jj++){
      //print word, length of word, position in puzzle and direction
      
      System.out.printf("%-15s %-4d %-6s %s\n", wordsArrayList.get(jj).toString().toLowerCase(), wordsArrayList.get(jj).length());

    }
    

  }
}
