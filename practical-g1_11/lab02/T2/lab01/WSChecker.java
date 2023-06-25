package lab01;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WSChecker {
    private static int Max_Size = 40;
    private static int nLines;
    private static int nColumms;
    private static Character[][] board;
    private static ArrayList<String> keys = new ArrayList<>();

    public WSChecker(File file){
        readBoard(file);
    }

    public static void readBoard(File file){

        Scanner sc;
        try {
            sc = new Scanner(file);

            String firstLine = sc.nextLine();

            if(firstLine.trim().isEmpty()){
                System.err.print("ERRO: Linha vazia detetada!\n");
                System.exit(1);
            }

            String[] firstL = firstLine.split("");

            nColumms = firstL.length;
            nLines = 1;
            Boolean finishedR = false;

            if(nColumms > Max_Size || nColumms < 1){
                System.err.print("ERRO: Tamanho do tabuleiro ultrapassa o limite permitido!\n");
                System.exit(1);
            }

            for (String s : firstL){
                if(!Character.isUpperCase(s.charAt(0))){
                    System.err.print("ERRO: Letra minuscula detetada na sopa!\n");
                    System.exit(1);
                }
            }

            while (sc.hasNextLine()){
                String line = sc.nextLine();

                if(line.trim().isEmpty()){
                    System.err.print("ERRO: Linha vazia detetada!\n");
                    System.exit(1);
                }

                String[] l = line.split("");

                for (String s : l){
                    if(!Character.isUpperCase(s.charAt(0))){
                        finishedR = true;
                    }
                }

                if(finishedR){
                    fillArray(line, sc);
                    break;
                }
                else{
                    nLines++;
                }
                
                if(nColumms > Max_Size || nColumms < 1 || l.length != nColumms){
                    System.err.print("ERRO: Dimensão do tabuleiro inválida!\n");
                    System.exit(1);
                }
            }

            if(nLines != nColumms){
                System.err.print("ERRO: O tabuleiro não é um quadrado ou foi detetada uma letra minuscula no mesmo!\n");
                System.exit(1);
            } else{
                System.out.print("Ficheiro lido com sucesso!\n");
            }

            sortWords(keys);

            sc.close();
        } catch (FileNotFoundException e) {
            System.err.print("Erro na leitura do ficheiro!\n");
            e.printStackTrace();
            System.exit(1);
        }
    }

    private static void sortWords(ArrayList<String> keys) {
        for (String word : keys){
            if(!word.matches("[a-zA-Z]+")){
                System.err.print("ERRO: Palavra com caracteres não alfabéticos detetada (inclusive linha vazia)!\n");
                System.exit(1);
            } else if(word.length() < 3){
                System.err.print("ERRO: Palavra com menos de 3 caracteres detetada!\n");
                System.exit(1);
            }
            else if(word.length() > nColumms){
                System.err.print("ERRO: Palavra com mais caracteres que o tabuleiro detetada!\n");
                System.exit(1);
            }//As palavras são compostas por caracteres alfabéticos.
        }


        for (int i = 0; i < keys.size(); i++){
            for (int j = 0; j < keys.size(); j++){
                if(keys.get(i).contains(keys.get(j)) && i != j){
                    keys.remove(j);
                }
            }
        }
    }

    private static void fillArray(String line, Scanner sc) {

        String[] words = line.split("[\\s,;]+");
        keys.addAll(keys.size(), Arrays.asList(words));

        while(sc.hasNextLine()){
            line = sc.nextLine();
            String[] words1 = line.split("[\\s,;]+");
            keys.addAll(keys.size(), Arrays.asList(words1));
        }
    }

        

    public static ArrayList<String> getKeys() {
        return keys;
    }
    

    public static int getnLines() {
        return nLines;
    }

    public static int getnColumms() {
        return nColumms;
    }

    public static Character[][] getBoard() {
        return board;
    }

    public static Character[][] getBoard(File file){

        try {
            Scanner sc = new Scanner(file);

            board = new Character[nLines][nColumms];

            for(int i = 0; i < nLines; i++){
                String[] line = sc.nextLine().split("");
                
                for(int j = 0; j < nColumms; j++){
                    board[i][j] = line[j].charAt(0);
                }
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.err.print("Erro na leitura do ficheiro!\n");
            e.printStackTrace();
            System.exit(1);
        }

        return board;
    }
    
}
