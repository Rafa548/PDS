package lab01;

import lab01.Directions;
import lab01.Word;
import lab01.WSChecker;
import java.io.*;
import java.util.*;

public class WSSolver {
    static ArrayList<Word> wordsFound = new ArrayList<>();
    static ArrayList<String> repeatedWords = new ArrayList<>();
    static int[] x = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] y = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[][] v = new int[8][8];
 

    public static void main(String[] args) {
        if (args[0] == null || args[0].trim().isEmpty()) {
            System.out.println("ERRO: Ficheiro texto nÃ£o especificado!");
        }
        File txtfile = new File(args[0]);
        WSChecker ws = new WSChecker(txtfile);

        Character[][] board = ws.getBoard(txtfile);
        ArrayList<String> words = ws.getKeys();
        Character[][] solution = new Character[ws.getnLines()][ws.getnColumms()];

        nextWord:
        for (String word : words) {
            for (int i = 0; i < ws.getnLines(); i++) {
                for (int j = 0; j < ws.getnColumms(); j++) {
                    if(board[i][j] == Character.toUpperCase(word.charAt(0))){
                        for(int k = 0; k < v.length; k++){
                            if(i+ x[k] >= 0 && i+ x[k] < ws.getnLines() && j+ y[k] >= 0 && j+ y[k] < ws.getnColumms()){
                                    Word w = new Word(word, i, j, Directions.values()[k]);
                                    int control = 1;
                                    while(control > 0 && control < word.length() && i+ x[k]*control >= 0 && i+ x[k]*control < ws.getnLines() && j+ y[k]*control >= 0 && j+ y[k]*control < ws.getnColumms()){
                                        if(Character.compare(board[i+ x[k]*control][j+ y[k]*control], Character.toUpperCase(word.charAt(control))) != 0){
                                            break;
                                        }
                                        else{
                                        control++;
                                    }
                                    if (control == word.length()){
                                        repWordsCheck(w);
                                        continue nextWord;
                                    }
                                    
                                }
                            }
                        }
                    }
                }
            }
        }

        printBoard(solution, args);
    }

    private static void repWordsCheck(Word w){
        Boolean repeated = false;

        for (String ww: repeatedWords){
            if(ww.equals(w.getWord())){
                repeated = true;
            }
        }
        if(!repeated){
            repeatedWords.add(w.getWord());
            wordsFound.add(w);
        }
    }

    private static void printBoard(Character[][] solution, String[] args){
        try {
            String fileName = args[0].substring(0, args[0].length() - 4);
            String fileType = args[0].substring(Math.max(args[0].length() - 4, 0));
            FileWriter f_writer = new FileWriter(fileName + "_result" + fileType);
            System.out.println("\n");
            System.out.println("Palavras encontradas: \n");
            f_writer.write("Palavras encontradas: \n");
            f_writer.write("\n");

            for (Word w : wordsFound) {
                System.out.print(w.toString());
                f_writer.write(w.toString());
            }

            for (int i = 0; i < solution.length; i++) {
                for (int j = 0; j < solution.length; j++) {
                    solution[i][j] = ".".charAt(0);
                }
            }

            for (Word w: wordsFound){
                int xWord = w.getX();
                int yWord = w.getY();
                for(int i = 0; i < w.getWord().length(); i++){
                    solution[xWord][yWord] = w.getWord().toUpperCase().charAt(i);
                    int[][] orientation = w.getDirection().getVector();
                    xWord += orientation[0][0];
                    yWord += orientation[0][1];
                }
            }

            System.out.println("\n");
            System.out.println("Solução: \n");
            f_writer.write("\n");
            f_writer.write("Solução: \n");
            f_writer.write("\n");
            for (int i = 0; i < solution.length; i++) {
                for (int j = 0; j < solution.length; j++) {
                    if(j == solution.length-1){
                        System.out.println(solution[i][j] + "\n");
                        f_writer.write(solution[i][j] + "\n");
                    }
                    else{
                        System.out.print(solution[i][j] + " ");
                        f_writer.write(solution[i][j] + " ");
                    }
                }
            }
            f_writer.close();
        }
        catch (IOException e) {
            System.err.println("Erro a escrever no ficheiro!");
            e.printStackTrace();
        }
    }
}