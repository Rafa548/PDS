package Ex3;


public class Livro {
    private String titulo, ISBN, autor, ano;
    private State state;

    public Livro(String titulo, String ISBN, String autor, String ano) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.autor = autor;
        this.ano = ano;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void regista() {
        state.regista(this);
    }
    public void requisita() {
        state.requisita(this);
    }

    public void reserva() {
        state.reserva(this);
    }

    public void cancelaReserva() {
        state.cancelaReserva(this);
    }

    public void disponivel() {
        state.disponivel(this);
    }



}
