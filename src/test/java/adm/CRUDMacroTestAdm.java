package adm;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTestMultiplosAdm;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CRUDMacroTestAdm extends BaseTestMultiplosAdm {

	@Test
	public void AcriarMacro() {
		page.acessaURL("https://saoadmhomologacao.trt13.jus.br/sao/administrativo/macros/cadastro");
		page.esperaClasse("mat-input-element");
		page.escrevePlaceholder("Nome", "MACRO_DE_TESTE");
		page.escrevePlaceholder("Valor", "Macro de teste");
		page.clicaBotaoXpath("/html/body/pje-app-root/div/ng-component/mat-card/form/mat-card-actions/button[2]");
		assertTrue(page.localizaMensagem("Registro salvo com sucesso"));

	}

	@Test
	public void BeditarMacro() {
		page.acessaURL("https://saoadmhomologacao.trt13.jus.br/sao/administrativo/macros");
		page.esperaClasse("ativar-filtros-crud");
		page.clicaBotaoClasse("ativar-filtros-crud");
		page.esperaClasse("mat-input-element");
		page.escreveId("mat-input-0", "MACRO_DE_TESTE");
		page.clicaBotaoClasse("botoes-acoes-filtro-crud");
		page.clicaBotaoXpath(
				"/html/body/pje-app-root/div/pje-macro-lista/mat-card[2]/mat-card-content/pje-data-table/div[1]/table/tbody[1]/tr/td[3]/div/a[1]");
		page.escreveId("mat-input-2", "MACRO_DE_TESTE_EDITADA");
		page.clicaBotaoXpath(
				"/html/body/pje-app-root/div/ng-component/mat-card/form/mat-card-actions/button[2]");
		assertTrue(page.localizaMensagem("Registro salvo com sucesso"));
		page.esperaClasse("ativar-filtros-crud");
		page.clicaBotaoClasse("ativar-filtros-crud");
		page.esperaClasse("mat-input-element");
		page.escreveId("mat-input-4", "MACRO_DE_TESTE_EDITADA");
		page.clicaBotaoClasse("botoes-acoes-filtro-crud");
		assertTrue(page.localizaMensagem("MACRO_DE_TESTE_EDITADA"));

	}

	@Test
	public void CexcluirMacros() {
		page.acessaURL("https://saoadmhomologacao.trt13.jus.br/sao/administrativo/macros");
		page.esperaClasse("ativar-filtros-crud");
		page.clicaBotaoClasse("ativar-filtros-crud");
		page.esperaClasse("mat-input-element");
		page.escreveId("mat-input-0", "MACRO_DE_TESTE_EDITADA");
		page.clicaBotaoClasse("botoes-acoes-filtro-crud");
		page.clicaBotaoClasse("botao-excluir-tabela-crud");
		page.esperaClasse("mat-dialog-title");
		page.clicaBotaoClasse("mat-raised-button");
		page.esperaClasse("mat-simple-snackbar");
		assertTrue(page.localizaMensagem("Registro excluído com sucesso"));
	}
}
