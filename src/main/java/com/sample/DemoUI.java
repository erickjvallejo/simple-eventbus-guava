package com.sample;

import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;

@SpringUI
@Title("Mi Titulo")
public class DemoUI extends UI {

    //My Google Event Bus
    private EventBus eventBus;

    //My registered event 
    @Subscribe
    public void logout(LogoutEvent logoutEvent) {

        Notification.show("Closing session from EventBus", Notification.Type.ERROR_MESSAGE);
    }

    @Override
    protected void init(VaadinRequest request) {
        //Creating my BusEvent
        setupEventBus(); 
        
        //Calling my form
        setContent(new MyForm());

    }

    private void setupEventBus() {
        eventBus = new EventBus((thrwbl, subscriberExceptionContext) -> {
            thrwbl.printStackTrace();
        });
        eventBus.register(this);
    }

    public static DemoUI getCurrent() {
        return (DemoUI) UI.getCurrent();
    }
    
    public static EventBus getEventBus() {
        return getCurrent().eventBus;
    }

}
