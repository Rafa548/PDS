import java.util.*;


public class  WPSolver{
    static String[] ResolverSopa (char[][] sopa_final, List<String> finallist,int r, int i, char[][] sopa){
        String[] wordsFound = new String[r];
        int cnt2 = 0;

        for (int m = 0; m < finallist.size(); m++) {
            int cnt = 0;
                char firstLetter = finallist.get(m).charAt(0);

                //System.out.println(firstLetter);
                for (int j = 0; j < i; j++) {
                    for (int j2 = 0; j2 < i; j2++) {
                        if (sopa[j][j2]==firstLetter){
                            //System.out.println("Found letter in position: "+j+" "+j2);
                            //check if word is in the same line
                            if (j2+finallist.get(m).length()<=i){
                                //System.out.println("Word is in the same line");
                                String word = "";
                                for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                    word += sopa[j][j2+j3];
                                }
                                //System.out.println(word);
                                if (word.equals(finallist.get(m))){
                                    cnt++;
                                    if (cnt>1){//skip and print error
                                        System.out.printf("Error - Palavra repetida na Sopa de letras -> %s\n", word);
                                        System.exit(0);
                                    }

                                    for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                        sopa_final[j][j2+j3] = word.charAt(j3);
                                    }
                                    
                                    wordsFound[cnt2] = String.format("%-15s %-15s %-15s %-15s \n",word.toLowerCase(),word.length(),j+1+","+(j2+1),"Direita");
                                    cnt2++;
                                }
                            }
                            //check if word is in the same line inverted
                            if (j2-finallist.get(m).length()>=-1){
                                //System.out.println("Word is in the same line inverted");
                                String word = "";
                                for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                    word += sopa[j][j2-j3];
                                }
                                //System.out.println(word);
                                if (word.equals(finallist.get(m))){
                                    cnt++;
                                    if (cnt>1){//skip and print error
                                        System.out.printf("Error - Palavra repetida na Sopa de letras -> %s\n", word);
                                        System.exit(0);
                                    }

                                    for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                        sopa_final[j][j2-j3] = word.charAt(j3);
                                    }

                                    wordsFound[cnt2] = String.format("%-15s %-15s %-15s %-15s \n",word.toLowerCase(),word.length(),j+1+","+(j2+1),"Esquerda");
                                    cnt2++;
                                }
                            }
                            //check if word is in the same column
                            if (j+finallist.get(m).length()<=i){
                                //System.out.println("Word is in the same column");
                                String word = "";
                                for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                    word += sopa[j+j3][j2];
                                }
                                //System.out.println(word);
                                if (word.equals(finallist.get(m))){
                                    cnt++;
                                    if (cnt>1){//skip and print error
                                        System.out.printf("Error - Palavra repetida na Sopa de letras -> %s\n", word);
                                        System.exit(0);
                                    }

                                    for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                        sopa_final[j+j3][j2] = word.charAt(j3);
                                    }

                                    wordsFound[cnt2] = String.format("%-15s %-15s %-15s %-15s \n",word.toLowerCase(),word.length(),j+1+","+(j2+1),"Baixo");
                                    cnt2++;
                                }
                            }
                            //check if word is in the same column inverted
                            if (j-finallist.get(m).length()>=-1){
                                //System.out.println("Word is in the same column inverted");
                                String word = "";
                                for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                    word += sopa[j-j3][j2];
                                }
                                //System.out.println(word);
                                if (word.equals(finallist.get(m))){
                                    cnt++;
                                    if (cnt>1){//skip and print error
                                        System.out.printf("Error - Palavra repetida na Sopa de letras -> %s\n", word);
                                        System.exit(0);
                                    }

                                    for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                        sopa_final[j-j3][j2] = word.charAt(j3);
                                    }

                                    wordsFound[cnt2] = String.format("%-15s %-15s %-15s %-15s \n",word.toLowerCase(),word.length(),j+1+","+(j2+1),"Cima");
                                    cnt2++;
                                }
                            }
                            //check if word is in the same diagonal
                            if (j+finallist.get(m).length()<=i && j2+finallist.get(m).length()<=i){
                                //System.out.println("Word is in the same diagonal");
                                String word = "";
                                for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                    word += sopa[j+j3][j2+j3];
                                }
                                //System.out.println(word);
                                if (word.equals(finallist.get(m))){
                                    cnt++;
                                    if (cnt>1){//skip and print error
                                        System.out.printf("Error - Palavra repetida na Sopa de letras -> %s\n", word);
                                        System.exit(0);
                                    }

                                    for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                        sopa_final[j+j3][j2+j3] = word.charAt(j3);
                                    }

                                    wordsFound[cnt2] = String.format("%-15s %-15s %-15s %-15s \n",word.toLowerCase(),word.length(),j+1+","+(j2+1),"Baixo-Direita");
                                    cnt2++;
                                }
                            }
                            //check if word is in the same diagonal inverted
                            if (j-finallist.get(m).length()>=-1 && j2-finallist.get(m).length()>=-1){
                                //System.out.println("Word is in the same diagonal inverted");
                                String word = "";
                                for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                    word += sopa[j-j3][j2-j3];
                                }
                                //System.out.println(word);
                                if (word.equals(finallist.get(m))){
                                    cnt++;
                                    if (cnt>1){//skip and print error
                                        System.out.printf("Error - Palavra repetida na Sopa de letras -> %s\n", word);
                                        System.exit(0);
                                    }

                                    for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                        sopa_final[j-j3][j2-j3] = word.charAt(j3);
                                    }

                                    wordsFound[cnt2] = String.format("%-15s %-15s %-15s %-15s \n",word.toLowerCase(),word.length(),j+1+","+(j2+1),"Cima-Esquerda");
                                    cnt2++;
                                }
                            }
                            //check if word is in the same diagonal upRight to downLeft
                            if (j+finallist.get(m).length()<=i && j2-finallist.get(m).length()>=-1){
                                //System.out.println("Word is in the same diagonal upRight to downLeft");
                                String word = "";
                                for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                    word += sopa[j+j3][j2-j3];
                                }
                                //System.out.println(word);
                                if (word.equals(finallist.get(m))){
                                    cnt++;
                                    if (cnt>1){//skip and print error
                                        System.out.printf("Error - Palavra repetida na Sopa de letras -> %s\n", word);
                                        System.exit(0);
                                    }

                                    for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                        sopa_final[j+j3][j2-j3] = word.charAt(j3);
                                    }

                                    wordsFound[cnt2] = String.format("%-15s %-15s %-15s %-15s \n",word.toLowerCase(),word.length(),j+1+","+(j2+1),"Baixo-Esquerda");
                                    cnt2++;
                                }
                            }
                            //check if word is in the same diagonal upRight to downLeft inverted
                            if (j-finallist.get(m).length()>=-1 && j2+finallist.get(m).length()<=i){
                                //System.out.println("Word is in the same diagonal upRight to downLeft inverted");
                                String word = "";
                                for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                    word += sopa[j-j3][j2+j3];
                                }
                                //System.out.println(word);
                                if (word.equals(finallist.get(m))){
                                    cnt++;
                                    if (cnt>1){//skip and print error
                                        System.out.printf("Error - Palavra repetida na Sopa de letras -> %s\n", word);
                                        System.exit(0);
                                    }

                                    for (int j3 = 0; j3 < finallist.get(m).length(); j3++) {
                                        sopa_final[j-j3][j2+j3] = word.charAt(j3);
                                    }

                                    wordsFound[cnt2] = String.format("%-15s %-15s %-15s %-15s \n",word.toLowerCase(),word.length(),j+1+","+(j2+1),"Cima-Direita");
                                    cnt2++;
                                }
                            }
                        }
                    }
                }
            //}
        }
        return wordsFound;
    }
    
}
