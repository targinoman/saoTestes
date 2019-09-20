package adm;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.Keys;

import core.BaseTestMultiplosAdm;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CRUDRelatorioTestAdm extends BaseTestMultiplosAdm {

	@Test
	public void AcriarRelatorio() {
		page.acessaURL("https://saoadmhomologacao.trt13.jus.br/sao/administrativo/consultas/cadastro");
		page.esperaClasse("mat-step-label");
		page.escrevePlaceholder("Título", "Consulta de Teste");
		page.escrevePlaceholder("Código", "TE01");
		page.escrevePlaceholder("Nome no Menu", "Consulta de Teste" + Keys.TAB + Keys.ARROW_DOWN + Keys.ENTER);
		page.escreveCssSelector("textarea", "Glossário da Consulta de Teste");
		page.clicaBotaoId("cdk-step-label-0-1");
		page.esperaTempo(1);
		page.clicaBotaoId("mat-select-0");
		page.clicaBotaoId("mat-option-1");
		page.escreveClasse("mat-chip-input", "administrador");
		page.clicaBotaoId("mat-option-12");
		page.clicaBotaoId("cdk-step-label-0-2");
		page.escreveId("mat-input-4", "SELECT * FROM tb_consulta");
		page.clicaBotaoXpath(
				"/html/body/pje-app-root/div/ng-component/mat-card/mat-horizontal-stepper/div[2]/div[3]/form/mat-card-actions/button[2]");
		assertTrue(page.localizaMensagem("Registro salvo com sucesso"));
		System.out.println("teste");

	}

	@Test
	public void BeditarRelatorio() {
		page.acessaURL("https://saoadmhomologacao.trt13.jus.br/sao/administrativo/consultas/");
		page.esperaClasse("ativar-filtros-crud");
		page.clicaBotaoClasse("ativar-filtros-crud");
		page.esperaClasse("mat-input-element");
		page.escreveId("mat-input-0", "consulta de teste");
		page.clicaBotaoClasse("botoes-acoes-filtro-crud");
		page.clicaBotaoXpath(
				"/html/body/pje-app-root/div/pje-consulta-lista/mat-card[2]/mat-card-content/pje-data-table/div[1]/table/tbody[1]/tr/td[4]/div/a[1]");
		page.escrevePlaceholder("Título", "Consulta de Teste EDITADA");
		page.clicaBotaoId("cdk-step-label-0-1");
		page.esperaTempo(1);
		page.clicaBotaoId("mat-select-2");
		page.clicaBotaoId("mat-option-6");
		page.clicaBotaoId("mat-select-3");
		page.clicaBotaoId("mat-option-10");
		page.clicaBotaoId("cdk-step-label-0-2");
		page.clicaBotaoXpath(
				"/html/body/pje-app-root/div/ng-component/mat-card/mat-horizontal-stepper/div[2]/div[3]/form/mat-card-actions/button[2]");
		assertTrue(page.localizaMensagem("Registro salvo com sucesso"));
		page.clicaBotaoClasse("ativar-filtros-crud");
		page.esperaClasse("mat-input-element");
		page.escreveId("mat-input-9", "TE01");
		page.clicaBotaoClasse("botoes-acoes-filtro-crud");
		assertTrue(page.localizaMensagem("Consulta de Teste EDITADA"));
		System.out.println("teste");

	}
	
	@Test
	public void CexcluirRelatorio() {
		page.acessaURL("https://saoadmhomologacao.trt13.jus.br/sao/administrativo/consultas/");
		page.esperaClasse("ativar-filtros-crud");
		page.clicaBotaoClasse("ativar-filtros-crud");
		page.esperaClasse("mat-input-element");
		page.escreveId("mat-input-0", "consulta de teste");
		page.clicaBotaoClasse("botoes-acoes-filtro-crud");
		page.clicaBotaoClasse("botao-excluir-tabela-crud");
		page.esperaClasse("mat-dialog-title");
		page.clicaBotaoClasse("mat-raised-button");
		page.esperaClasse("mat-simple-snackbar");
		assertTrue(page.localizaMensagem("Registro excluído com sucesso"));
	}
}
