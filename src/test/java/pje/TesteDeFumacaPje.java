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
 * Teste de fumaça para descobrir quais consultas estão sendo montadas
 * corretamente e quais não estão. Ao executar a classe como teste do JUnit será
 * solicitado no console em qual ambiente ele será executado
 * 
 * 1 - SaoPJe Homologação | 2 - SaoPJe Bugfix | 3 - SaoPje Adm
 * 
 * Este método está na classe Ambiente do pacote core
 * 
 * @author rstargino
 * 
 **/

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TesteDeFumacaPje extends BaseTestPje {

	private Map<String, String> parametros = page.carregaParametros();

	List<Consulta> errados = new ArrayList<Consulta>();

	/**
	 * Este teste captura os códigos de consulta no banco do ambiente selecionado e
	 * executa todos eles capturado mensagens de erro ou sucesso. Caso a consulta
	 * não seja executada corretamente, o código da consulta é salvo no arquivo
	 * errados.txt e é tirado um printscreen da tela. O arquivo será salvo em
	 * target/screenshot. Além disso, à medida que as consultas são executadas, seus
	 * códigos são salvos no arquivo códigos.txt para que, no caso de interrupção
	 * inesperada, a execução continue onde parou.
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

			if (page.temErro("500 - Erro não esperado")) {
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

				if (page.temErro("Datasource não encontrado")) {
					page.tiraScreenshot(cdConsulta, " DATASOURCE NÃO ENCONTRADO");
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
				if (page.temErro("Erro não esperado")) {
					page.tiraScreenshot(cdConsulta, "ERRO INESPERADO");
				}
				if (page.temErro("Problemas para")) {
					page.tiraScreenshot(cdConsulta, "PROBLEMAS CONECTAR BANCO");
				}
			}

			try {
				page.localizaMensagem("Esta consulta não retornou nenhum resultado");
			} catch (NoSuchElementException e) {
				System.out.println("Consulta " + cdConsulta + " falhou");
			}

			page.escreveLog(cdConsulta, "codigos.txt");

		}

	}

}
