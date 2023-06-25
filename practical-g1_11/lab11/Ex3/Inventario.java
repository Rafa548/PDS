package Ex3;

public class Inventario implements State{

    public void regista(Livro livro) {
        System.out.println("Livro já registado");
    }

    public void requisita(Livro livro) {
        System.out.println("Livro requisitado");
        livro.setState(new Emprestado());
    }

    public void reserva(Livro livro) {
        System.out.println("Livro reservado");
        livro.setState(new Reservado());
    }

    public void cancelaReserva(Livro livro) {
        System.out.println("Livro não reservado");
    }

    public void disponivel(Livro livro) {
        System.out.println("Livro disponível");
    }
    
}
