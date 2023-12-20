package entities;

//Abstrata 1
public abstract class Promocao extends Cliente implements Imprimivel, Descontavel{

    //Emcapsulamento
    protected final double DESCONTO;
    protected double preco;
    protected double precoApos;


    public Promocao() {
        this.DESCONTO = 0;
    }

    public Promocao(double preco) {
        this.DESCONTO = 0;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double valorComDesconto() {
        return precoApos -= preco * DESCONTO;
    }

    public double getPrecoApos() {
        return precoApos;
    }

    public void setPrecoApos(double precoApos) {
        this.precoApos = precoApos;
    }

    public double getDESCONTO() {
        return DESCONTO;
    }

    //Sobreposição 1
    public double aplicarDesconto(double preco) {
        try {
            return precoApos = preco - (preco * DESCONTO);
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao calcular o desconto: " + e.getMessage());
            return 0;
        }
    }

    @Override
    public void mostrarDados() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Vamos explicar nossas promoções para você!!!\n"
                + "Quando for o dia do seu aniversario você tera 20% de desconto no valor total total de seu pedido.\n"
                + "Quando for quarta você tera 10% de desconto no valor total de seu pedido.";
    }
}
