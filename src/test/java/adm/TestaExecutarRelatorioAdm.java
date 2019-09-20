package adm;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import core.BaseTestMultiplosAdm;

public class TestaExecutarRelatorioAdm extends BaseTestMultiplosAdm{

	@Test
	public void executarRelatorioTest() {
		page.acessaURL("https://saoadmhomologacao.trt13.jus.br/sao/execucao/1");
		page.esperaClasse("glossario-title");
		page.escrevePlaceholder("Mês", "06");
		page.escrevePlaceholder("Ano", "2019");
		page.clicaBotaoClasse("botao-executar");
		page.esperaClasse("th-container-class");
		page.clicaBotaoClasse("fa-file-pdf");
		page.esperaClasse("mat-simple-snackbar");		
		assertTrue(page.localizaMensagem("Download realizado com sucesso. Verifique sua pasta de downloads."));		
	}
}
