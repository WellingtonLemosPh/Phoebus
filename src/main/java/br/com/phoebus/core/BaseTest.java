package br.com.phoebus.core;

import static br.com.phoebus.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;

public class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	@AfterClass
	public static void finalizarClasse() {
		DriverFactory.killDriver();
	}
	
	@After
	public void tearDown() {
		screenShotGenerate();
		getDriver().resetApp();
	}
	
	public void screenShotGenerate() {
		File imagem = DriverFactory.getDriver().getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(imagem, new File("target/screenshot/"+testName.getMethodName()+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void eseperar(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}