package br.com.phoebus.page;

//import static br.com.phoebus.core.DriverFactory.getDriver;
import br.com.phoebus.core.BasePage;
import io.appium.java_client.MobileElement;

public class CalculadoraPage extends BasePage{

	public void acessarCalculadora() {
		clicarPorID("toggle_calculator");
	}

	public boolean conferirGaveta() {
		return existeElementoPorID("operator_pad");
	}

	public boolean conferirBotaoIgual() {
		return existeElementoPorID("btn_equals");
	}

	public void clicarIgual() {
		clicarPorID("btn_equals");
	}

	public MobileElement checarResultado() {
		return obterTextoPorID("result");
	}
	
}
