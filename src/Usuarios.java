import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public final class Usuarios {
	
	private static Usuarios instance;
	List<Usuario> usuarios;
	
	public Usuarios() {
		this.usuarios = new ArrayList<>();
	}
	
	public Usuario adicionaUsuario(String nome, String matricula, String senha, String tipo) {
		Usuario usuario;
		boolean senhaValida = validaSenha(senha);
		if(senhaValida) {
			if(tipo.equals("Gerente")) {
				usuario = new Gerente(nome, matricula, senha);
				System.out.println("Gerente cadastrado com sucesso!");
			}else {
				usuario = new Vendedor(nome, matricula, senha);
				System.out.println("Vendedor cadastrado com sucesso!");
			}
			usuarios.add(usuario);
			return usuario;
		} else {
			System.out.println("A senha não corresponde com os padrões exigidos. Tente novamente.");
			return null;
		}
		
		
	}
	
	public boolean validaSenha(String senha) {
		Pattern senhaPattern = Pattern.compile("(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}");
		Matcher matcher = senhaPattern.matcher(senha);
		
		if(matcher.find()) {
			return true;
		}
		return false;
	}
	
	public int indexof(String matricula) {
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getMatricula().equals(matricula)) {
				return i;
			}
		}
		return -1;
	}
	
	public Usuario checkCredenciais(String matricula, String senha) {
		for(int i = 0; i < usuarios.size(); i++) {
			if(usuarios.get(i).getMatricula().equals(matricula)) {
				if(usuarios.get(i).getSenha().equals(senha)) {
					return usuarios.get(i);
				}
			}
		}
		return null;
	}
	
	public void removeUsuario(String matricula) {
		int indice = this.indexof(matricula);
		if(indice != -1) {
			usuarios.remove(indice);
			System.out.println("Usuário removido com sucesso!");
		} else {
			System.out.println("Usuário não foi encontrato!");
		}
	}
	
	public List<Usuario> getUsuarios(){
		return this.usuarios;
	}
	
	public static Usuarios getInstance() {
		if(instance == null) {
			instance = new Usuarios();
		}
		
		return instance;
	}
	
}
