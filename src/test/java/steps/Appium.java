package steps;

import static br.com.phoebus.core.DriverFactory.getDriver;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Appium {
	
	private AndroidDriver<MobileElement> driver;
	
	public Appium() {
		this.driver = getDriver();
	}
	
	@Dado("que inicialize")
	public void que_inicialize() {
	    
	}

	@Dado("acesse pagamentos")
	public void acesse_pagamentos() {
	    
	}

	@Quando("acessar o ícone da calculadora")
	public void acessar_o_ícone_da_calculadora() {
	    
	}

	@Então("a gaveta deve ser exibida")
	public void a_gaveta_deve_ser_exibida() {
	    
	}
}
