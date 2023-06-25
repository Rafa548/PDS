package lab01;
import java.io.*;
import java.util.*;

public class WSGenerator {
    private static ArrayList<String> keys = new ArrayList<>();
    private static ArrayList<Integer> usedIndexX = new ArrayList<>();
    private static ArrayList<Integer> usedIndexY = new ArrayList<>();
    private static int nColumms;
    private static Character[][] board;
    private static Boolean printSolution = true;
    public static void main(String[] args) {
        Scanner sc;
        try {
            validation(args);

            File file = new File(args[1]);

            sc = new Scanner(file);

            fillArray(sc);
        }
        catch (FileNotFoundException e) {
            System.err.print("Erro na leitura do ficheiro!\n");
            System.exit(1);
        }

        nColumms = Integer.parseInt(args[3]);

        valWords(keys);
        
        board = new Character[nColumms][nColumms];

        generateBoard(board);

        printOrWriteSolution(board, keys, args);
    }

    private static void valWords(ArrayList<String> keys) {
        for (String word : keys){
            if(!word.matches("[a-zA-Z]+")){
                System.err.print("ERRO: Palavra com caracteres não alfabéticos detetada!\n");
                System.exit(1);}
            else if(word.length() < 3){
                System.err.print("ERRO: Palavra com menos de 3 caracteres detetada!\n");
                System.exit(1);
            }
            else if(word.length() > nColumms){
                System.err.print("ERRO: Palavra com mais caracteres que o tabuleiro detetada!\n");
                System.exit(1);
            }
        }


        for (int i = 0; i < keys.size(); i++){
            for (int j = 0; j < keys.size(); j++){
                if(keys.get(i).contains(keys.get(j)) && i != j){
                    keys.remove(j);
                }
            }
        }
    }

    private static void fillArray(Scanner sc){
        while(sc.hasNextLine()){
            String[] words = sc.nextLine().split("[\\s,;]+");
            keys.addAll(keys.size(), Arrays.asList(words));
        }
    }

    private static void validation(String[] args) {

        if (args.length != 6 && args.length != 4) {
            System.out.println("ERRO: Número de argumentos inválido!");
        }

        if (args.length == 6) {
            if (!args[4].equals("-o") && !args[5].endsWith(".txt")) {
                System.out.println("ERRO: Argumento inválido!");
            }
            printSolution = false;
        }

        if (!args[0].equals("-i") && !args[2].equals("-s")) {
            System.out.println("ERRO: Argumento inválido!");
        }

        if (!args[1].endsWith(".txt")) {
            System.out.println("ERRO: Ficheiro texto não especificado!");
        }

        try {
            Integer.parseInt(args[3]);
        } catch (NumberFormatException e) {
            System.out.println("ERRO: Número de palavras inválido!");
        }

        if (args[0] == null || args[0].trim().isEmpty() || args[1] == null || args[1].trim().isEmpty() || args[2] == null || args[2].trim().isEmpty()) {
            System.out.println("ERRO: Ficheiro texto não especificado!");
        }
    }

    private static void generateBoard(Character[][] board) {
        Random r = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = alphabet.charAt(r.nextInt(26));
            }
        }

        for (String word : keys) {
            reset:
            while(true){
                int i = (int) (Math.random() * board.length);
                int j = (int) (Math.random() * board.length);
                
                Word w = new Word(word, i, j);

                int[][] orientation = w.getDirection().getVector();

                int finalI = i+ orientation[0][0]*(word.length()-1);
                int finalJ = j+ orientation[0][1]*(word.length()-1);

                if(finalI < 0 || finalI > board.length-1 || finalJ < 0 || finalJ > board.length-1){
                    continue reset;
                }

                for(int k = 0; k < word.length(); k++){
                    for(int l = 0; l < usedIndexX.size(); l++){
                        if(usedIndexX.get(l) == i+ orientation[0][0]*k && usedIndexY.get(l) == j+ orientation[0][1]*k){
                            continue reset;
                        }
                    }
                }

                for(int k = 0; k < word.length(); k++){
                    board[i+ orientation[0][0]*k][j+ orientation[0][1]*k] = word.toUpperCase().charAt(k);
                    usedIndexX.add(i+ orientation[0][0]*k);
                    usedIndexY.add(j+ orientation[0][1]*k);
                }

                break;
            }
        }
    }

    private static void printOrWriteSolution(Character[][] board, ArrayList<String> keys, String[] args) {
        if (printSolution) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            for(String word : keys){
                System.out.print(word + ";");
            }
            System.out.print("\n");
        }
        else{
            try {
                FileWriter f_writer = new FileWriter(args[5]);
    
                for(int i = 0; i < nColumms; i++){
                    for(int j = 0; j < nColumms; j++){
                        f_writer.write(board[i][j] + " ");
                    }
                    f_writer.write("\n");
                }
    
                for(String word : keys){
                    f_writer.write(word + ";");
                }
    
                f_writer.close();
            }
            catch (IOException e) {
                System.err.print("Erro na escrita do ficheiro!\n");
                System.exit(1);
            }
        }
    }
}