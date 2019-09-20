package pje;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.NoSuchElementException;

import core.BaseTestPje;
import core.Consulta;

/**
 * Teste de fuma�a para descobrir quais consultas est�o sendo montadas
 * corretamente e quais n�o est�o. Ao executar a classe como teste do JUnit ser�
 * solicitado no console em qual ambiente ele ser� executado
 * 
 * 1 - SaoPJe Homologa��o | 2 - SaoPJe Bugfix | 3 - SaoPje Adm
 * 
 * Este m�todo est� na classe Ambiente do pacote core
 * 
 * @author rstargino
 * 
 **/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteDeFumacaPje extends BaseTestPje {

	private Map<String, String> parametros = page.carregaParametros();

	List<Consulta> errados = new ArrayList<Consulta>();

	/**
	 * Este teste captura os c�digos de consulta no banco do ambiente selecionado e
	 * executa todos eles capturado mensagens de erro ou sucesso. Caso a consulta
	 * n�o seja executada corretamente, o c�digo da consulta � salvo no arquivo
	 * errados.txt e � tirado um printscreen da tela. O arquivo ser� salvo em
	 * target/screenshot. Al�m disso, � medida que as consultas s�o executadas, seus
	 * c�digos s�o salvos no arquivo c�digos.txt para que, no caso de interrup��o
	 * inesperada, a execu��o continue onde parou.
	 * 
	 * @author rstargino
	 * 
	 **/

	@Test
	public void testaSAO() throws IOException {
		List<Consulta> codigos = defineListaCodigos();

		for (Consulta consulta : codigos) {
			String cdConsulta = consulta.getCodigo();

			page.acessaURL(ambiente.getUrlConsulta() + cdConsulta);

			page.esperaClasse("glossario-title");

			if (page.temErro("500 - Erro n�o esperado")) {
				page.tiraScreenshot(cdConsulta, " ERRO INESPERADO");
				page.escreveLog(cdConsulta, "codigos.txt");
				page.escreveErrado(cdConsulta, "errados.txt");
				continue;
			}

			try {
				page.esperaClasse("parametros-title");
				parametros.keySet().forEach(placeholder -> {
					try {
						page.escrevePlaceholder(placeholder, parametros.get(placeholder));
					} catch (NoSuchElementException e) {
						return;
					}
				});

				page.clicaBotaoClasse("botao-executar");

				if (page.temErro("Datasource n�o encontrado")) {
					page.tiraScreenshot(cdConsulta, " DATASOURCE N�O ENCONTRADO");
					page.escreveLog(cdConsulta, "codigos.txt");
					page.escreveErrado(cdConsulta, "errados.txt");
					continue;
				}
				if (page.temErro("Problemas para")) {
					page.tiraScreenshot(cdConsulta, "PROBLEMAS CONECTAR BANCO");
					page.escreveLog(cdConsulta, "codigos.txt");
					page.escreveErrado(cdConsulta, "errados.txt");
				}
			} catch (org.openqa.selenium.TimeoutException e) {
				if (page.temErro("Erro n�o esperado")) {
					page.tiraScreenshot(cdConsulta, "ERRO INESPERADO");
				}
				if (page.temErro("Problemas para")) {
					page.tiraScreenshot(cdConsulta, "PROBLEMAS CONECTAR BANCO");
				}
			}

			try {
				page.localizaMensagem("Esta consulta n�o retornou nenhum resultado");
			} catch (NoSuchElementException e) {
				System.out.println("Consulta " + cdConsulta + " falhou");
			}

			page.escreveLog(cdConsulta, "codigos.txt");

		}

	}

}
