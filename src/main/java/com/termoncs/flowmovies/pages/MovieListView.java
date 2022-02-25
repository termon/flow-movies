package com.termoncs.flowmovies.pages;

import com.termoncs.flowmovies.components.MovieDetails;
import com.termoncs.flowmovies.components.MovieForm;
//import com.termoncs.flowmovies.components.MovieListComponent;
import com.termoncs.flowmovies.models.Movie;
import com.termoncs.flowmovies.services.IMovieService;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.TemplateRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@Route(value = "movies", layout = MainLayout.class)
public class
MovieListView extends VerticalLayout {

    @Autowired
    private IMovieService service;
    private MovieForm form;
    private MovieDetails details;
    private Grid<Movie> grid;
    private Button create;

    //private Button createButton;

    // service not available in the page constructor
    public MovieListView() {}

    @PostConstruct
    public void init() {

        // movie view component
        details = new MovieDetails();
        //details.setVisible(false);
        details.addListener(MovieDetails.CloseEvent.class, e -> details.setVisible(false) );
        details.addListener(MovieDetails.DeleteEvent.class, e -> handleDeleteEvent(e));
        details.addListener(MovieDetails.EditEvent.class, e -> handleEditEvent(e));

        // movie form component
        form = new MovieForm();
        //form.setVisible(false);
        form.addListener(MovieForm.CloseEvent.class, e -> form.setVisible(false) );
        form.addListener(MovieForm.SaveEvent.class, e -> handleSaveEvent(e) );

        // movie list component
        grid = new Grid<>();
        grid.setItems(service.getMovies());
        grid.setSelectionMode(Grid.SelectionMode.SINGLE);
        grid.addColumn(createAvatarRenderer()).setHeader("Image").setAutoWidth(true).setFlexGrow(0);
        grid.addColumn(Movie::getName).setHeader("Title").setSortable(true);
        grid.addColumn(Movie::getYear).setHeader("Year").setSortable(true);
        grid.addColumn(Movie::getBudget).setHeader("Budget").setSortable(true);
        grid.addColumn(Movie::getDirector).setHeader("Director").setSortable(true);
        grid.addColumn(Movie::getRating).setHeader("Rating").setSortable(true);

        // grid select movie
        grid.addSelectionListener(e -> e.getFirstSelectedItem().ifPresent( m -> {
            this.details.setMovie(m);
            this.details.setVisible(true);
        }));

        // add components to layout
        add( new Button("Create", e -> createMovie()),
             new H4("Movie List"),
             grid,  details, form
        );
    }

    private void createMovie() {
        details.setVisible(false);
        form.setState(new Movie(), MovieForm.Mode.CREATE);
    }

    // Form Event Handlers
    private void handleEditEvent(MovieDetails.EditEvent e) {
        // hide details component
        details.setVisible(false);
        // enable form using event movie and set form to edit mode
        form.setState(e.getMovie(), MovieForm.Mode.EDIT);
    }

    private void handleDeleteEvent(MovieDetails.DeleteEvent e) {
        // hide details panel
        details.setVisible(false);

        // delete movie via call to service
        service.deleteMovieById(e.getMovie().getId());

        // refresh grid
        grid.setItems(service.getMovies());

        // display notification
        Notification notification = Notification.show("Movie Deleted!");
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    }

    private void handleSaveEvent(MovieForm.SaveEvent e) {
        // hide form
        form.setVisible(false);

        // determine form mode and call appropriate service
        if (e.getMode() == MovieForm.Mode.EDIT) {
            service.updateMovie(e.getMovie());
        } else {
            service.addMovie(e.getMovie());
        }

        // refresh grid
        grid.setItems(service.getMovies());

        // display notification
        String msg = e.getMode() == MovieForm.Mode.EDIT ? "Movie Changes Saved!" : "New Movie Added!";
        Notification notification = Notification.show( msg );
        notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    }

    private static TemplateRenderer<Movie> createAvatarRenderer() {
        return TemplateRenderer.<Movie>of(
                        "<vaadin-avatar img=\"[[item.pictureUrl]]\" name=\"[[item.fullName]]\" alt=\"Movie avatar\"></vaadin-avatar>")
                .withProperty("pictureUrl", Movie::getPosterUrl)
                .withProperty("fullName", Movie::getName);
    }


//grid.setItemDetailsRenderer(createMovieDetailsRenderer());

// component navigation (button)
// RouterLink router = new RouterLink();
// router.add("Create");
// router.setRoute(MovieCreateView.class);

// internal grid row viewer
//    private static ComponentRenderer<MovieGridDetails, Movie> createMovieDetailsRenderer() {
//        return new ComponentRenderer<>(
//                MovieGridDetails::new,
//                MovieGridDetails::setMovie);
//    }

// programmatic navigation
// UI.getCurrent().navigate("/movies");
}

