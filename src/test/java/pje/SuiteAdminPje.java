package pje;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * Suíte de testes das funções de Administrador
 * Os testes serão executados no ambiente de Homologação do PJe
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
