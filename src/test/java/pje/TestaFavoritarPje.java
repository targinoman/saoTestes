package pje;

import static org.junit.Assert.assertTrue;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import core.BaseTestMultiplosPje;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestaFavoritarPje extends BaseTestMultiplosPje {

	@Test
	public void favoritosTest() {
		page.acessaURL("https://pjehomologacao.trt13.jus.br/sao/execucao/C888");
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
