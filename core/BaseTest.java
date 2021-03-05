package br.janaina.core;

import static br.janaina.core.DriverFactory.killDriver;

import org.junit.After;

public class BaseTest {

	@After
	public void finaliza() {
		if(Properties.FECHAR_BROWSER) {
			killDriver();
		}
	}
}
