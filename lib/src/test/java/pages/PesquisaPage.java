package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import runner.RunCucumber;
import support.Utils;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

import static support.Commands.*;

public class PesquisaPage extends RunCucumber {

	private String URL = "https://blogdoagi.com.br/";
	private By lupa = By.id("search-open");
	private By Pesquisa = By.xpath("(//input[contains(@type,'search')])[1]");
	private By botaoPesquisa = By.xpath("(//input[@value='Pesquisar'])[1]");
	private String bodyText = "";

	public void acessarAplicacao() {
		getDriver("chrome").get(URL);
		getDriver().manage().window().maximize();
	}

	public void clicarLupa() {
		waitElementBeVisible(By.id("search-open"), 9000);
		clickElement(lupa);
	}

	public void inserirTextoCampoPesquisa(String pesquisa) {
		fillField(Pesquisa, pesquisa);

	}

	public void realizarPesquisa() {
		clickElement(botaoPesquisa);
	}

	public void validarPesquisa(String mensagem) throws IOException {
		WebElement body = getDriver().findElement(By.tagName("body"));
		bodyText = body.getText();
		boolean textoPresente = bodyText.contains(mensagem);
		if (textoPresente) {
			Utils.tiraPrint("Pesquisa");
		}
		getDriver().quit();

	}

}