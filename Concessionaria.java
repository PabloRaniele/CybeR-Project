package prova2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Concessionaria {

	 private static final String SENHA_CORRETA = "123";
	    private static List<Cliente> listaClientes = new ArrayList<>();

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        boolean senhaValida = false;

	     
	        while (!senhaValida) {
	            System.out.print("Digite a senha: ");
	            String senha = sc.nextLine();
	            if (SENHA_CORRETA.equals(senha)) {
	                System.out.println("SENHA CORRETA");
	                senhaValida = true;
	            } else {
	                System.out.println("ERRO DE SENHA");
	            }
	        }

	        // Menu principal
	        boolean continuar = true;
	        while (continuar) {
	            System.out.println("\nMENU PRINCIPAL:");
	            System.out.println("1. Cadastro cliente");
	            System.out.println("2. Compra de carro");
	            System.out.println("3. Compra de acessório");
	            System.out.println("4. Listar clientes");
	            System.out.println("5. Sair");
	            System.out.print("Escolha uma opção: ");
	            int opcao = sc.nextInt();
	            sc.nextLine();

	            switch (opcao) {
	                case 1:
	                    cadastrarCliente(sc);
	                    break;
	                case 2:
	                    comprarCarro(sc);
	                    break;
	                case 3:
	                    comprarAcessorio(sc);
	                    break;
	                case 4:
	                    listarClientes();
	                    break;
	                case 5:
	                    continuar = false;
	                    System.out.println("Saindo do programa.");
	                    break;
	                default:
	                    System.out.println("Opção inválida. Tente novamente.");
	                    break;
	            }
	        }

	        sc.close();
	    }

	    private static void cadastrarCliente(Scanner sc) {
	        System.out.println("\nCadastro de Cliente:");
	        System.out.print("Nome: ");
	        String nome = sc.nextLine();
	        System.out.print("Telefone: ");
	        String telefone = sc.nextLine();
	        System.out.print("Endereço: ");
	        String endereco = sc.nextLine();

	        Cliente cliente = new Cliente(nome, telefone, endereco);
	        listaClientes.add(cliente);

	        System.out.println("Cliente cadastrado com sucesso: " + nome);
	    }

	    private static void comprarCarro(Scanner sc) {
	        if (listaClientes.isEmpty()) {
	            System.out.println("Nenhum cliente cadastrado. Cadastre um cliente primeiro.");
	            return;
	        }

	        System.out.println("\nCompra de Carro:");
	        Cliente cliente = selecionarCliente(sc);

	        System.out.println("Escolha um carro:");
	        System.out.println("1. Fiat Uno ");
	        System.out.println("2. Wolkswange Gol bola");
	        System.out.println("3. Hyundai Ix35");
	        System.out.print("Opção: ");
	        int carroEscolhido = sc.nextInt();
	        sc.nextLine();  

	        String modelo = "";
	        switch (carroEscolhido) {
	            case 1:
	                modelo = "Fiat Uno";
	                break;
	            case 2:
	                modelo = "Wolkswange Gol bola";
	                break;
	            case 3:
	                modelo = "Hyundai Ix35";
	                break;
	            default:
	                System.out.println("Opção inválida. Selecionando Carro A por padrão.");
	                modelo = "Carro A";
	                break;
	        }

	        System.out.print("Escolha a cor do carro:\n"); 
	        System.out.println("1.Preta");
	        System.out.println("2.azul");
	        System.out.println("3.Vermelho");    
	        System.out.print("Opção: ");
	        int paleta = sc.nextInt();
	       	sc.nextLine();
	        System.out.println("Escolha a forma de pagamento:");
	        System.out.println("1. Card Credito");
	        System.out.println("2. Card Debito");
	        System.out.println("3. PIX");

	        System.out.print("Opção: ");
	        int pagamento = sc.nextInt();
	        sc.nextLine();

	        //condição "?" Serve para puxar a opção de escolha para o console
	        String formaPagamento = (pagamento == 1) ? "Card Credito" : (paleta == 2) ? "Card Debito" : "PIX";
	        String cor = (paleta == 1) ? "Preta" : (paleta == 2) ? "Azul" : "Vermelho";

	        Carro carro = new Carro(modelo, cor, formaPagamento);
	        cliente.adicionarCarro(carro);

	        System.out.println("Compra realizada: " + carro);
	    }

	    private static void comprarAcessorio(Scanner sc) {
	        if (listaClientes.isEmpty()) {
	            System.out.println("Nenhum cliente cadastrado. Cadastre um cliente primeiro.");
	            return;
	        }

	        System.out.println("\nCompra de Acessório:");
	        Cliente cliente = selecionarCliente(sc);

	        System.out.print("Nome do acessório: ");
	        String nome = sc.nextLine();
	        System.out.print("Quantidade: ");
	        int quantidade = sc.nextInt();
	        sc.nextLine();

	        Acessorio acessorio = new Acessorio(nome, quantidade);
	        cliente.adicionarAcessorio(acessorio);

	        System.out.println("Acessório comprado: " + acessorio);
	    }

	    private static Cliente selecionarCliente(Scanner sc) {
	        System.out.println("Selecione o cliente:");
	        for (int i = 0; i < listaClientes.size(); i++) {
	            System.out.println((i + 1) + ". " + listaClientes.get(i).nome);
	        }
	        System.out.print("Opção: ");
	        int opcaoCliente = sc.nextInt();
	        sc.nextLine();

	        if (opcaoCliente < 1 || opcaoCliente > listaClientes.size()) {
	            System.out.println("Opção inválida. Selecionando o primeiro cliente por padrão.");
	            opcaoCliente = 1;
	        }

	        return listaClientes.get(opcaoCliente - 1);
	    }

	    private static void listarClientes() {
	        System.out.println("\nLista de Clientes:");
	        if (listaClientes.isEmpty()) {
	            System.out.println("Nenhum cliente cadastrado.");
	        } else {
	            for (Cliente cliente : listaClientes) {
	                System.out.println(cliente);
	            }
	        }
	    }

}
