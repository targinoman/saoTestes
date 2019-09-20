package pje;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Su�te de testes das fun��es de Administrador
 * Os testes ser�o executados no ambiente de Homologa��o do PJe
 * 
 * @author rstargino
 * 
 **/

@RunWith(Suite.class)
@SuiteClasses({
	CRUDRelatorioTestPje.class,
	CRUDParametroTestPje.class,
	CRUDMenuTestPje.class,
	CRUDMacroTestPje.class,
	CRUDDatasourceTestPje.class
})
public class SuiteAdminPje {

}
