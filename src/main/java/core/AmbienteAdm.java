package core;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import pages.LoginPageAdm;

/**
 * Esta classe configura o ambiente de execução dos testes de fumaça do SAO
 * 
 * 1 - SaoPJe Homologação | 2 - SaoPJe Bugfix | 3 - SaoPje Adm
 * 
 * Baseado na opção informada o sistema lerá o arquivo de configurações
 * correspondente para acessar o banco de dados e as urls do SAO
 * 
 * @author rstargino
 * 
 **/

public class AmbienteAdm {

	private String urlBanco;
	private String usuarioBanco;
	private String senhaBanco;
	private String loginAdm;
	private String senhaAdm;
	private String urlSao;
	private String urlConsulta;

//	private String arquivo;

	public int ambiente;

	public LoginPageAdm login;

//	public String selecionaAmbiente() {
//		System.out.println("Selecione o ambiente de execução: 1 - SaoPJe Homologação | 2 - SaoPJe Bugfix | 3 - SaoPje Adm");
//
//		Scanner scanner = new Scanner(System.in);
//		ambiente = scanner.nextInt();
//		scanner.close();
//
//		switch (ambiente) {
//		case 1:
//			arquivo = "saopjehomologacao.properties";
//			break;
//		case 2:
//			arquivo = "saopjebugfix.properties";
//			break;
//		case 3:
//			arquivo = "saopjeadm.properties";
//			break;
//		default:
//			System.out.println("Opção inválida");
//		}
//		return arquivo;
//	}

	public Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream("./properties/saoadmhomologacao.properties");
		props.load(file);
		file.close();
		return props;
	}

	public void configuraAmbiente() throws IOException {

		Properties prop = getProp();
		this.urlBanco = prop.getProperty("prop.urlBanco");
		this.usuarioBanco = prop.getProperty("prop.usuarioBanco");
		this.senhaBanco = prop.getProperty("prop.senhaBanco");
		this.loginAdm = prop.getProperty("prop.loginAdm");
		this.senhaAdm = prop.getProperty("prop.senhaAdm");
		this.urlSao = prop.getProperty("prop.urlSao");
		this.urlConsulta = prop.getProperty("prop.urlConsulta");

	}

	public String getUrlBanco() {
		return urlBanco;
	}

	public String getUsuarioBanco() {
		return usuarioBanco;
	}

	public String getSenhaBanco() {
		return senhaBanco;
	}

	public String getLoginAdm() {
		return loginAdm;
	}

	public String getSenhaAdm() {
		return senhaAdm;
	}

	public String getUrlSao() {
		return urlSao;
	}

	public String getUrlConsulta() {
		return urlConsulta;
	}
}
