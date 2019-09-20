package pages;

import org.openqa.selenium.By;

import core.BasePage;
import core.DriverFactory;

public class MenuPage extends BasePage {

	public void clicaMenu() {		
		esperaXpath("/html/body/pje-app-root/div/pje-app-cabecalho/section/div/mat-toolbar/section[1]/pje-app-menu/div/button/span/i");
		DriverFactory.getDriver().findElement(By.xpath(
				"/html/body/pje-app-root/div/pje-app-cabecalho/section/div/mat-toolbar/section[1]/pje-app-menu/div/button/span/i"))
				.click();
	}
	
	
}
