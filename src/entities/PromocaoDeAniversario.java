package entities;

import java.time.LocalDate;

public class PromocaoDeAniversario extends Promocao {

    public PromocaoDeAniversario() {

    }

    public PromocaoDeAniversario(double preco, double DESCONTO, double precoApos, LocalDate dataDeAniversario) {
        super();
        this.DESCONTO = DESCONTO;
        this.preco = preco;
        this.precoApos = precoApos;
        this.dataDeAniversario = dataDeAniversario;

    }

    double DESCONTO = 0.8;

    public double aplicarDesconto(double preco) {
        try {
            return preco * DESCONTO;
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao calcular o desconto de aniversario: " + e.getMessage());
            return 0;
        }
    }
    @Override
    public void mostrarDados() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return ", Desconto = " + "20%";
    }
}

