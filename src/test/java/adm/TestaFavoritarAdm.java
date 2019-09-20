package adm;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTestMultiplosAdm;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestaFavoritarAdm extends BaseTestMultiplosAdm {

	@Test
	public void favoritosTest() {
		page.acessaURL("https://saoadmhomologacao.trt13.jus.br/sao/execucao/1");
		page.esperaClasse("glossario-title");
		page.clicaFavorito();
		assertTrue(page.favoritoMarcado());
		page.clicaFavorito();
		page.esperaClasse("mat-raised-button");
		page.clicaBotaoClasse("mat-raised-button");
		page.esperaClasse("nao-favorita");
		assertTrue(page.favoritoDesmarcado());
	}
}
