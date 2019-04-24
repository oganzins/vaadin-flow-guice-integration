package com.intelmodus.guice;

import javax.servlet.annotation.WebServlet;

import com.vaadin.flow.function.DeploymentConfiguration;
import com.vaadin.flow.server.ServiceException;
import com.vaadin.flow.server.VaadinServlet;
import com.vaadin.flow.server.VaadinServletConfiguration;
import com.vaadin.flow.server.VaadinServletService;

@WebServlet(urlPatterns = "/*", name = "guice-vaadin-servlet", asyncSupported = true)
@VaadinServletConfiguration(productionMode = false)
public class GuiceVaadinServlet extends VaadinServlet {

	@Override
	protected VaadinServletService createServletService(DeploymentConfiguration configuration) throws ServiceException {
		GuiceVaadinServletService service = new GuiceVaadinServletService(this, configuration);
		service.init();
		return service;
	}

}
