package com.termoncs.flowmovies.components;

import com.termoncs.flowmovies.models.Genre;
import com.termoncs.flowmovies.models.Movie;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.*;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

public class MovieForm  extends FormLayout {
    public enum Mode { EDIT, CREATE, HIDDEN }

    private TextField name = new TextField("Name");
    private TextField director = new TextField("Director");
    private IntegerField year = new IntegerField("Year");
    private NumberField budget = new NumberField("Budget");
    private IntegerField duration = new IntegerField("Duration");
    private IntegerField rating = new IntegerField("Rating");
    private TextField posterUrl = new TextField("Poster");
    private ComboBox<Genre> genre = new ComboBox<>("Genre");
    private TextField cast = new TextField("Cast");
    private TextField plot = new TextField("Plot");
    private IntegerField earnings = new IntegerField("Earnings");

    private Button save = new Button("Save");
    private Button cancel = new Button("Cancel");

    private Mode mode; // form mode

    // movie being edited and binder connecting movie to form
    private Movie movie;
    private BeanValidationBinder<Movie> binder;

    public MovieForm() {
        setMode(Mode.HIDDEN);
        genre.setItems(Genre.values());
        binder = new BeanValidationBinder<>(Movie.class);
        binder.bindInstanceFields(this);
        add(name, director, year, budget, duration, rating, genre, posterUrl, cast, plot, earnings,
            createButtonsLayout()
        );
    }

    public Mode getMode() { return mode; }
    private void setMode(Mode m) {
        this.mode = m;
        if (this.mode == Mode.HIDDEN) {
            setVisible(false);
        } else {
            setVisible(true);
        }
    }

    public Movie getMovie() { return movie; }
    private void setMovie(Movie movie) {
        this.movie = movie;
        binder.readBean(movie);
    }

    // set form model and edit mode
    public void setState(Movie movie, Mode m) {
        setMode(m);
        setMovie(movie);
        // optionally change save button label
        //save.setText( getMode() == Mode.CREATE ? "Create" : "Save");
    }

    private HorizontalLayout createButtonsLayout() {
        save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        cancel.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        save.addClickShortcut(Key.ENTER);
        cancel.addClickShortcut(Key.ESCAPE);

        save.addClickListener(event -> validateAndSave());
        cancel.addClickListener(event -> exit());

        binder.addStatusChangeListener(e -> save.setEnabled(binder.isValid()));
        return new HorizontalLayout(save, cancel);
    }

    private void exit() {
        fireEvent(new CloseEvent(this));
    }

    private void validateAndSave() {
        try {
            binder.writeBean(movie);
            // save movie here OR fire event to be caught higher up chain
            System.out.println("+++ Firing Save event " + mode + " +++ " + movie);
            fireEvent(new SaveEvent(this, movie, mode));
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }

    // Events
    public static abstract class MovieFormEvent extends ComponentEvent<MovieForm> {
        private Movie movie;
        private Mode mode;

        protected MovieFormEvent(MovieForm source, Movie movie, Mode mode) {
            super(source, false);
            this.movie = movie;
            this.mode = mode;
        }

        public Movie getMovie() {
            return movie;
        }
        public Mode getMode() { return mode; }
    }

    public static class SaveEvent extends MovieFormEvent {
        SaveEvent(MovieForm source, Movie movie, Mode mode) {
            super(source, movie, mode);
        }
    }
    public static class CloseEvent extends MovieFormEvent {
        CloseEvent(MovieForm source) {
            super(source, null, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType, ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }
}

