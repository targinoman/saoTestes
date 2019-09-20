package adm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suíte de testes das funções de Usuário
 * Os testes serão executados no ambiente de Homologação do PJe
 * 
 * @author rstargino
 * 
 **/

@RunWith(Suite.class)
@SuiteClasses({
	TestaFavoritarAdm.class,
	TestaPesquisarAdm.class,
	TestaExecutarRelatorioAdm.class
})
public class SuiteUsuarioAdm {

}
