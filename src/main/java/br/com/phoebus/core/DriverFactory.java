package br.com.phoebus.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.java.Before;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/* Nesta classe ser�o utilizados padr�es Factory Method
 * e Singleton para centralizar a cria��o e garantir que todos
 * recebam a mesma inst�ncia  
 * */
public class DriverFactory {
	
	private static AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
			createDriver();
		}
		return driver;
	}

	@Before("@appium")
	private static void createDriver() {
		/* 
		 * Abaixo est�o as Capabilities: 
		 * Informa��es passadas como objeto JSON para realizar as requisi��es e 
		 * estabelecer a comunica��o com o dispositivo
		 * */
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    // N�m. serial do Terminal utilizado para Testes. N�o � indispens�vel, por�m, � interessante o uso. 
	    desiredCapabilities.setCapability("deviceName", "0820481941"); 
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appActivity", "br.com.phoebus.android.payments.ui.activity.PaymentActivity");
	    desiredCapabilities.setCapability("appActivity", "br.com.phoebus.android.payments.ui.activity.InitializationActivity");
	    desiredCapabilities.setCapability("appPackage", "br.com.phoebus.paystore.payments.paxA920");
	    try {
	    // AndroidDriver: Meio pelo qual ser� estabelecida a comunica��o (driver) 
	    driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
	    } catch (MalformedURLException e){
	    	e.printStackTrace();
	    	
	    }
	    //Espera impl�cita do dispositivo (medida de seguran�a)
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static void killDriver() {
		if(driver != null) {
			driver.quit();
			driver = null;
		}
	}
	
}

