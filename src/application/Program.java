package application;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import entities.Bebidas;
import entities.Cardapio;
import entities.Cliente;
import entities.Comidas;
import entities.Funcionario;
import entities.InvalidEmailException;
import entities.InvalidNomeException;
import entities.Pedido;
import entities.Promocao;
import entities.PromocaoDeAniversario;
import entities.PromocaoDeQuarta;
import entities.Sobremesas;

public class Program {

    static List<Funcionario> funcionariosPendentes = new ArrayList<>();
    static List<Funcionario> funcionariosAprovados = new ArrayList<>();

    public static void main(String[] args) throws InvalidEmailException, InvalidNomeException {

        Scanner sc = new Scanner(System.in);

        Funcionario funcionario = new Funcionario();
        Cliente cliente = new Cliente();
        LocalDate hoje = LocalDate.now();
        Pedido pedido = new Pedido(cliente);
        PromocaoDeAniversario promo1 = new PromocaoDeAniversario();
        PromocaoDeQuarta promo2 = new PromocaoDeQuarta();
        Promocao promo = new Promocao() {};
        Cardapio cardapio = new Cardapio() {};

        int idConfere = 0;
        String emailConfere = null;
        String voltar;
        int opcao = 0;
        double total = 0;

        Comidas xburguer = new Comidas(1, "X-Burguer", 17.0);
        Bebidas suco = new Bebidas(4, "Suco", 8.0, false);
        Sobremesas sorvete = new Sobremesas(7, "Sorvete", 7.5);
        Comidas xbacon = new Comidas(2, "X-Bacon", 25.0);
        Bebidas refri = new Bebidas(5, "Refri", 5.0, false);
        Sobremesas brigadeiro = new Sobremesas(8, "Brigadeiro", 2.0);
        Comidas xsalada = new Comidas(3, "X-Salada", 20.0);
        Bebidas vitamina = new Bebidas(6, "Vitamina", 12.0, false);
        Sobremesas milkshake = new Sobremesas(9, "Milkshake", 12.0);
        Funcionario guilherme = new Funcionario("Guilherme", "guilherme@gmail.com", 01 , "Chefe" , 6000.00);

        funcionariosAprovados.add(guilherme);

        //adicionarSobremesas("sobremesas.txt");

        do {
            boolean validAccount = false;
            while(!validAccount) {
                System.out.println("1. Você é um cliente");
                System.out.println("2. Você é um funcionario");
                System.out.print("Escolha uma opção: ");
                opcao = sc.nextInt();
                sc.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("Você ja tem cadastro? (Sim/Não) ");
                        String opcao2 = sc.next();
                        if(opcao2.equalsIgnoreCase("NÃO") || (opcao2.equalsIgnoreCase("NAO"))) {
                            sc.nextLine();
                            System.out.println("Escreva seu nome: ");
                            String nome = sc.nextLine();
                            while (nome.isEmpty() || !Character.isUpperCase(nome.charAt(0))) {
                                System.out.println("Nome invalido. Por favor, digite novamente: ");
                                nome = sc.nextLine();
                            }
                            cliente.setNome(nome);

                            System.out.println("Escreva seu email: ");
                            String email = sc.nextLine();
                            while (email.isEmpty() || !email.contains("@")) {
                                System.out.println("Email invalido. Por favor, digite novamente: ");
                                email = sc.nextLine();
                            }
                            cliente.setEmail(email);

                            System.out.println("Escreva seu numero de cadastro: ");
                            while (!sc.hasNextInt()) {
                                System.out.println("Número de cadastro deve ser um número inteiro. Por favor, digite novamente: ");
                                sc.next();
                            }
                            int id = sc.nextInt();
                            cliente.setId(id);

                            System.out.println("Escreva sua data de aniversario (dd/MM/yyyy)");
                            String dataString = sc.next();
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            LocalDate data = LocalDate.parse(dataString, formatter);
                            cliente.setDataDeAniversario(data);

                            System.out.println("Agora vamos mostrar seus dados");
                            cliente.mostrarDados();
                            sc.nextLine();
                            validAccount = true;

                        } else if(opcao2.equalsIgnoreCase("SIM")) {
                            System.out.println("Digite seu ID: ");
                            idConfere = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Digite seu e-mail: ");
                            emailConfere = sc.nextLine();
                            if(idConfere == cliente.getId() && emailConfere.equals(cliente.getEmail())){
                                validAccount = true;
                                System.out.println("Conta acessada com sucesso");
                            } else {
                                System.out.println("Conta não existe. Tente novamente.");
                                validAccount = false;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Você é um funcionario? (Sim/Não) ");
                        String opcao3 = sc.next();
                        if(opcao3.equalsIgnoreCase("NÃO") || (opcao3.equalsIgnoreCase("NAO"))) {
                            sc.nextLine();
                            System.out.println("Vamos mandar seu curriculo!");
                            System.out.println("Escreva seu nome: ");
                            String nome = sc.nextLine();
                            while (nome.isEmpty() || !Character.isUpperCase(nome.charAt(0))) {
                                System.out.println("Nome invalido. Por favor, digite novamente: ");
                                nome = sc.nextLine();
                            }
                            funcionario.setNome(nome);

                            System.out.println("Escreva seu email: ");
                            String email = sc.nextLine();
                            while (email.isEmpty() || !email.contains("@")) {
                                System.out.println("Email invalido. Por favor, digite novamente: ");
                                email = sc.nextLine();
                            }
                            funcionario.setEmail(email);

                            System.out.println("Escreva seu numero de cadastro: ");
                            while (!sc.hasNextInt()) {
                                System.out.println("Número de cadastro deve ser um número inteiro. Por favor, digite novamente: ");
                                sc.next();
                            }
                            int id = sc.nextInt();
                            funcionario.setId(id);
                            sc.nextLine();

                            System.out.println("Escreva o cargo que você pretende assumir: ");
                            String cargo = sc.nextLine();
                            while (cargo.isEmpty()) {
                                System.out.println("Cargo não pode ser vazio. Por favor, digite novamente: ");
                                cargo = sc.nextLine();
                            }
                            funcionario.setCargo(cargo);

                            System.out.println("Escreva o salario que você pretende receber: ");
                            while (!sc.hasNextDouble()) {
                                System.out.println("Salário deve ser um número. Por favor, digite novamente: ");
                                sc.next();
                            }
                            double salario = sc.nextDouble();
                            funcionario.setSalario(salario);

                            System.out.println("Agora vamos mostrar seu curriculo");
                            funcionario.mostrarDados();
                            sc.nextLine();
                            funcionariosPendentes.add(funcionario);
                            validAccount = false;
                        }else if(opcao3.equalsIgnoreCase("SIM")) {
                            System.out.println("Digite seu ID: ");
                            idConfere = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Digite seu e-mail: ");
                            emailConfere = sc.nextLine();
                            Funcionario funcionarioLogado = null;
                            for (Funcionario f : funcionariosAprovados) {
                                if (f.getId() == idConfere && emailConfere.equals(f.getEmail())) {
                                    funcionarioLogado = f;
                                    break;
                                }
                            }
                            if(funcionarioLogado != null){
                                validAccount = true;
                                System.out.println("Conta do funcionário acessada com sucesso");
                            } else {
                                System.out.println("Você não é funcionário. Tente novamente.");
                            }
                        }

                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            }

            if(validAccount && opcao == 1) {
                boolean sair = false;
                do {
                    System.out.println("1. Ver cardapio");
                    System.out.println("2. Fazer pedidos");
                    System.out.println("3. Ver Meus pedidos");
                    System.out.println("4. Avaliar");
                    System.out.println("5. Entender sobre os descontos");
                    System.out.println("6. Voltar para a parte de Login");
                    System.out.println("7. Finalizar atendimento");
                    System.out.print("Escolha uma opção: ");
                    int opcao1 = sc.nextInt();
                    sc.nextLine();

                    switch (opcao1) {
                        case 1:
                            cardapio.mostrarDados();
                            voltar = sc.nextLine();
                            if(voltar.equalsIgnoreCase("X")){
                                break;
                            } else if(voltar.equalsIgnoreCase("Y")) {
                                opcao1 = 2;
                                break;
                            }else {
                                continue;
                            }
                        case 2:
                            System.out.println("Escreva os ids dos seus Pedidos (separados por espaço): ");
                            String[] ids = sc.nextLine().split(" "); //divide a linha sempre que tiver espaços
                            for (String idPedido : ids) {
                                int itemId = Integer.parseInt(idPedido);
                                switch (itemId) {
                                    case 1:
                                        pedido.adicionarItem(xburguer);
                                        break;
                                    case 2:
                                        pedido.adicionarItem(xbacon);
                                        break;
                                    case 3:
                                        pedido.adicionarItem(xsalada);
                                        break;
                                    case 4:
                                        pedido.adicionarItem(suco);
                                        break;
                                    case 5:
                                        pedido.adicionarItem(refri);
                                        break;
                                    case 6:
                                        pedido.adicionarItem(vitamina);
                                        break;
                                    case 7:
                                        pedido.adicionarItem(sorvete);
                                        break;
                                    case 8:
                                        pedido.adicionarItem(brigadeiro);
                                        break;
                                    case 9:
                                        pedido.adicionarItem(milkshake);
                                        break;
                                    default: //caso nenhum responda
                                        System.out.println("Id inválido. Tente novamente.");
                                        break;
                                }
                            }
                            break;
                        case 3:
                            System.out.println("Seus pedidos: ");
                            total = pedido.calcularTotal();
                            if (cliente.getDataDeAniversario().getDayOfYear() == hoje.getDayOfYear()) {
                                total = promo1.aplicarDesconto(total);
                            }else if(hoje.getDayOfWeek() == DayOfWeek.WEDNESDAY){
                                total = promo2.aplicarDesconto(total);
                            }
                            System.out.println(pedido.toString());
                            System.out.println("Total com descontos aplicados: R$" + total);
                            break;
                        case 4:
                            System.out.println("Avalie seu pedido (de 1 a 10): ");
                            int nota = sc.nextInt();
                            while(nota > 10 || nota < 1) {
                                System.out.println("Nota invalida, escreva a nota de novo.");
                                nota = sc.nextInt();
                            }
                            pedido.avaliar(nota);
                            System.out.println("Obrigado pela sua avaliação!");
                            break;
                        case 5:
                            promo.mostrarDados();
                            try {
                                TimeUnit.SECONDS.sleep(8);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 6:
                            sair = true;
                            break;
                        case 7:
                            System.out.println("Atendimento Finalizado.");
                            sc.close();
                            System.exit(0);
                    }
                }while (!sair);
            }
            if(validAccount && opcao == 2) {
                boolean sair = false;
                do {
                    System.out.println("1. Ver Curriculos");
                    System.out.println("2. Aceitar curriculo");
                    System.out.println("3. Ver pedidos");
                    System.out.println("4. Ver meus dados");
                    System.out.println("5. Voltar para a parte de Login");
                    System.out.println("6. Finalizar atendimento");
                    System.out.print("Escolha uma opção: ");
                    int opcao4 = sc.nextInt();
                    sc.nextLine();

                    switch (opcao4) {
                        case 1:
                            for (Funcionario f : funcionariosPendentes) {
                                f.mostrarDados();
                            }
                            break;
                        case 2:
                            System.out.println("Digite o ID do currículo que você deseja aceitar: ");
                            int idCurriculo = sc.nextInt();
                            for (Funcionario f : funcionariosPendentes) {
                                if (f.getId() == idCurriculo) {
                                    funcionariosAprovados.add(f);
                                    funcionariosPendentes.remove(f);
                                    System.out.println("Currículo aceito!");
                                    break;
                                }
                            }
                            break;
                        case 3:
                            pedido.mostrarDados();
                            System.out.println("Total com descontos aplicados: " + total);
                            break;
                        case 4:
                            funcionario.mostrarDados();
                            break;
                        case 5:
                            sair = true;
                            break;
                        case 6:
                            System.out.println("Atendimento Finalizado.");
                            sc.close();
                            System.exit(0);
                    }
                }while (!sair);
            }
        }while (true);
    }
}
