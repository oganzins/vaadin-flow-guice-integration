package com.intelmodus.guice;

import java.util.stream.Stream;

import com.google.inject.Injector;
import com.vaadin.flow.di.DefaultInstantiator;
import com.vaadin.flow.di.Instantiator;
import com.vaadin.flow.i18n.I18NProvider;
import com.vaadin.flow.server.VaadinService;
import com.vaadin.flow.server.VaadinServiceInitListener;

class GuiceInstantiator implements Instantiator {

	private DefaultInstantiator defaultInstantiator;

	private final Injector injector;

	GuiceInstantiator(Injector injector) {
		this.injector = injector;
	}

	@Override
	public boolean init(VaadinService service) {
		defaultInstantiator = new DefaultInstantiator(service);
		return defaultInstantiator.init(service)
				&& service instanceof GuiceVaadinServletService;
	}

	@Override
	public Stream<VaadinServiceInitListener> getServiceInitListeners() {
		return defaultInstantiator.getServiceInitListeners();
	}

	@Override
	public <T> T getOrCreate(Class<T> aClass) {
		return injector.getInstance(aClass);
	}

	@Override
	public I18NProvider getI18NProvider() {
		return defaultInstantiator.getI18NProvider();
	}
}
