package com.termoncs.flowmovies.pages;

import com.termoncs.flowmovies.models.ToDo;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import java.util.Arrays;
import java.util.List;

@Route(value="/todos", layout = MainLayout.class)
public class ToDoView extends Div {

    public ToDoView() {
        TextField taskField = new TextField();
        Button addButton = new Button("Add");

        VerticalLayout todosList = new VerticalLayout();

        addButton.addClickListener(click -> {
            Checkbox checkbox = new Checkbox(taskField.getValue());
            checkbox.addClickListener( (e) -> todosList.remove(e.getSource()));
            todosList.add(checkbox);
            taskField.clear();
        });
        addButton.addClickShortcut(Key.ENTER);

        add(
                new H4("Vaadin Todo"),
                todosList,
                new HorizontalLayout(
                        taskField,
                        addButton
                )
        );
    }
}

