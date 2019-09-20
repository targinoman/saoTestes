package pje;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.openqa.selenium.Keys;

import core.BaseTestMultiplosPje;

public class TestaPesquisarPje extends BaseTestMultiplosPje {

	
	@Test
	public void pesquisarTest() {
		page.escrevePlaceholder("Buscar Relatório", "Expedientes Distribuídos" + Keys.ARROW_DOWN + Keys.ENTER);
		assertEquals("https://pjehomologacao.trt13.jus.br/sao/execucao/CT01", page.recuperaURL());
		
	}
}
