package core;

import java.util.HashMap;
import java.util.Map;

public class BasePagePje extends BasePage implements Parametrizavel {

	private Map<String, String> placeholdersParaValores = new HashMap<String, String>();

	@Override
	public Map<String, String> carregaParametros() {
		placeholdersParaValores.put("Data Inicial", "01051900");
		placeholdersParaValores.put("Data Final", "30051900");
		placeholdersParaValores.put("Central de Mandados", "99");
		placeholdersParaValores.put("Oficial de justiça", "99");
		placeholdersParaValores.put("Órgão Julgador", "99");
		placeholdersParaValores.put("Orgão Colegiado", "99");
		placeholdersParaValores.put("Classe Processual", "99");
		placeholdersParaValores.put("Magistrado", "99");
		placeholdersParaValores.put("Agrupar por", "1");
		placeholdersParaValores.put("Tarefa", "99");
		placeholdersParaValores.put("Dias", "5");
		placeholdersParaValores.put("Nº Processo", "123");
		placeholdersParaValores.put("CPF/CNPJ", "99999999999");
		placeholdersParaValores.put("Nome da parte", "aaaaa");
		placeholdersParaValores.put("Situação do Débito", "99");
		placeholdersParaValores.put("Nome do usuário responsável", "aaaaa");
		placeholdersParaValores.put("Município", "99");
		placeholdersParaValores.put("Indicador de Distribuição", "99");
		placeholdersParaValores.put("Área de Zoneamento", "99");
		placeholdersParaValores.put("Distribuição/Redistribuição", "99");
		placeholdersParaValores.put("Tipo de Distribuição/Redistribuição", "99");
		placeholdersParaValores.put("Assunto do processo", "99");
		placeholdersParaValores.put("Tipo de Sobrestamento", "99");
		placeholdersParaValores.put("Fase Processual", "99");
		placeholdersParaValores.put("Chip (etiqueta)", "99");
		placeholdersParaValores.put("Nome do advogado", "aaaaaa");
		placeholdersParaValores.put("Situação", "123");
		placeholdersParaValores.put("CPF", "99999999999");
		placeholdersParaValores.put("Assunto", "123");
		placeholdersParaValores.put("Parte do CPF/CNPJ", "123");
		placeholdersParaValores.put("Data inicial", "01051900");
		placeholdersParaValores.put("Data final", "30051900");
		placeholdersParaValores.put("Estado", "PB");
		placeholdersParaValores.put("Letra", "A");
		placeholdersParaValores.put("Número", "1");
		placeholdersParaValores.put("Central Suap", "99");
		placeholdersParaValores.put("Setor Suap", "99");
		placeholdersParaValores.put("CODIGO ASSUNTO", "aaaaa");

		return placeholdersParaValores;

	}

}
