package Ex1;

public class Produto {
    private static int id = 1;
    private int idProduto;
    private String desc;
    private double preco;

    public Produto(String desc, double preco) {
        this.desc = desc;
        this.preco = preco;
        this.idProduto = id;
        id++;
    }

    public String getDesc() {
        return desc;
    }

    public double getPreco() {
        return preco;
    }


    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


}
