package entities;

//import java.util.HashMap;
//import java.util.Map;

public class Funcionario extends Pessoa{

    //Encapsulamento
    protected String cargo;
    protected double salario;

    //public static Map<Integer, Funcionario> funcionarios = new HashMap<>();

    //Sobrecarga 3
    public Funcionario() {
        super();
    }

    public Funcionario(String cargo, double salario) {
        this.cargo = cargo;
        this.salario = salario;
    }

    public Funcionario(String nome, String email, int id, String cargo, double salario) {
        super(nome, email, id);
        this.cargo = cargo;
        this.salario = salario;
        //funcionarios.put(id, this);
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String getContato() {
        return getContato() + " Email: " + email;
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
                + ", Salario Esperado: R$" + this.getSalario()
                + ", Cargo: " + this.getCargo();
    }
}
