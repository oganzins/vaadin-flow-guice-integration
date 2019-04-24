package com.intelmodus;

import javax.inject.Inject;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;

public class ClickMeButton extends Button {

	@Inject
	ClickMeButton() {
		super("Click me", event -> Notification.show("Clicked!"));
	}

}
