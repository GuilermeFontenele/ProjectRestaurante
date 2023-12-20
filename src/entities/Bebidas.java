package entities;

public class Bebidas extends Cardapio {

    protected boolean alcoolica;

    public Bebidas(int id, String nome, double preco, boolean alcoolica) {
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