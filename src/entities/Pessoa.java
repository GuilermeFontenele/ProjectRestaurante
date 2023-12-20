package entities;

//Abstrata 2
public abstract class Pessoa implements Imprimivel{

    //Encapsulamento
    protected String nome;
    protected String email;
    protected int id;

    //Sobrecarga
    public Pessoa() {

    }

    public Pessoa(String nome, String email, int id) {
        super();
        this.nome = nome;
        this.email = email;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws InvalidNomeException {
        try {
            if (nome == null) {
                throw new IllegalArgumentException("Por favor, insira um nome");
            }
            if (!Character.isUpperCase(nome.charAt(0))) {
                throw new InvalidNomeException("O nome deve começar com uma letra maiúscula");
            }
            this.nome = nome;
        } catch (IllegalArgumentException | InvalidNomeException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InvalidEmailException {
        if (email == null || !email.contains("@")) {
            throw new InvalidEmailException("Email inválido.");
        }
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Sobreposição 2
    public String getContato() {
        return "Email: " + email;
    }

    @Override
    public void mostrarDados() {
        System.out.println(this.toString());
    }
    @Override
    public String toString() {

        return " Nome: " + this.getNome()
                + ", Email: " + this.getEmail()
                + ", ID: " + this.getId();
    }

}
