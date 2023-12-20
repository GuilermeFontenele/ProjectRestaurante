package entities;

import java.time.LocalDate;

public class Cliente extends Pessoa {

    //Encapsulamento
    protected Pedido pedidos;
    protected int telefone;
    protected LocalDate dataDeAniversario;

    //Sobrecarga 2
    public Cliente() {
        super();
    }

    public Cliente(Pedido pedidos, int telefone, LocalDate dataDeAniversario) {
        this.pedidos = pedidos;
        this.telefone = telefone;
        this.dataDeAniversario = dataDeAniversario;
    }

    public Pedido getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedido pedidos) {
        this.pedidos = pedidos;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public LocalDate getDataDeAniversario() {
        return dataDeAniversario;
    }

    public void setDataDeAniversario(LocalDate dataDeAniversario) {
        this.dataDeAniversario = dataDeAniversario;
    }

    @Override
    public String getContato() {
        return getContato() + "Telefone: " + telefone + ", Email: " + email;
    }

    @Override
    public void mostrarDados() {
        System.out.println(this.toString());
    }
    @Override
    public String toString() {

        return " Nome: " + this.getNome()
                + ", Email: " + this.getEmail()
                + ", ID: " + this.getId()
                + ", Data de Aniversário: " + this.getDataDeAniversario();
    }
}
