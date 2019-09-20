package pje;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTestMultiplosPje;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CRUDParametroTestPje extends BaseTestMultiplosPje {

	@Test
	public void AcriarParametro() {
		page.acessaURL("https://pjehomologacao.trt13.jus.br/sao/administrativo/parametros/cadastro");
		page.esperaClasse("mat-input-element");
		page.escrevePlaceholder("Nome", "PARAMETRO_TESTE");
		page.escrevePlaceholder("Label", "Label do Parâmetro de Teste");
		page.clicaBotaoXpath("/html/body/pje-app-root/div/ng-component/mat-card/form/mat-card-actions/button[2]");
		assertTrue(page.localizaMensagem("Registro salvo com sucesso"));
		System.out.println("teste");

	}

	@Test
	public void BeditarParametro() {
		page.acessaURL("https://pjehomologacao.trt13.jus.br/sao/administrativo/parametros");
		page.esperaClasse("ativar-filtros-crud");
		page.clicaBotaoClasse("ativar-filtros-crud");
		page.esperaClasse("mat-input-element");
		page.escreveId("mat-input-0", "PARAMETRO_TESTE");
		page.clicaBotaoClasse("botoes-acoes-filtro-crud");
		page.clicaBotaoXpath(
				"/html/body/pje-app-root/div/pje-parametro-lista/mat-card[2]/mat-card-content/pje-data-table/div[1]/table/tbody[1]/tr/td[5]/div/a[1]");
		page.escreveId("mat-input-2", "PARAMETRO_TESTE_EDITADO");
		page.clicaBotaoXpath(
				"/html/body/pje-app-root/div/ng-component/mat-card/form/mat-card-actions/button[2]");
		assertTrue(page.localizaMensagem("Registro salvo com sucesso"));
		page.clicaBotaoClasse("ativar-filtros-crud");
		page.esperaClasse("mat-input-element");
		page.escreveId("mat-input-6", "Label");
		page.clicaBotaoClasse("botoes-acoes-filtro-crud");
		assertTrue(page.localizaMensagem("PARAMETRO_TESTE_EDITADO"));

	}

	@Test
	public void CexcluirParametro() {
		page.acessaURL("https://pjehomologacao.trt13.jus.br/sao/administrativo/parametros");
		page.esperaClasse("ativar-filtros-crud");
		page.clicaBotaoClasse("ativar-filtros-crud");
		page.esperaClasse("mat-input-element");
		page.escreveId("mat-input-0", "PARAMETRO_TESTE_EDITADO");
		page.clicaBotaoClasse("botoes-acoes-filtro-crud");
		page.clicaBotaoClasse("botao-excluir-tabela-crud");
		page.esperaClasse("mat-dialog-title");
		page.clicaBotaoClasse("mat-raised-button");
		page.esperaClasse("mat-simple-snackbar");
		assertTrue(page.localizaMensagem("Registro excluído com sucesso"));
	}
}
