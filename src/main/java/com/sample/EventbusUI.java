package com.sample;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Button;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import javax.annotation.PreDestroy;

@SpringUI
@Title("Mi Eventbus with Guava")
public class EventbusUI extends UI {

    //My Guava Eventbus
    private EventBus eventBus;

    @Override
    protected void init(VaadinRequest request) {
        //Creating my BusEvent
        setupEventBus();

        Button button = new Button("Logout");
        button.addClickListener((event) -> {

            this.eventBus.post(new LogoutEvent());
        });

        setContent(button);

    }

    //My registered event 
    @Subscribe
    public void logout(LogoutEvent logoutEvent) {

        Notification.show("Closing session from Guava EventBus", Notification.Type.ERROR_MESSAGE);
    }

    private void setupEventBus() {
        eventBus = new EventBus((thrwbl, subscriberExceptionContext) -> {
            thrwbl.printStackTrace();
        });
        eventBus.register(this);
    }

    @PreDestroy
    public void destroy() {
        eventBus.unregister(this);
    }

}
