package entities;

import java.util.ArrayList;
import java.util.List;

public class Pedido implements Avaliavel, Imprimivel{

    protected Cliente cliente;
    protected List<Cardapio> itens;
    protected int nota;

    public Pedido() {

    }

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Cardapio item) {
        this.itens.add(item);
    }


    @Override
    public void avaliar(int nota) {
        this.nota = nota;
    }

    @Override
    public int getNota() {
        return nota;
    }

    public double calcularTotal() {
        double total = 0.0;
        try {
            for (Cardapio item : this.itens) {
                total += item.getPreco();
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao calcular o total: " + e.getMessage());
        }
        return total;
    }

    @Override
    public String toString() {
        return "Pedido do cliente = " + cliente.nome + ", " + itens + ", Total = R$" + calcularTotal() + ", Nota: " + getNota();
    }

    @Override
    public void mostrarDados() {
        System.out.println(this.toString());
    }


}

