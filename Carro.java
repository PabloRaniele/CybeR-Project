package prova2;

public class Carro {
	 String modelo;
	    String cor;
	    String formaPagamento;

	    public Carro(String modelo, String cor, String formaPagamento) {
	        this.modelo = modelo;
	        this.cor = cor;
	        this.formaPagamento = formaPagamento;
	    }

	  
	    public String toString() {
	        return "Carro{" +
	                "modelo='" + modelo + '\'' +
	                ", cor='" + cor + '\'' +
	                ", formaPagamento='" + formaPagamento + '\'' +
	                '}';
	    }
}
