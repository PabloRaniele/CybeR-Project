package prova2;

public class Acessorio {
	String nome;
    int quantidade;

    public Acessorio(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    
    public String toString() {
        return "Acessorio{" +
                "nome='" + nome + '\'' +
                ", quantidade=" + quantidade +
                '}';
    }
}
