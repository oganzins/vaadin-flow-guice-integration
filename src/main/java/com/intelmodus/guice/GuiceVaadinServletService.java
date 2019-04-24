package com.intelmodus.guice;

import javax.servlet.ServletContext;

import com.google.inject.Injector;
import com.vaadin.flow.di.Instantiator;
import com.vaadin.flow.function.DeploymentConfiguration;
import com.vaadin.flow.server.VaadinServletService;

class GuiceVaadinServletService extends VaadinServletService {

	private final GuiceVaadinServlet servlet;

	GuiceVaadinServletService(GuiceVaadinServlet servlet, DeploymentConfiguration configuration) {
		super(servlet, configuration);
		this.servlet = servlet;
	}

	@Override
	protected Instantiator createInstantiator() {
		GuiceInstantiator instantiator = new GuiceInstantiator(injector());
		instantiator.init(this);
		return instantiator;
	}

	private Injector injector() {
		ServletContext servletContext = servlet.getServletContext();
		return (Injector) servletContext.getAttribute(GuiceInjectorConfig.INJECTOR_NAME);
	}

}
