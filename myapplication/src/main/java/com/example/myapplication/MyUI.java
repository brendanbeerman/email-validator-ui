package com.example.myapplication;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        
        final TextField emailTextField = new TextField();
        emailTextField.setCaption("Enter the email here: ");

        Button submitButton = new Button("Validate email");
        submitButton.addClickListener( e -> {
        	Validator validator = new Validator(emailTextField.getValue());
        	
        	String lableText = (validator.getIsValidEmail()) ? ("Email is valid") : ("Email is not valid");
        	Label messageLable = new Label(lableText);
        	
            layout.addComponent(messageLable);
        });
        
        layout.addComponents(emailTextField, submitButton);
        layout.setMargin(true);
        layout.setSpacing(true);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
