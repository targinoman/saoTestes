package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConexaoBancoDados {

	private String url;
	private String usuario;
	private String senha;
	private Connection con;

	public ConexaoBancoDados(String url, String usuario, String senha) {

		this.setUrlBanco(url);

		this.setUsuarioBanco(usuario);

		this.setSenhaBanco(senha);

		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(this.getUrlBanco(), this.getUsuarioBanco(), this.getSenhaBanco());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ResultSet executaBusca(String sql) {
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			con.close();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setUrlBanco(String url) {
		this.url = url;
	}

	public void setUsuarioBanco(String usuario) {
		this.usuario = usuario;
	}

	public void setSenhaBanco(String senha) {
		this.senha = senha;
	}

	public String getUsuarioBanco() {
		return usuario;
	}

	public String getSenhaBanco() {
		return senha;
	}

	public String getUrlBanco() {
		return url;
	}

}
