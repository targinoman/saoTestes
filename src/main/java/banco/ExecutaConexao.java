package banco;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import core.Consulta;

public class ExecutaConexao {

	public List<Consulta> capturaCodigos(String urlBanco, String usuarioBanco, String senhaBanco) {
		ConexaoBancoDados con = new ConexaoBancoDados(urlBanco, usuarioBanco, senhaBanco);
		String sql = "Select cd_consulta from tb_consulta ORDER BY cd_consulta ASC";
		ResultSet rs = con.executaBusca(sql);
		ArrayList<Consulta> codigos = new ArrayList<Consulta>();
		try {

			while (rs.next()) {
				String cdConsulta = rs.getString("cd_consulta");
				Consulta c = new Consulta();
				c.setCodigo(cdConsulta);
				codigos.add(c);
			}

		} catch (Exception e) {
			System.out.println("falha");
		}
		return codigos;
	}

}
