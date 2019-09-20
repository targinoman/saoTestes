package core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Esta classe tem a função de atribuir linguagem de alto nível aos métodos do
 * Selenium
 * 
 * @author rstargino
 * 
 **/

public abstract class BasePage {

	private String itemMenu;
	private String itemSubMenu;
	private Consulta c;

	/*
	 * ================================= ACESSAR URL
	 * ==================================
	 */

	public void acessaURL(String url) {
		DriverFactory.getDriver().get(url);
	}

	public String recuperaURL() {
		return DriverFactory.getDriver().getCurrentUrl();
	}

	/*
	 * ================================= CAMPO DE TEXTO
	 * ==================================
	 */

	public void escreveId(String id, String texto) {
		DriverFactory.getDriver().findElement(By.id(id)).clear();
		DriverFactory.getDriver().findElement(By.id(id)).sendKeys(texto);
	}

	public void escrevePlaceholder(String placeholder, String texto) {
		DriverFactory.getDriver().findElement(By.xpath("//input[@placeholder='" + placeholder + "']")).clear();
		DriverFactory.getDriver().findElement(By.xpath("//input[@placeholder='" + placeholder + "']")).sendKeys(texto);
	}

	public void escreveCssSelector(String selector, String texto) {
		DriverFactory.getDriver().findElement(By.cssSelector(selector)).sendKeys(texto);
	}

	public void escreveClasse(String classe, String texto) {
		DriverFactory.getDriver().findElement(By.className(classe)).sendKeys(texto);
	}

	public void escreveLinkText(String linkText, String texto) {
		DriverFactory.getDriver().findElement(By.linkText(linkText)).sendKeys(texto);
	}

	public void escreveXpath(String xpath, String texto) {
		DriverFactory.getDriver().findElement(By.linkText(xpath)).sendKeys(texto);
	}

	/*
	 * ====================================== LOGIN
	 * ======================================
	 */

	public void escreveLogin(String id, String login) {
		DriverFactory.getDriver().findElement(By.id(id)).sendKeys(login);
	}

	public void escreveSenha(String id, String senha) {
		DriverFactory.getDriver().findElement(By.id(id)).sendKeys(senha);
	}

	/*
	 * ====================================== BOTÃO
	 * ======================================
	 */

	public void clicaBotaoId(String id) {
		DriverFactory.getDriver().findElement(By.id(id)).click();
	}

	public void clicaBotaoXpath(String xpath) {
		DriverFactory.getDriver().findElement(By.xpath(xpath)).click();
	}

	public void clicaBotaoClasse(String classeBotao) {
		DriverFactory.getDriver().findElement(By.className(classeBotao)).click();
	}

	public void clicaBotaoNome(String nomeBotao) {
		DriverFactory.getDriver().findElement(By.name(nomeBotao)).click();
	}

	/*
	 * ====================================== MENU
	 * ======================================
	 */

	public String getItemMenu() {
		return itemMenu;
	}

	public void setItemMenu(String itemMenu) {
		this.itemMenu = itemMenu;
	}

	public String getItemSubMenu() {
		return itemSubMenu;
	}

	public void setItemSubMenu(String itemSubMenu) {
		this.itemSubMenu = itemSubMenu;
	}

	public void acessaItemMenu(String itemMenu) {
		WebElement element = DriverFactory.getDriver().findElement(By.xpath(itemMenu));
		Actions action = new Actions(DriverFactory.getDriver());
		action.moveToElement(element).build().perform();
	}

	public void acessaItemDeSubmenu(String iTEM_SUB_MENU) {
		DriverFactory.getDriver().findElement(By.linkText(itemSubMenu)).click();
	}

	public void acessaMenu() {
		acessaItemMenu(getItemMenu());
		acessaItemDeSubmenu(getItemSubMenu());
	}

	/*
	 * ====================================== COMBO
	 * ======================================
	 */

	public void selecionaComboId(String id, int opcao) {
		WebElement element = DriverFactory.getDriver().findElement(By.id(id));
		Select combo = new Select(element);
		combo.selectByIndex(opcao);
	}

	/*
	 * ============================== MENSAGEM DE FALHA
	 * ===============================
	 */

	public String localizaMensagemXpath(String xpath) {
		return DriverFactory.getDriver().findElement(By.xpath(xpath)).getText();
	}

	public boolean localizaMensagem(String mensagem) {
		return DriverFactory.getDriver().getPageSource().contains(mensagem);
	}

	public boolean temErro(String mensagemErro) {
		return DriverFactory.getDriver().getPageSource().contains(mensagemErro);
	}

	/*
	 * ============================== MENSAGEM DE RETORNO
	 * ===============================
	 */

	public String localizaElemento(String xpath) {
		return DriverFactory.getDriver().findElement(By.xpath(xpath)).getText();
	}

	/*
	 * =========================== ESPERA PRESENÇA DE ELEMENTO
	 * ===========================
	 */

	public void esperaXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	}

	public void esperaCss(String css) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css)));
	}

	public void esperaTempo(long tempoSegundos) {
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(tempoSegundos, TimeUnit.SECONDS);
	}

	public void esperaClasse(String className) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.className(className)));
	}

	/* =========================== FAVORITO =========================== */
	public void clicaFavorito() {
		DriverFactory.getDriver()
				.findElement(By.xpath(
						"/html/body/pje-app-root/div/pje-app-execucao/div/div/div/div[3]/pje-app-favorito/a/span/i"))
				.click();
	}

	public boolean favoritoMarcado() {
		return DriverFactory.getDriver().getPageSource().contains("Remover este relatório dos favoritos");
	}

	public boolean favoritoDesmarcado() {
		return DriverFactory.getDriver().getPageSource().contains("Adicionar este relatório aos favoritos");
	}

	/*
	 * =========================== LOCALIZA CARD RELATÓRIO
	 * ===========================
	 */
	public void localizaCard(String xpathCard) {
		DriverFactory.getDriver().findElement(By.xpath(xpathCard)).click();
	}

	public void tiraScreenshot(String nomeArquivo, String complemento) throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(arquivo, new File(
				"target" + File.separator + "screenshot" + File.separator + nomeArquivo + " " + complemento + ".jpg"));
	}

	public void escreveLog(String codigo, String arquivo) throws IOException {
		List<Consulta> codigos = leLog();
		FileWriter fileR = new FileWriter(arquivo);
		BufferedWriter buff = new BufferedWriter(fileR);
		Consulta c = new Consulta();
		c.setCodigo(codigo);
		codigos.add(c);
		String texto = "";

		for (Consulta consulta : codigos) {
			texto = texto + consulta.getCodigo() + "\n";
		}

		try {
			buff.write(texto);
			buff.close();
		} catch (IOException ex) {
			Logger.getLogger(BaseTest.class.getName()).isLoggable(Level.SEVERE);
		}
	}

	public List<Consulta> leLog() throws IOException {
		FileReader fileR = new FileReader("codigos.txt");
		BufferedReader buff = new BufferedReader(fileR);
		List<Consulta> codigos = new ArrayList<Consulta>();
		while (buff.ready()) {
			String codigo = buff.readLine();
			c = new Consulta();
			c.setCodigo(codigo);
			codigos.add(c);
		}
		buff.close();
		return codigos;
	}

	public void escreveErrado(String codigo, String arquivo) throws IOException {
		List<Consulta> codigos = leErrado();
		FileWriter fileR = new FileWriter(arquivo);
		BufferedWriter buff = new BufferedWriter(fileR);
		Consulta c = new Consulta();
		c.setCodigo(codigo);
		codigos.add(c);
		String texto = "";

		for (Consulta consulta : codigos) {
			texto = texto + consulta.getCodigo() + "\n";
		}

		try {
			buff.write(texto);
			buff.close();
		} catch (IOException ex) {
			Logger.getLogger(BaseTest.class.getName()).isLoggable(Level.SEVERE);
		}
	}

	public List<Consulta> leErrado() throws IOException {
		FileReader fileR = new FileReader("errados.txt");
		BufferedReader buff = new BufferedReader(fileR);
		List<Consulta> codigos = new ArrayList<Consulta>();
		while (buff.ready()) {
			String codigo = buff.readLine();
			c = new Consulta();
			c.setCodigo(codigo);
			codigos.add(c);
		}
		buff.close();
		return codigos;
	}
}
