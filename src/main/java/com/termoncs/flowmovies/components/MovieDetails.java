package com.termoncs.flowmovies.components;

import com.termoncs.flowmovies.models.Genre;
import com.termoncs.flowmovies.models.Movie;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.Key;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;
import com.vaadin.flow.shared.Registration;

public class MovieDetails extends VerticalLayout {

    private TextField name = new TextField("Name");
    private TextField director = new TextField("Director");
    private IntegerField year = new IntegerField("Year");
    private NumberField budget = new NumberField("Budget");
    private IntegerField duration = new IntegerField("Duration");
    private IntegerField rating = new IntegerField("Rating");
    private TextField posterUrl = new TextField("Poster");
    private ComboBox<Genre> genre = new ComboBox<>("Genre");
    private TextArea cast = new TextArea("Cast");
    private TextArea plot = new TextArea("Plot");
    private IntegerField earnings = new IntegerField("Earnings");

    private Image poster = new Image();

    private Button close = new Button("Close");
    private Button edit = new Button("Edit");
    private Button delete = new Button("Delete");

    private Movie movie;
    private Binder<Movie> binder;

    public MovieDetails() {

        binder = new Binder<>(Movie.class);
        binder.bindInstanceFields(this);

        configureView();

        add(poster, new FormLayout(name, director, year, budget, duration, rating, earnings, genre, cast, plot, createButtonsLayout() ));
    }

    private HorizontalLayout createButtonsLayout() {
        edit.addThemeVariants(ButtonVariant.LUMO_SUCCESS);
        delete.addThemeVariants(ButtonVariant.LUMO_ERROR);
        close.addThemeVariants(ButtonVariant.LUMO_TERTIARY);

        close.addClickShortcut(Key.ESCAPE);

        close.addClickListener(event -> exit());
        delete.addClickListener(event -> delete());
        edit.addClickListener(event -> edit());

        return new HorizontalLayout(close, edit, delete);
    }

    private void delete() {
        System.out.println("+++ Firing details delete event ++++");
        fireEvent(new MovieDetails.DeleteEvent(this, movie));
    }
    private void edit() {
        System.out.println("+++ Firing details edit event ++++");
        fireEvent(new MovieDetails.EditEvent(this, movie));
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
        this.poster.setSrc(movie.getPosterUrl());
        binder.readBean(movie);
    }

    private void configureView() {
        boolean readonly = true;
        this.setVisible(false);
        this.name.setReadOnly(readonly);
        this.director.setReadOnly(readonly);
        this.year.setReadOnly(readonly);
        this.budget.setReadOnly(readonly);
        this.duration.setReadOnly(readonly);
        this.rating.setReadOnly(readonly);
        this.genre.setReadOnly(readonly);
        this.posterUrl.setReadOnly(readonly);
        this.cast.setReadOnly(readonly);
        this.earnings.setReadOnly(readonly);
        this.plot.setReadOnly(readonly);
        this.poster.addClassName("image");
    }

    private void exit() {
        fireEvent(new CloseEvent(this));
        this.setVisible(false);
    }

    // Events
    public static abstract class MovieDetailsEvent extends ComponentEvent<MovieDetails> {
        private Movie movie;

        protected MovieDetailsEvent(MovieDetails source, Movie movie) {
            super(source, false);
            this.movie = movie;
        }

        public Movie getMovie() {
            return movie;
        }
    }
    public static class DeleteEvent extends MovieDetailsEvent {
        DeleteEvent(MovieDetails source, Movie movie) {
            super(source, movie);
        }
    }
    public static class EditEvent extends MovieDetailsEvent {
        EditEvent(MovieDetails source, Movie movie) {
            super(source, movie);
        }
    }
    public static class CloseEvent extends MovieDetailsEvent {
        CloseEvent(MovieDetails source) {
            super(source, null);
        }
    }

    public <T extends ComponentEvent<?>> Registration addListener(Class<T> eventType, ComponentEventListener<T> listener) {
        return getEventBus().addListener(eventType, listener);
    }


}

