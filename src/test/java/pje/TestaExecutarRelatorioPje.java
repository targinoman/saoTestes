package pje;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import core.BaseTestMultiplosPje;

public class TestaExecutarRelatorioPje extends BaseTestMultiplosPje{

	@Test
	public void executarRelatorioTest() {
		page.acessaURL("https://pjehomologacao.trt13.jus.br/sao/execucao/N980");
		page.esperaClasse("glossario-title");
		page.escrevePlaceholder("Data inicial", "01052018");
		page.escrevePlaceholder("Data final", "31052018");
		page.clicaBotaoClasse("botao-executar");
		page.esperaClasse("th-container-class");
		page.clicaBotaoClasse("fa-file-pdf");
		page.esperaClasse("mat-simple-snackbar");		
		assertTrue(page.localizaMensagem("Download realizado com sucesso. Verifique sua pasta de downloads."));		
	}
}
