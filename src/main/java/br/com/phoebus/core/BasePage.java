package br.com.phoebus.core;

import static br.com.phoebus.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class BasePage {

//	public void escrever(By by, CharSequence[] text) {
//		// Write string or number's [int] (return 'Mobile Element' type)
//		getDriver().findElement(by).sendKeys(text);
//	}

	public void escrever(By by, String text) {
		// Escrever nome (O retorno desse m�todo ser� uma inst�ncia de 'Mobile Element')
		getDriver().findElement(by).sendKeys(text);
	}

	public void clicarPorID(String id) {
		getDriver().findElement(MobileBy.AccessibilityId("br.com.phoebus.paystore.payments.paxA920:id/" + id)).click();
	}

	public boolean existeElementoPorID(String id) {
		List<MobileElement> elementos = getDriver()
				.findElements(MobileBy.AccessibilityId("br.com.phoebus.paystore.payments.paxA920:id/" + id));
		return elementos.size() > 0;
	}

	public MobileElement obterTextoPorID(String id) {
		return getDriver().findElement(MobileBy.AccessibilityId("br.com.phoebus.paystore.payments.paxA920:id/" + id));
	}

	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}

	public void acaoClique(By by) {
		getDriver().findElement(by).click();
	}

	public void comboSelect(By by, String value) {
		// Clicar na Combo
		getDriver().findElement(by).click();
		clicarPorTexto(value);
	}

	public void clicarPorTexto(String text) {
		// Selecionar Op��o desejada
		acaoClique(By.xpath("//*[@text='" + text + "']"));
	}

	public boolean isCheckMarked(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	}

	public boolean existeElementoPorTexto(String text) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='" + text + "']"));
		return elementos.size() > 0;
	}

	// RESOLVER ISSO!!!!
	public void tap(int x, int y) {
		new TouchAction(getDriver()).tap(PointOption.point(x, y)).perform();
//		AndroidTouchAction action = new AndroidTouchAction(getDriver());
//		action.tap(PointOption.point(x,y)).perform();
	}

	public void scrollDown() {
		scroll(0.9, 0.1);
	}

	public void scrollUp() {
		scroll(0.1, 0.9);
	}

	public void swipeLeft() {
		swipe(0.1, 0.9);
	}

	public void swipeRight() {
		swipe(0.9, 0.1);
	}

	public void scroll(double start, double finish) {
		Dimension size = getDriver().manage().window().getSize();

		int x = size.width / 2;

		int start_y = (int) (size.height * start);
		int end_y = (int) (size.height * finish);

		new TouchAction(getDriver()).press(PointOption.point(x, start_y))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(x, end_y))
				.release().perform();

	}

	public void swipe(double start, double finish) {
		Dimension size = getDriver().manage().window().getSize();

		int y = size.height / 2;

		int start_x = (int) (size.width * start);
		int end_x = (int) (size.width * finish);

		new TouchAction(getDriver()).press(PointOption.point(start_x, y))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(end_x, y))
				.release().perform();
	}

	public void swipeElement(MobileElement element, double start, double finish) {
		int y = element.getLocation().y + (element.getSize().height / 2);

		int start_x = (int) (element.getSize().width * start);
		int end_x = (int) (element.getSize().width * finish);

		new TouchAction(getDriver()).press(PointOption.point(start_x, y))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(end_x, y))
				.release().perform();
	}

	public String verificarTituloAlertaConfirm() {
		return obterTexto(By.id("android:id/alertTitle"));
	}

	public String verificarMsgAlertaConfirm() {
		return obterTexto(By.id("android:id/message"));
	}

	public void longClick(By by) {
		new TouchAction(getDriver()).longPress(ElementOption.element(getDriver().findElement(by))).perform();
	}

}
