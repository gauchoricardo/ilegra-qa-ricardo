package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.PesquisaPage;
import runner.RunCucumber;
import java.io.IOException;

public class PesquisaStep extends RunCucumber {

	PesquisaPage pesquisaPage = new PesquisaPage();

	@Dado("^que realizei o acesso ao blog agi$")
	public void que_estou_na_página_inicial_do_blog_agi() {
		pesquisaPage.acessarAplicacao();
	}

	@Quando("^insiro o texto no campo pesquisa \"([^\"]*)\"$")
	public void preencho_algum_texto_no_campo_pesquisa(String pesquisa) {
		pesquisaPage.clicarLupa();
		pesquisaPage.inserirTextoCampoPesquisa(pesquisa);
	}

	@Quando("^clico em pesquisar$")
	public void pesquisar() throws Exception {
		pesquisaPage.realizarPesquisa();
	}

	@Então("^o resultado deverá coincidir com o texto digitado \"([^\"]*)\"$")
	public void resultadoPositivo(String mensagem) throws IOException {
		pesquisaPage.validarPesquisa(mensagem);
	}

	@Então("^o resultado deve ser Nenhum resultado \"([^\"]*)\"$")
	public void resultadoNegativo(String mensagem) throws Exception {
		pesquisaPage.validarPesquisa(mensagem);

	}
}