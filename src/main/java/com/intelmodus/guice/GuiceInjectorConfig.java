package com.intelmodus.guice;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.inject.Injector;

public abstract class GuiceInjectorConfig implements ServletContextListener {

	static final String INJECTOR_NAME = Injector.class.getName();

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.setAttribute(INJECTOR_NAME, createInjector());
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {
		ServletContext servletContext = servletContextEvent.getServletContext();
		servletContext.removeAttribute(INJECTOR_NAME);
	}

	protected abstract Injector createInjector();
}