package adm;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Su�te de testes das fun��es de Usu�rio
 * Os testes ser�o executados no ambiente de Homologa��o do PJe
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
