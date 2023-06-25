import java.util.*;
import java.io.*;

public class WSGenerator {
    public static void main(String[] args) throws IOException {
        //input scanner
        String ficheiro = null;
        int dimensao = 0;

        //get arguments
        if ( args.length != 4 ) {
            System.out.println("Error - Numero de argumentos invalido");
            System.exit(0);
        }
        if (args[0].equals("-i") && args[2].equals("-s")) {
            dimensao = Integer.parseInt(args[3]);
            ficheiro = args[1];
        } else {
            System.out.println("Error - Argumentos invalidos");
            System.exit(0);
        }

        String ficheiro_output = ficheiro.substring(0, ficheiro.length()-4) + "_result.txt";


        //criar matriz
        char[][] matriz = new char[dimensao][dimensao];
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                matriz[i][j] = (char) (Math.random() * 26 + 'A');
            }
        }

        
        char[][] matriz1 = new char[dimensao][dimensao];
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                matriz1[i][j] = (char) '.';
            }
        }

        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }


        File file = new File(ficheiro);
        Scanner input1 = new Scanner(file);

        List<String> solucoes = new ArrayList<>();

        while (input1.hasNext()) {
            String line = input1.nextLine();

            if (line.isEmpty()) {
                System.out.println("Error - Scanner vazio");
                System.exit(0);
            }

            if (line.contains(";") || line.contains(" ") || line.contains(",")) {
                String[] parts = line.split("[; ,]+");
                for (int j = 0; j < parts.length; j++) {
                    if (parts[j].length() > 2){
                        
                        if (parts[j].equals(parts[j].toUpperCase())){
                            System.out.println("Error - Palavras soluçao do puzzle devem estar em minusculas ou misturadas");
                            System.exit(0);
                        }
                        
                        if (!parts[j].matches("[a-zA-Z]+")){
                            System.out.println("Error - Palavras soluçao do puzzle devem ter apenas letras");
                            System.exit(0);
                        }
                        solucoes.add(parts[j]);
                    }
                }

            }
            //System.out.println(line);
        }
        input1.close();

        //solucoes t upper
        for (int j = 0; j < solucoes.size(); j++) {
            if (solucoes.get(j) != null) {
                solucoes.set(j, solucoes.get(j).toUpperCase());
            }
        }


        //print solucoes
        /* System.out.println("Solucoes:");
        for (int j = 0; j < solucoes.length; j++) {
            if (solucoes.get(j) != null) {
                System.out.println(solucoes.get(j));
            }
        } */

        for (int j = 0; j < solucoes.size(); j++) {
            if (solucoes.get(j) != null) {
                int x = (int) (Math.random() * dimensao);
                int y = (int) (Math.random() * dimensao);
                int direcao = (int) (Math.random() * 8);
                int k = 0;
                int t = solucoes.get(j).length();
                boolean s = true;
                
                    if (direcao == 0) {
                        
                        while (k < solucoes.get(j).length()) {
                            
                            if (x + t < dimensao && s == true) {
                                if (matriz1[x+k][y]!='.' && matriz1[x+k][y]!=solucoes.get(j).charAt(k)){
                                    x = (int) (Math.random() * dimensao);
                                    y = (int) (Math.random() * dimensao);
                                    k = 0;
                                    continue;
                                }
                                
                            } else {
                                x = (int) (Math.random() * dimensao);
                                y = (int) (Math.random() * dimensao);
                                k = -1;
                                s = true;
                            }
                            
                            k++;
                        }
                        k=0;
                        while (k < solucoes.get(j).length()) {
                            matriz1[x + k][y] = solucoes.get(j).charAt(k);
                            matriz[x + k][y] = solucoes.get(j).charAt(k);
                            k++;
                        }
                    } else if (direcao == 1) {
                        
                        while (k < solucoes.get(j).length()) {
                            if (x - t >= 0 && s == true) {
                                if (matriz1[x-k][y]!='.' && matriz1[x-k][y]!=solucoes.get(j).charAt(k)){
                                    x = (int) (Math.random() * dimensao);
                                    y = (int) (Math.random() * dimensao);
                                    k = 0;
                                    continue;
                                }
                            
                            } else {
                                x = (int) (Math.random() * dimensao);
                                y = (int) (Math.random() * dimensao);
                                k = -1;
                                s = true;
                            }
                           
                            k++;
                        }
                        k=0;
                        while (k < solucoes.get(j).length()) {
                            matriz1[x - k][y] = solucoes.get(j).charAt(k);
                            matriz[x - k][y] = solucoes.get(j).charAt(k);
                            k++;
                        }
                    } else if (direcao == 2) {
                        
                        while (k < solucoes.get(j).length()) {
                            if (y + t < dimensao && s == true) {
                                if (matriz1[x][y+k]!='.' && matriz1[x][y+k]!=solucoes.get(j).charAt(k)){
                                    x = (int) (Math.random() * dimensao);
                                    y = (int) (Math.random() * dimensao);
                                    k = 0;
                                    continue;
                                }
                                
                            } else {
                                x = (int) (Math.random() * dimensao);
                                y = (int) (Math.random() * dimensao);
                                k = -1;
                                s = true;
                            }
                           
                            k++;
                        }
                        k=0;
                        while (k < solucoes.get(j).length()) {
                            matriz1[x][y + k] = solucoes.get(j).charAt(k);
                            matriz[x][y + k] = solucoes.get(j).charAt(k);
                            k++;
                        }
                    } else if (direcao == 3) {
                        
                        while (k < solucoes.get(j).length()) {
                            if (y - t >= 0 && s == true) {
                                if (matriz1[x][y-k]!='.' && matriz1[x][y-k]!=solucoes.get(j).charAt(k)){
                                    x = (int) (Math.random() * dimensao);
                                    y = (int) (Math.random() * dimensao);
                                    k = 0;
                                    continue;
                                }
                                
                            } else if (k<=t){
                                x = (int) (Math.random() * dimensao);
                                y = (int) (Math.random() * dimensao);
                                k = -1;
                                s = true;
                            }
                            
                            k++;
                        }
                        k=0;
                        while (k < solucoes.get(j).length()) {
                            matriz1[x][y - k] = solucoes.get(j).charAt(k);
                            matriz[x][y - k] = solucoes.get(j).charAt(k);
                            k++;
                        }
                    }
                    else if (direcao == 4) {
                        while (k < solucoes.get(j).length()) {
                            if (x + t < dimensao && y + t < dimensao && s == true) {
                                if (matriz1[x+k][y+k]!='.' && matriz1[x+k][y+k]!=solucoes.get(j).charAt(k)){
                                    x = (int) (Math.random() * dimensao);
                                    y = (int) (Math.random() * dimensao);
                                    k = 0;
                                    continue;
                                }
                                
                            } else if (k<=t){
                                x = (int) (Math.random() * dimensao);
                                y = (int) (Math.random() * dimensao);
                                k = -1;
                                s = true;
                            }
                            
                            k++;
                        }
                        k=0;
                        while (k < solucoes.get(j).length()) {
                            matriz1[x + k][y + k] = solucoes.get(j).charAt(k);
                            matriz[x + k][y + k] = solucoes.get(j).charAt(k);
                            k++;
                        }
                    }
                    else if (direcao == 5) {
                        while (k < solucoes.get(j).length()) {
                            if (x - t >= 0 && y - t >= 0 && s == true) {
                                if (matriz1[x-k][y-k]!='.' && matriz1[x-k][y-k]!=solucoes.get(j).charAt(k)){
                                    x = (int) (Math.random() * dimensao);
                                    y = (int) (Math.random() * dimensao);
                                    k = 0;
                                    continue;
                                }
                                
                            } else if(k<=t){
                                x = (int) (Math.random() * dimensao);
                                y = (int) (Math.random() * dimensao);
                                k = -1;
                                s = true;
                            }
                            
                            k++;
                        }
                        k=0;
                        while (k < solucoes.get(j).length()) {
                            matriz1[x - k][y - k] = solucoes.get(j).charAt(k);
                            matriz[x - k][y - k] = solucoes.get(j).charAt(k);
                            k++;
                        }
                    }
                    else if (direcao == 6) {
                        while (k < solucoes.get(j).length()) {
                            if (x + t < dimensao && y - t >= 0 && s == true) {
                                if (matriz1[x+k][y-k]!='.' && matriz1[x+k][y-k]!=solucoes.get(j).charAt(k)){
                                    x = (int) (Math.random() * dimensao);
                                    y = (int) (Math.random() * dimensao);
                                    k = 0;
                                    continue;
                                }
                                
                            } else if (k<=t){
                                x = (int) (Math.random() * dimensao);
                                y = (int) (Math.random() * dimensao);
                                k = -1;
                                s = true;
                            }
                            
                            k++;
                        }
                        k=0;
                        while (k < solucoes.get(j).length()) {
                            matriz1[x + k][y - k] = solucoes.get(j).charAt(k);
                            matriz[x + k][y - k] = solucoes.get(j).charAt(k);
                            k++;
                        }
                    }
                    else if (direcao == 7) {
                        while (k < solucoes.get(j).length()) {
                            if (x - t >= 0 && y + t < dimensao && s == true) {
                                if (matriz1[x-k][y+k]!='.' && matriz1[x-k][y+k]!=solucoes.get(j).charAt(k)){
                                    x = (int) (Math.random() * dimensao);
                                    y = (int) (Math.random() * dimensao);
                                    k = 0;
                                    continue;
                                }
                                
                            } else if (k<=t){
                                x = (int) (Math.random() * dimensao);
                                y = (int) (Math.random() * dimensao);
                                k = -1;
                                s = true;
                            }
                            
                            k++;
                        }
                        k=0;
                        while (k < solucoes.get(j).length()) {
                            matriz1[x - k][y + k] = solucoes.get(j).charAt(k);
                            matriz[x - k][y + k] = solucoes.get(j).charAt(k);
                            k++;
                        }
                    }
                }
            }
        

        
        WPOutput.WriteProblemaInicial(matriz, solucoes, ficheiro_output);
    }
}
