package adm;

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
	CRUDRelatorioTestAdm.class,
	CRUDParametroTestAdm.class,
	CRUDMenuTestAdm.class,
	CRUDMacroTestAdm.class,
	CRUDDatasourceTestAdm.class
})
public class SuiteAdminAdm {

}
