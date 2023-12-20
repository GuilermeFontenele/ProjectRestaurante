package entities;

//Abstrata 1
public abstract class Cardapio implements Imprimivel{

    //Encapsulamento
    protected int id;
    protected String nome;
    protected double preco;

    //Sobrecarga 1
    public Cardapio() {

    }

    public Cardapio(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) throws IllegalArgumentException  {
        if (preco < 0) {
            throw new IllegalArgumentException ("Preço não pode ser negativo.");
        }
        this.preco = preco;
    }


    @Override
    public void mostrarDados() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {

        return "	 Comidas "
                + "\nX-Burguer    - R$17 - id = 1"
                + "\nX-Bacon      - R$25 - id = 2"
                + "\nX-Salada     - R$20 - id = 3"
                + "\n	 Bebidas "
                + "\nSuco 	     - R$8  - id = 4"
                + "\nRefrigerante - R$5  - id = 5"
                + "\nVitamina     - R$12 - id = 6"
                + "\n	 Sobremesas "
                + "\nSorvete      - R$7  - id = 7"
                + "\nBrigadeiro   - R$2 - id = 8"
                + "\nMilkshake    - R$12 - id = 9"


                + "\n   Escreva X Para Voltar";
    }
}
