/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

/**
 *
 * @author erick
 */
public class MyForm extends VerticalLayout {

    public MyForm() {

        Button button = new Button("Logout");
        button.addClickListener((event) -> {
            EventBus.post(new LogoutEvent());
        });

        addComponent(button);

    }

}
