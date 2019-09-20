package pages;

import core.BasePage;

public class LoginPagePje extends BasePage {

	public void acessaPaginaInicial(String urlPje) {

		acessaURL(urlPje);

	}

	public void setLogin(String idLogin, String login) {
		escreveLogin(idLogin, login);
	}

	public void setSenha(String idSenha, String senha) {
		escreveSenha(idSenha, senha);
	}

	public void entrar(String idBotao) {
		clicaBotaoId(idBotao);
	}

	public void logar(String idLogin, String login, String idSenha, String senha, String idBotao) {
		setLogin(idLogin, login);
		setSenha(idSenha, senha);
		entrar(idBotao);
	}

	public void entrarNoSAO(String urlSao) {
		acessaURL(urlSao);
		esperaCss("h4");
	}

}
