package adm;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.Keys;

import core.BaseTestMultiplosAdm;

public class TestaPesquisarAdm extends BaseTestMultiplosAdm {

	
	@Test
	public void pesquisarTest() {
		page.escrevePlaceholder("Buscar Relatório", "Impressões por Setor" + Keys.ARROW_DOWN + Keys.ENTER);
		assertEquals("https://saoadmhomologacao.trt13.jus.br/sao/execucao/1", page.recuperaURL());
		
	}
}
