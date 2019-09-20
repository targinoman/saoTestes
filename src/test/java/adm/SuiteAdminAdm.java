package adm;

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
	CRUDRelatorioTestAdm.class,
	CRUDParametroTestAdm.class,
	CRUDMenuTestAdm.class,
	CRUDMacroTestAdm.class,
	CRUDDatasourceTestAdm.class
})
public class SuiteAdminAdm {

}
