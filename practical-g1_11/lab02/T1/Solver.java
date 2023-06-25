public class Solver {

    char[][] puzzle;
    char[][] words;
    // lineSize --> tamanho do array puzzle
    // numwords --> tamanho do array words
    int lineSize;
    int numWords;

    Solver(char[][] puzzle, char[][] words) {
        this.puzzle = puzzle;
        this.words = words;
        this.lineSize = puzzle.length - 1;
        this.numWords = words.length;
    }

    void solve() {
        // para cada palavra
        for (int i = 0; i < numWords; i++) {
            // percorrer toda a sopa à procura da primeira letra
            char first = words[i][0];
            for (int j = 0; j < lineSize; j++) {
                for (int h = 0; h < lineSize; h++) {
                    char letter1 = puzzle[j][h];
                    if (Character.toLowerCase(first) == Character.toLowerCase(letter1)) {
                        // procurar a segunda letra e ver a direção usando uma 'stamp'
                        char second = words[i][1];
                        for (int s = -1; s <= 1; s++) {
                            for (int t = -1; t <= 1; t++) {
                                if (!(s == 0 && t == 0) && (j - s >= 0) && (h - t >= 0) && (j - s < lineSize)
                                        && (h - t < lineSize)) {
                                    char letter2 = puzzle[j - s][h - t];
                                    if (Character.toLowerCase(second) == Character.toLowerCase(letter2)) {
                                        // System.out.print(first);
                                        // System.out.print(letter2);

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    void printArrays() {
        // ------print test puzzle ---------
        for (int i = 0; i < lineSize; i++) {
            for (int j = 0; j < lineSize; j++) {
                System.out.print(puzzle[i][j]);
            }
            System.out.println();
        }

        // ------print test words ---------
        for (int i = 0; i < numWords; i++) {
            for (int j = 0; j < lineSize; j++) {
                System.out.print(words[i][j]);
            }
            System.out.println();
        }
    }

}
