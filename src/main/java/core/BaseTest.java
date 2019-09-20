package core;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

import pages.LoginPageAdm;

/**
 * Esta superclasse contém métodos que serão utilizados por todas as classes de
 * testes como @Before e @After escrita e leitura de arquivos
 * 
 * @author rstargino
 * 
 **/

public abstract class BaseTest {

	protected BasePagePje page = new BasePagePje();

	protected LoginPageAdm loginPage = new LoginPageAdm();

	@Rule
	public TestName testName = new TestName();

	@Before
	public abstract void inicializa() throws IOException;

	@After
	public void finaliza() {
		if (Propriedades.FECHAR_BROWSER) {
			DriverFactory.killDriver();
		}
	}

	public void avaliaElemento(String xpath) {
		String elemento = loginPage.localizaElemento(xpath);
		assertNotNull(elemento);
		System.out.println(elemento);
	}

	public void avaliaMensagem(String xpath) {
		String mensagem = loginPage.localizaMensagemXpath(xpath);
		assertNotNull(mensagem);
	}

}
