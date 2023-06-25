package lab03;

public class Jogar implements JGaloInterface {

    private char[][] botoes;
    private char jogador; 
    private int jogadas;

    // Construtor Sem Argumentos
    public Jogar(){ 
 
        botoes = new char[3][3];
        jogador = 'X';       
        jogadas = 0;                  
    }

    // Construtor Com Argumentos
    public Jogar(char arg){ 

        botoes = new char[3][3];
        jogador = arg;
        jogadas = 0;
    }
    
    @Override
    public char getActualPlayer() {

        return this.jogador;
    }

    @Override
	public boolean setJogada(int lin, int col) {

        // Guarda a jogada
        botoes[lin-1][col-1] = this.jogador;
        this.jogadas++;

        return true;
    }

    @Override
	public boolean isFinished() {

        // Um jogador ganhou ou já não é possível fazer mais jogadas
        if (checkResult() != ' ' || this.jogadas == 9) return true;
        
        // Como o jogo não acabou, troca-se de jogador
        if (this.getActualPlayer() == 'X') this.jogador = 'O';
        else this.jogador = 'X';
        
        return false;
    }

    @Override
	public char checkResult() {

        // Default é o empate
        char resultado = ' ';
        
        // Verificar se algum jogador ganhou nas linhas e colunas
        for (int i = 0 ; i < 3 ; i++) {

            char l = this.botoes[i][0];
            char c = this.botoes[0][i];

            if (l == this.botoes[i][1] && l == this.botoes[i][2] && l != 0) resultado = l;
            else if (c == this.botoes[1][i] && c == this.botoes[2][i] && c != 0) resultado = c;
        }

        char d = this.botoes[1][1];

        // Verificar se algum jogador ganhou nas diagonais
        if (d == this.botoes[0][0] && d == this.botoes[2][2] && d != 0) resultado = d;
        else if (d == this.botoes[2][0] && d == this.botoes[0][2] && d != 0) resultado = d;
        
        return resultado;
    }
}
