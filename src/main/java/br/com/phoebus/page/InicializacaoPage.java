package br.com.phoebus.page;

import br.com.phoebus.core.BasePage;
import io.appium.java_client.MobileBy;

public class InicializacaoPage extends BasePage {

	public void inicializarTerminal() {
		clicarPorID("start_initialization");
	}

	public void naoRecuperarTransacoes() {
		clicarPorID("md_buttonDefaultNegative");
	}

	public void informaSenhaSupervisor(String text) {
		escrever(MobileBy.AccessibilityId("br.com.phoebus.paystore.payments.paxA920:id/password"), text);
	}
}
