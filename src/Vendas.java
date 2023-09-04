import java.util.ArrayList;
import java.util.List;

public final class Vendas {
	
	private static Vendas instance;
	List<Venda> vendas;
	
	public Vendas() {
		this.vendas = new ArrayList<>();
		realizaVenda(230.0, "C", "123456");
		realizaVenda(120.0, "C", "654321");
		realizaVenda(230.0, "D", "123456");
		realizaVenda(300.0, "D", "654321");
	}

	public void realizaVenda(double valor, String formaPagamento, String matricula) {
		Venda venda = new Venda(valor, formaPagamento, matricula);
		vendas.add(venda);
	}

	public void gerarRelatorio() {
		System.out.println("|Nº |  Matrícula  | Valor  |  Pagamento  |");
		for(int i = 0; i < this.vendas.size(); i++) {
			Venda venda = vendas.get(i);
			System.out.println((i+1) + ") " + venda.getMatricula() + " " + venda.getValor() + " " + venda.getFormaPagamento());
		}
	}
	
	public void gerarRelatorioIndividual(String matricula) {
		System.out.println("|Nº |  Matrícula  | Valor  |  Pagamento  |");
		for(int i = 0; i < this.vendas.size(); i++) {
			Venda venda = vendas.get(i);
			if(vendas.get(i).getMatricula().equals(matricula)) {
			System.out.println((i+1) + ") " + venda.getMatricula() + " " + venda.getValor() + " " + venda.getFormaPagamento());
			}
		}	
	}
	
	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
	public static Vendas getInstance() {
		if(instance == null) {
			instance = new Vendas();
		}
		return instance;
	}
	
}
