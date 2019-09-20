package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;

import banco.DefinidorDeCodigos;
import banco.ExecutaConexao;

/**
 * Esta classe configura o ambiente de homologação para a execução dos testes funcionais (Admin e Usuário) do SAO
 * 
 * @author rstargino
 * 
 **/

public class BaseTestMultiplosAdm extends BaseTestAdm implements DefinidorDeCodigos {

	public AmbientePje ambiente = new AmbientePje();
	private ExecutaConexao bd = new ExecutaConexao();
	
	@Before
	public void inicializa() throws IOException {				
		loginPage.entrarNoSAO("https://saoadmhomologacao.trt13.jus.br");
		loginPage.logar("mat-input-0", "rstargino", "mat-input-1", "123", "botaoEntrar");


	}

	@Override
	public List<Consulta> defineListaCodigos() throws IOException {
		List<Consulta> codigosBanco = new ArrayList<Consulta>();
		codigosBanco = bd.capturaCodigos(ambiente.getUrlBanco(), ambiente.getUsuarioBanco(), ambiente.getSenhaBanco());

		List<Consulta> codigosLog = new ArrayList<Consulta>();
		codigosLog = page.leLog();

		List<Consulta> codigosFinal = new ArrayList<Consulta>();

		if (!codigosLog.isEmpty()) {
			codigosFinal.addAll(codigosBanco);
			codigosFinal.removeAll(codigosLog);
		} else {
			codigosFinal.addAll(codigosBanco);
		}
		System.out.println("Códigos final - serão analisadas " + codigosFinal.size() + " consultas.");
		for (Consulta consulta : codigosFinal) {
			System.out.println(consulta.getCodigo());
		}
		return codigosFinal;
	}
}
