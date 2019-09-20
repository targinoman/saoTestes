package core;

import java.util.HashMap;
import java.util.Map;

public class BasePageAdm extends BasePage implements Parametrizavel {

	private Map<String, String> placeholdersParaValores = new HashMap<String, String>();

	@Override
	public Map<String, String> carregaParametros() {
		placeholdersParaValores.put("Matr�cula", "123");
		placeholdersParaValores.put("Matricula", "123");
		placeholdersParaValores.put("M�s", "05");
		placeholdersParaValores.put("Dia", "32");
		placeholdersParaValores.put("Setor no SUAP", "99");
		placeholdersParaValores.put("Subsetor Suap", "99");
		placeholdersParaValores.put("Lota��o", "99");
		placeholdersParaValores.put("Login", "aaaa");
		placeholdersParaValores.put("Sigla Lota��o Sigep", "99");
		placeholdersParaValores.put("Ano", "1990");
		placeholdersParaValores.put("1 - Lista de Tombos (separados por v�rgula)", "1111");
		placeholdersParaValores.put("1 - Nome da Localidade", "99");
		placeholdersParaValores.put("Setor", "99");
		placeholdersParaValores.put("Nome", "aaaaa");

		return placeholdersParaValores;

	}

}
