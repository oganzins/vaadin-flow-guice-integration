package com.intelmodus;

import com.google.inject.AbstractModule;

public class MainModule extends AbstractModule {

	@Override
	protected void configure() {
		bind(MainView.class);
		bind(ClickMeButton.class);
	}

}
