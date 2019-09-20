package core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import banco.DefinidorDeCodigos;
import banco.ExecutaConexao;
import pages.LoginPagePje;

/**
 * Esta superclasse contém métodos que serão utilizados por todas as classes de
 * testes como @Before e @After escrita e leitura de arquivos
 * 
 * @author rstargino
 * 
 **/

public class BaseTestPje extends BaseTest implements DefinidorDeCodigos {

	public AmbientePje ambiente = new AmbientePje();

	protected BasePagePje page = new BasePagePje();

	protected LoginPagePje loginPage = new LoginPagePje();

	private ExecutaConexao bd = new ExecutaConexao();

	@Rule
	public TestName testName = new TestName();

	@Before
	public void inicializa() throws IOException {
		ambiente.configuraAmbiente();
		loginPage.acessaPaginaInicial(ambiente.getUrlPje());
		loginPage.logar("username", ambiente.getLoginPje(), "password", ambiente.getSenhaPje(), "btnEntrar");
		loginPage.entrarNoSAO(ambiente.getUrlSao());

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
