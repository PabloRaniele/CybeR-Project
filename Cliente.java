package prova2;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	 String nome;
	    String telefone;
	    String endereco;
	    List<Carro> carrosComprados;
	    List<Acessorio> acessoriosComprados;

	    public Cliente(String nome, String telefone, String endereco) {
	        this.nome = nome;
	        this.telefone = telefone;
	        this.endereco = endereco;
	        this.carrosComprados = new ArrayList<>();
	        this.acessoriosComprados = new ArrayList<>();
	    }

	    public void adicionarCarro(Carro carro) {
	        carrosComprados.add(carro);
	    }

	    public void adicionarAcessorio(Acessorio acessorio) {
	        acessoriosComprados.add(acessorio);
	    }

	    public String toString() {
	        return "Cliente{" +
	                "nome='" + nome + '\'' +
	                ", telefone='" + telefone + '\'' +
	                ", endereco='" + endereco + '\'' +
	                ", carrosComprados=" + carrosComprados +
	                ", acessoriosComprados=" + acessoriosComprados +
	                '}';
	    }
}
