package adm;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTestMultiplosAdm;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CRUDMenuTestAdm extends BaseTestMultiplosAdm {

	@Test
	public void AcriarMenu() {
		page.acessaURL("https://saoadmhomologacao.trt13.jus.br/sao/administrativo/menus/cadastro");
		page.esperaClasse("mat-input-element");
		page.escrevePlaceholder("Nome", "Menu de Teste");
		page.clicaBotaoXpath("/html/body/pje-app-root/div/ng-component/mat-card/form/mat-card-actions/button[2]");
		assertTrue(page.localizaMensagem("Registro salvo com sucesso"));

	}

	@Test
	public void BeditarMenu() {
		page.acessaURL("https://saoadmhomologacao.trt13.jus.br/sao/administrativo/menus");
		page.esperaClasse("ativar-filtros-crud");
		page.clicaBotaoClasse("ativar-filtros-crud");
		page.esperaClasse("mat-input-element");
		page.escreveId("mat-input-0", "Menu de Teste");
		page.clicaBotaoClasse("botoes-acoes-filtro-crud");
		page.clicaBotaoXpath(
				"/html/body/pje-app-root/div/pje-menu-gerencia/pje-menu-lista/mat-card/mat-card-content/pje-data-table/div[1]/table/tbody[1]/tr/td[3]/div/a[1]");
		page.escreveId("mat-input-1", "Menu de Teste EDITADO");
		page.clicaBotaoXpath(
				"/html/body/pje-app-root/div/ng-component/mat-card/form/mat-card-actions/button[2]");
		assertTrue(page.localizaMensagem("Registro salvo com sucesso"));
		page.acessaURL("https://saoadmhomologacao.trt13.jus.br/sao/administrativo/menus");
		page.esperaClasse("ativar-filtros-crud");
		page.clicaBotaoClasse("ativar-filtros-crud");
		page.esperaClasse("mat-input-element");
		page.escreveId("mat-input-0", "Menu de Teste EDITADO");
		page.clicaBotaoClasse("botoes-acoes-filtro-crud");
		assertTrue(page.localizaMensagem("Menu de Teste EDITADO"));

	}

	@Test
	public void CexcluirMenu() {
		page.acessaURL("https://saoadmhomologacao.trt13.jus.br/sao/administrativo/menus");
		page.esperaClasse("ativar-filtros-crud");
		page.clicaBotaoClasse("ativar-filtros-crud");
		page.esperaClasse("mat-input-element");
		page.escreveId("mat-input-0", "Menu de Teste EDITADO");
		page.clicaBotaoClasse("botoes-acoes-filtro-crud");
		page.clicaBotaoClasse("botao-excluir-tabela-crud");
		page.esperaClasse("mat-dialog-title");
		page.clicaBotaoClasse("mat-raised-button");
		page.esperaClasse("mat-simple-snackbar");
		assertTrue(page.localizaMensagem("Registro excluído com sucesso"));
	}
}
