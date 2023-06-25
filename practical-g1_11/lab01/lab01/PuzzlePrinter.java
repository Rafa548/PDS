package lab01.lab01;

public class PuzzlePrinter {
    static void printWordsFound(String[] wordsFound){
        System.out.printf("\n%-15s %-15s %-15s %-15s\n","Palavra","Tamanho","Posição","Direção");
        for (int ind = 0; ind < wordsFound.length; ind++) {
            if (wordsFound[ind] != null)
            System.out.print(wordsFound[ind]);
        }

    }

    static void printSopaInicial(char[][] sopa){
        System.out.println("Sopa de letras inicial: \n");

        for (int j = 0; j < sopa.length; j++) {
            for (int j2 = 0; j2 < sopa.length; j2++) {
                System.out.printf("%2s",sopa[j][j2]);
            }
            System.out.println();
        }
    }

    static void printSopaResolvida(char[][] sopa){
        System.out.println();
        System.out.println("Sopa de letras Resolvida: \n");

        for (int j = 0; j < sopa.length; j++) {
            for (int j2 = 0; j2 < sopa.length; j2++) {
                System.out.printf("%2s",sopa[j][j2]);
            }
            System.out.println();
        }
    }
}
