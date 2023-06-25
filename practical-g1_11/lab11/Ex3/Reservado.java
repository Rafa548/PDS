package Ex3;

public class Reservado implements State{
    public void regista(Livro livro) {
        System.out.println("Livro já registado");
    }

    public void requisita(Livro livro) {
        System.out.println("Livro já requisitado");
    }

    public void reserva(Livro livro) {
        System.out.println("Livro já reservado");
    }

    public void cancelaReserva(Livro livro) {
        System.out.println("Reserva cancelada");
        livro.setState(new Disponivel());
    }

    public void disponivel(Livro livro) {
        System.out.println("Livro disponível");
        livro.setState(new Disponivel());
    }

    
}
