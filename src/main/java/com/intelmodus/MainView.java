package com.intelmodus;

import javax.inject.Inject;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("")
public class MainView extends VerticalLayout {

	@Inject
	MainView(ClickMeButton button) {
		add(button);
	}
}
