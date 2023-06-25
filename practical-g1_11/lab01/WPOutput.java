import java.io.*;
import java.util.*;

public class WPOutput {

    public static void printAll (char[][] sopa, char[][] sopa_final, String[] wordsFound){
        printSopaInicial(sopa);
        printSopaResolvida(sopa_final);
        printWordsFound(wordsFound);
    }

    public static void writeALL(char[][] sopa, char[][] sopa_final, String[] wordsFound, String name){
        try {
            FileWriter myWriter = new FileWriter(name);

            WriteSopaInicial(sopa,myWriter);
            WriteSopaResolvida(sopa_final,myWriter );
            WriteWordsFound(wordsFound,myWriter);
            myWriter.close();
        }
        catch (IOException e) {
            System.out.println("Erro");
            e.printStackTrace();
        }
    }

    public static void WriteProblemaInicial(char[][] matriz, List<String> solucoes,String ficheiro_output) throws IOException{
        //File file1 = new File("lab01/" + ficheiro_output);
        File output = new File(ficheiro_output);
        try{
            FileWriter myWriter = new FileWriter(output);
        
            for (int j = 0; j < matriz.length; j++) {
                for (int j2 = 0; j2 < matriz.length; j2++) {
                    myWriter.write(String.format("%1s",matriz[j][j2]));
                }
                myWriter.write("\n");
            }
            for (int j = 0; j < solucoes.size(); j++) {
                if (solucoes.get(j) != null) {
                    myWriter.write(solucoes.get(j).toLowerCase() + ",");
                }
            }  
            myWriter.write("\n");
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("Erro");
            e.printStackTrace();
        }
    }

    private static void printWordsFound(String[] wordsFound){
        System.out.printf("\n%-15s %-15s %-15s %-15s\n","Palavra","Tamanho","Posição","Direção");
        for (int ind = 0; ind < wordsFound.length; ind++) {
            if (wordsFound[ind] != null)
            System.out.print(wordsFound[ind]);
        }

    }

    private static void printSopaInicial(char[][] sopa){
        System.out.println("Sopa de letras inicial: \n");

        for (int j = 0; j < sopa.length; j++) {
            for (int j2 = 0; j2 < sopa.length; j2++) {
                System.out.printf("%2s",sopa[j][j2]);
            }
            System.out.println();
        }
    }

    private static void printSopaResolvida(char[][] sopa){
        System.out.println();
        System.out.println("Sopa de letras Resolvida: \n");

        for (int j = 0; j < sopa.length; j++) {
            for (int j2 = 0; j2 < sopa.length; j2++) {
                System.out.printf("%2s",sopa[j][j2]);
            }
            System.out.println();
        }
    }

    private static void WriteWordsFound(String[] wordsFound, FileWriter myWriter) throws IOException{
            myWriter.write(String.format("%-15s %-15s %-15s %-15s\n","Palavra","Tamanho","Posição","Direção"));
            for (int ind = 0; ind < wordsFound.length; ind++) {
                if (wordsFound[ind] != null)
                myWriter.write(wordsFound[ind]);
            }
    }   

    private static void WriteSopaInicial(char[][] sopa ,FileWriter myWriter) throws IOException{
           myWriter.write("Sopa de letras inicial: \n \n");
           for (int j = 0; j < sopa.length; j++) {
            for (int j2 = 0; j2 < sopa.length; j2++) {
                   myWriter.write(String.format("%2s",sopa[j][j2]));
               }
               myWriter.write("\n");
               }
            myWriter.write("\n");
    }

    private static void WriteSopaResolvida(char[][] sopa_final,FileWriter myWriter) throws IOException{
           myWriter.write("Sopa de letras Resolvida: \n \n");
          for (int j = 0; j < sopa_final.length; j++) {
               for (int j2 = 0; j2 < sopa_final.length; j2++) {
                   myWriter.write(String.format("%2s",sopa_final[j][j2]));
               }
               myWriter.write("\n");
           }
           myWriter.write("\n");

    }
}
