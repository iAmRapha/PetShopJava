public class main {
	
	static Login login = Login.getInstance();
	static Usuarios usuarios = Usuarios.getInstance();
	
	public static void main(String[] args) {
		usuarios.adicionaUsuario("Raphael", "123456", "Senha10*", "Gerente");
		login.exibeLogin();
	}
	
}