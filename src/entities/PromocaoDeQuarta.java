package entities;

public class PromocaoDeQuarta extends Promocao{

    public PromocaoDeQuarta(){
    }

    public PromocaoDeQuarta(double preco, double DESCONTO, double precoApos) {
        super();
        this.DESCONTO = DESCONTO;
        this.preco = preco;
        this.precoApos = precoApos;

    }

    double DESCONTO = 0.9;

    public double aplicarDesconto(double total) {
        try {
            return total * DESCONTO;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao calcular o desconto de quarta: ");
            e.printStackTrace();
            return 0;
        }
    }
    @Override
    public void mostrarDados() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return ", Desconto = " + "10%";
    }
}
