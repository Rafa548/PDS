import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class lab1 {
    public static void main(String[] args) throws FileNotFoundException {
        int n_linhas_sopa = 0, n_colunas_sopa=0, n_palavras = 0;
        String fileName = args[0];
        System.out.println(); 
        File file = new File(fileName);
        Scanner input = new Scanner(file);
        
        List<String> solucoes = new ArrayList<String>();
        List<String> substrings = new ArrayList<String>();
        List<String> final_list = new ArrayList<String>();

        while (input.hasNext()) {
            String line = input.nextLine();

            if (line.isEmpty()) {
                System.out.println("Erro - Scanner vazio");
                System.exit(0);
            }

            n_linhas_sopa++;
            if (line.contains(";") || line.contains(" ") || line.contains(",")) {
                String[] parts = line.split("[; ,]+");
                for (int j = 0; j < parts.length; j++) {
                    if (parts[j].length() > 2){
                        
                        if (parts[j].equals(parts[j].toUpperCase())){
                            System.out.println("Erro - Palavras soluçao do puzzle devem estar em minusculas ou misturadas");
                            System.exit(0);
                        }
                        
                        if (!parts[j].matches("[a-zA-Z]+")){
                            System.out.println("Erro - Palavras soluçao do puzzle devem ter apenas letras");
                            System.exit(0);
                        }
                        solucoes.add(n_palavras, parts[j]);
                        
                        n_palavras++;
                    }
                }

                n_linhas_sopa--;
            }
        }
        input.close();

        //verifica se existem palavras parecidas
        int n_palavras_iguais = 0;

        for (int j = 0; j < n_palavras; j++) {
            for (int j2 = 0; j2 < n_palavras; j2++) {
                if (j!=j2){
                    if (solucoes.get(j).contains(solucoes.get(j2))){
                        substrings.add(n_palavras_iguais, solucoes.get(j2));
                        n_palavras_iguais++;
                    }
                }
            }
        }

        //remove das palavras parecidas a com menos caracteres
        int indice = 0;

        for (int j = 0; j < n_palavras; j++) {
            int fn_n = 0;
            for (int j2 = 0; j2 < n_palavras_iguais; j2++) {
                if (solucoes.get(j).equals(substrings.get(j2))){
                    fn_n++;
                }
            }
            if (fn_n==0){
                final_list.add(indice, solucoes.get(j).toUpperCase());
                indice++;
            }
        }
        
        //verifica se o numero de linhas é maior que 40
        if(n_linhas_sopa>40){
            System.out.println("Erro - Tamanho maximo da matrix é 40x40");
            System.exit(0);
        }

        //verificaçao da sopa de letras e criaçao da matriz sopa
        char[][] sopa = new char[n_linhas_sopa][n_linhas_sopa];
        int linha_atual = 0;

        Scanner input_2 = new Scanner(file);

        while (input_2.hasNext()) { 
            String line = input_2.nextLine();
            if (line.contains(";") || line.contains(" ") || line.contains(",")) {
                continue;
            }
            
            for (int j = 0; j < n_linhas_sopa; j++) {
                sopa[linha_atual][j] = line.charAt(j);
                if (sopa[linha_atual][j] < 65 || sopa[linha_atual][j] > 90){
                    System.out.println("Erro - Letras do puzzle devem ser maiusculas");
                    System.exit(0);
                }
            }
            linha_atual++;

            n_colunas_sopa=line.length();
            
            if(n_colunas_sopa!=n_linhas_sopa){
                System.out.println("Erro - Matriz nao é quadrada");
            }
        }

        input_2.close();

        //usado para verificar a correta funcionalidade
        /* System.out.println("As palavras soluçao do puzzle são: "); 
        for (int j = 0; j < n_palavras; j++) {
            if (final_list[j]!=null){
                System.out.println(final_list[j]);
            }
        } */

        //cria a sopa de letras final com todas as letras como ponto
        char[][] sopa_final = new char[n_linhas_sopa][n_linhas_sopa];

        for (int j = 0; j < n_linhas_sopa; j++) {
            for (int j2 = 0; j2 < n_linhas_sopa; j2++) {
                sopa_final[j][j2] = '.';
            }
        }
        
        //resoluçao da sopa de letras
        String[] wordsFound = new String[n_palavras];
        wordsFound = WPSolver.ResolverSopa(sopa_final, final_list, n_palavras, n_linhas_sopa, sopa);
        String final_file = fileName.substring(0, fileName.length()-11) + "_solved.txt";

        //escrita no ficheiro desejado e no terminal
        WPOutput.printAll(sopa, sopa_final, wordsFound);
        WPOutput.writeALL(sopa, sopa_final, wordsFound, final_file);

    }
}


