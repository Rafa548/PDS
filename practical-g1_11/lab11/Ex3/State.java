package Ex3;

public interface State {
    void regista(Livro livro);
    void requisita(Livro livro);
    void reserva(Livro livro);
    void cancelaReserva(Livro livro);
    void disponivel(Livro livro);
}
