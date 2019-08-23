package steps;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;

import br.com.phoebus.page.CalculadoraPage;
import br.com.phoebus.page.InicializacaoPage;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;


public class Calculadora {
	
//	private AndroidDriver<MobileElement> driver;
	
	private CalculadoraPage calculadora = new CalculadoraPage(); 
	private InicializacaoPage inicializacao = new InicializacaoPage();
	
	@Dado("^que execute a aplicação PayStore$")
	public void que_execute_a_aplicação_PayStore() throws Throwable {
		inicializacao.inicializarTerminal();
		inicializacao.naoRecuperarTransacoes();
		inicializacao.informaSenhaSupervisor("000000");

		assertEquals("000000", inicializacao.obterTextoPorID("password"));

	}

	@Dado("^caso aplicação já esteja executada$")
	public void caso_aplicação_já_esteja_executada() throws Throwable {
		calculadora.existeElementoPorID("action_bar_root");
	}

	@Quando("^acessar o icone Calculadora$")
	public void acessar_o_icone_Calculadora() throws Throwable {
		calculadora.acessarCalculadora();
	}

	@Então("^deve ser apresentado a gaveta$")
	public void deve_ser_apresentado_a_gaveta() throws Throwable {
		Assert.assertTrue(calculadora.conferirGaveta());
	}

	@Dado("^que tecle o número \"([^\"]*)\"$")
	public void que_tecle_o_número(String n1) throws Throwable {
		n1 = "btn_eight";
		calculadora.clicarPorID(n1);
	}

	@Dado("^que tecle a função matemática \"([^\"]*)\"$")
	public void que_tecle_a_função_matemática(String fm) throws Throwable {
		fm = "btn_add";
		calculadora.clicarPorID(fm);
	}

	@Quando("^teclar o botão igual$")
	public void teclar_o_botão_igual() throws Throwable {
		calculadora.conferirBotaoIgual();
		calculadora.clicarIgual();
	}

	@Então("^deve ser apresentado o valor \"([^\"]*)\"$")
	public void deve_ser_apresentado_o_valor(String n2) throws Throwable {
		n2 = "R$ 8,00";
		Assert.assertEquals(n2,calculadora.checarResultado());
	}
	
}
