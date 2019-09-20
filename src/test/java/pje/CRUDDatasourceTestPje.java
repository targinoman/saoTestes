package pje;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTestMultiplosPje;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CRUDDatasourceTestPje extends BaseTestMultiplosPje {

	@Test
	public void AcriarDatasource() {
		page.acessaURL("https://pjehomologacao.trt13.jus.br/sao/administrativo/datasources/cadastro");
		page.esperaClasse("mat-input-element");
		page.escrevePlaceholder("Nome", "DATASOURCE-DE-TESTE");
		page.escrevePlaceholder("Descrição", "Datasource criado por teste automatizado");
		page.clicaBotaoClasse("mat-select");		
		page.clicaBotaoId("mat-option-1");
		page.clicaBotaoXpath("/html/body/pje-app-root/div/ng-component/mat-card/form/mat-card-actions/button[2]");
		assertTrue(page.localizaMensagem("Registro salvo com sucesso"));

	}

	@Test
	public void BeditarDatasource() {
		page.acessaURL("https://pjehomologacao.trt13.jus.br/sao/administrativo/datasources");
		page.esperaClasse("ativar-filtros-crud");
		page.clicaBotaoClasse("ativar-filtros-crud");
		page.esperaClasse("mat-input-element");
		page.escreveId("mat-input-0", "DATASOURCE-DE-TESTE");
		page.clicaBotaoClasse("botoes-acoes-filtro-crud");
		page.clicaBotaoXpath(
				"/html/body/pje-app-root/div/pje-datasource-lista/mat-card[2]/mat-card-content/pje-data-table/div[1]/table/tbody[1]/tr/td[5]/div/a[1]");
		page.escreveId("mat-input-2", "DATASOURCE-DE-TESTE-EDITADO");
		page.clicaBotaoXpath(
				"/html/body/pje-app-root/div/ng-component/mat-card/form/mat-card-actions/button[2]");
		assertTrue(page.localizaMensagem("Registro salvo com sucesso"));
		page.acessaURL("https://pjehomologacao.trt13.jus.br/sao/administrativo/datasources");
		page.esperaClasse("ativar-filtros-crud");
		page.clicaBotaoClasse("ativar-filtros-crud");
		page.esperaClasse("mat-input-element");
		page.escreveId("mat-input-0", "DATASOURCE-DE-TESTE-EDITADO");
		page.clicaBotaoClasse("botoes-acoes-filtro-crud");
		assertTrue(page.localizaMensagem("DATASOURCE-DE-TESTE-EDITADO"));

	}

	@Test
	public void CexcluirDatasource() {
		page.acessaURL("https://pjehomologacao.trt13.jus.br/sao/administrativo/datasources");
		page.esperaClasse("ativar-filtros-crud");
		page.clicaBotaoClasse("ativar-filtros-crud");
		page.esperaClasse("mat-input-element");
		page.escreveId("mat-input-0", "DATASOURCE-DE-TESTE-EDITADO");
		page.clicaBotaoClasse("botoes-acoes-filtro-crud");
		page.clicaBotaoClasse("botao-excluir-tabela-crud");
		page.esperaClasse("mat-dialog-title");
		page.clicaBotaoClasse("mat-raised-button");
		page.esperaClasse("mat-simple-snackbar");
		assertTrue(page.localizaMensagem("Registro excluído com sucesso"));
	}
}
