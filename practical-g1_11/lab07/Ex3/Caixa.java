package Ex3;

import java.util.List;
import java.util.ArrayList;

public class Caixa extends ProdutoInterface{

    private String name;
    private int weight;
    private List<ProdutoInterface> produtos = new ArrayList<>();


    public Caixa(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public void add(ProdutoInterface produto) {
        produtos.add(produto);
        //weight += produto.getWeight();
    }
    
    public int getWeight() {
        return weight;
    }

    public int getWeightTotal() {
        int total = weight;
        for (ProdutoInterface produto : produtos) {
            if (produto instanceof Caixa) {
                total += ((Caixa) produto).getWeightTotal();
            }
            else {
                total += produto.getWeight();
            }
        }
        return total;
    }

    public void draw() {
        System.out.println(indent + "Caixa: " + name + " (" + getWeightTotal() + "g)");
        indent.append("  ");
        for (ProdutoInterface produto : produtos) {
            produto.draw();
        }
        indent.setLength(indent.length() - 2);
    }

}
