package entities;

public class Sobremesas extends Cardapio {

    public Sobremesas(int id, String nome, double preco) {
        super(id, nome, preco);
    }

    @Override
    public void mostrarDados() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "" + nome + ", preco=" + preco + "";
    }
}
