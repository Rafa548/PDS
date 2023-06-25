package Ex3;

public class Main {
    public static void main(String[] args) {
        Livro livro = new Livro("Harry Potter", "123456789", "J.K. Rowling", "1997");

        
            livro.setState(new Disponivel());
            livro.requisita();
            livro.setState(new Emprestado());
            livro.requisita();
            livro.setState(new Reservado());
            livro.requisita();
            livro.setState(new Disponivel());
            livro.requisita();
        
    }
}
