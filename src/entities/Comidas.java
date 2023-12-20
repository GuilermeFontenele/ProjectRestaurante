package entities;

public class Comidas extends Cardapio {

    public Comidas(int id, String nome, double preco) {
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
