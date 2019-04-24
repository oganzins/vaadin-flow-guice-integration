package com.intelmodus;

import javax.servlet.annotation.WebListener;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.intelmodus.guice.GuiceInjectorConfig;

@WebListener
public class InjectorConfig extends GuiceInjectorConfig {

	@Override
	protected Injector createInjector() {
		return Guice.createInjector(new MainModule());
	}
}
