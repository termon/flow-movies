//package com.termoncs.flowmovies.services;
//
//import com.termoncs.flowmovies.FlowApplication;
//import com.termoncs.flowmovies.models.Genre;
//import com.termoncs.flowmovies.models.Movie;
//import com.termoncs.flowmovies.models.Review;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//
//
//@Component
//public class ServiceSeeder {
//
//    @Autowired
//    private IMovieService service; // for movie seeding
//
//
//    org.slf4j.Logger logger = LoggerFactory.getLogger(FlowApplication.class);
//
//    /**
//     * The ContextRefreshedEvent is fired when the application has been totally bootstrapped and all bean objects have
//     * been instantiated. Then, we will use the Models and configured repositories to persist default data into the
//     * database. One crucial advantage of running the seeders when the ContextRefreshEvent is fired is that we get
//     * access to all auto-wired beans in the application — including repositories, services etc.
//     *
//     * @param event
//     */
//    @EventListener
//    public void seed(ContextRefreshedEvent event) {
//
//        logger.info("*********** +++ Seeding Database +++ **********");
//
//        service.deleteAllMovies();
//
//        var m1 = Movie.builder()
//                .name("The Shawshank Redemption")
//                .director("J Bloggs")
//                .budget(45.0)
//                .year(2007)
//                .rating(5)
//                .duration(140)
//                .posterUrl("https://image.tmdb.org/t/p/w1280/5KCVkau1HEl7ZzfPsKAPM0sMiKc.jpg")
//                .genre(Genre.ACTION)
//                .plot("plot")
//                .cast("Cast Shawshank")
//                .build();
//
//        var m2 = Movie.builder()
//                .name("The Terminator")
//                .director("James Cameron")
//                .budget(6.4)
//                .duration(108)
//                .year(1984)
//                .posterUrl("https://image.tmdb.org/t/p/w1280/qvktm0BHcnmDpul4Hz01GIazWPr.jpg")
//                .genre(Genre.SCI_FI)
//                .plot("In the post-apocalyptic future, reigning tyrannical supercomputers teleport a cyborg assassin known as the \"Terminator\" back to 1984 to kill Sarah Connor, whose unborn son is destined to lead insurgents against 21st century mechanical hegemony. Meanwhile, the human-resistance movement dispatches a lone warrior to safeguard Sarah. Can he stop the virtually indestructible killing machine?")
//                .cast("Arnold Schwarzenegger, Michael Bien, Linda Hamilton")
//                .build();
//
//        var m3 = Movie.builder()
//                .name("Jaws")
//                .director("Steven Speilberg")
//                .budget(7.0)
//                .duration(124)
//                .year(1975)
//                .posterUrl("https://image.tmdb.org/t/p/w1280/s2xcqSFfT6F7ZXHxowjxfG0yisT.jpg")
//                .genre(Genre.HORROR)
//                .plot("When an insatiable great white shark terrorizes the townspeople of Amity Island, the police chief, an oceanographer and a grizzled shark hunter seek to destroy the blood-thirsty beast.")
//                .cast("Cast Jaws")
//                .build();
//
//        var m4 = Movie.builder()
//                .name("The Cable Guy")
//                .director("Ben Stiller")
//                .budget(47.0)
//                .duration(96)
//                .year(1996)
//                .posterUrl("https://image.tmdb.org/t/p/w1280/5cZySBvy41eHTD5LyQn48aP444k.jpg")
//                .genre(Genre.COMEDY)
//                .plot("plot")
//                .cast("Cast Cable")
//                .build();
//
//        var m5 = Movie.builder()
//                .name("Alien")
//                .director("Ridley Scott")
//                .budget(190.0)
//                .duration(90)
//                .year(1979)
//                .duration(120)
//                .posterUrl("https://image.tmdb.org/t/p/w1280/vfrQk5IPloGg1v9Rzbh2Eg3VGyM.jpg")
//                .genre(Genre.SCI_FI)
//                .plot("plot")
//                .cast("Cast Alien")
//                .build();
//
//        var m6 = Movie.builder()
//                .name("Boo")
//                .genre(Genre.CHILDREN)
//                .director("Another")
//                .budget(100)
//                .duration(120)
//                .year(2019)
//                .posterUrl("https://image.tmdb.org/t/p/w1280/5Lnt9yuLlPwmYW3LLzWmQQWrUmK.jpg")
//                .genre(Genre.ROMANCE)
//                .plot("plot")
//                .cast("Cast Boo")
//                .build();
//
//        var m7 = Movie.builder()
//                .name("Terminator Dark Fate")
//                .director("Tim Miller")
//                .budget(185.0)
//                .duration(128)
//                .year(2019)
//                .posterUrl("https://image.tmdb.org/t/p/w1280/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg")
//                .genre(Genre.SCI_FI)
//                .plot("More than two decades have passed since Sarah Connor prevented Judgment Day, changed the future, and re-wrote the fate of the human race.")
//                .cast("Cast Terminator Dark Fate")
//                .build();
//
//        var m8 = Movie.builder()
//                .name("The Joker")
//                .director("Tim Miller")
//                .budget(55.0)
//                .duration(122)
//                .year(2019)
//                .posterUrl("https://image.tmdb.org/t/p/w1280/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg")
//                .genre(Genre.SCI_FI)
//                .plot("During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.")
//                .cast("Joaquin Phoenix").build();
//
//        service.addMovie(m1);
//        service.addReview( Review.builder().movie(m1).name("user1").comment("excellent").rating(5).build());
//        service.addReview( Review.builder().movie(m1).name("user2").comment("best Ever").rating(5).build());
//
//        service.addMovie(m2);
//        service.addReview( Review.builder().movie(m2).name("user3").comment("ground breaking").rating(5).build());
//
//        service.addMovie(m3);
//        service.addMovie(m4);
//        service.addMovie(m5);
//        service.addMovie(m6);
//        service.addReview( Review.builder().movie(m6).name("user3").comment("for children only").rating(2).build());
//        service.addMovie(m7);
//        service.addMovie(m8);
//
//    }
//}






package com.termoncs.flowmovies.services;

import com.termoncs.flowmovies.FlowmoviesApplication;
import com.termoncs.flowmovies.models.Genre;
import com.termoncs.flowmovies.models.Review;
import com.termoncs.flowmovies.models.Movie;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
public class ServiceSeeder {

    @Autowired
    private IMovieService service; // for movie seeding


    org.slf4j.Logger logger = LoggerFactory.getLogger(FlowmoviesApplication.class);

    /**
     * The ContextRefreshedEvent is fired when the application has been totally bootstrapped and all bean objects have
     * been instantiated. Then, we will use the Models and configured repositories to persist default data into the
     * database. One crucial advantage of running the seeders when the ContextRefreshEvent is fired is that we get
     * access to all auto-wired beans in the application — including repositories, services etc.
     *
     * @param event
     */
    @EventListener
    public void seed(ContextRefreshedEvent event) {

        logger.info("*********** +++ Seeding Database +++ **********");

        service.deleteAllMovies();

        var m1 = new Movie()
                //.setId(1)
                .setNameThen("The Shawshank Redemption")
                .setDirectorThen("J Bloggs")
                .setBudgetThen(45.0)
                .setYearThen(2007)
                .setRatingThen(5)
                .setEarningsThen(120000000)
                .setDurationThen(140)
                .setPosterUrlThen("https://image.tmdb.org/t/p/w1280/5KCVkau1HEl7ZzfPsKAPM0sMiKc.jpg")
                .setGenreThen(Genre.ACTION)
                .setPlotThen("plot")
                .setCastThen("Cast Shawshank");

        var m2 = new Movie()
                //.setId(2)
                .setNameThen("The Terminator")
                .setDirectorThen("James Cameron")
                .setBudgetThen(6.4)
                .setDurationThen(108)
                .setYearThen(1984)
                .setEarningsThen(75000000)
                .setPosterUrlThen("https://image.tmdb.org/t/p/w1280/qvktm0BHcnmDpul4Hz01GIazWPr.jpg")
                .setGenreThen(Genre.SCI_FI)
                .setPlotThen("In the post-apocalyptic future, reigning tyrannical supercomputers teleport a cyborg assassin known as the \"Terminator\" back to 1984 to kill Sarah Connor, whose unborn son is destined to lead insurgents against 21st century mechanical hegemony. Meanwhile, the human-resistance movement dispatches a lone warrior to safeguard Sarah. Can he stop the virtually indestructible killing machine?")
                .setCastThen("Arnold Schwarzenegger, Michael Bien, Linda Hamilton");

        var m3 = new Movie()
                //.setId(3)
                .setNameThen("Jaws")
                .setDirectorThen("Steven Speilberg")
                .setBudgetThen(7.0)
                .setDurationThen(124)
                .setYearThen(1975)
                .setEarningsThen(75000000)
                .setPosterUrlThen("https://image.tmdb.org/t/p/w1280/s2xcqSFfT6F7ZXHxowjxfG0yisT.jpg")
                .setGenreThen(Genre.HORROR)
                .setPlotThen("When an insatiable great white shark terrorizes the townspeople of Amity Island, the police chief, an oceanographer and a grizzled shark hunter seek to destroy the blood-thirsty beast.")
                .setCastThen("Cast Jaws");

        var m4 = new Movie()
               // .setId(4)
                .setNameThen("The Cable Guy")
                .setDirectorThen("Ben Stiller")
                .setBudgetThen(47.0)
                .setDurationThen(96)
                .setYearThen(1996)
                .setEarningsThen(175000000)
                .setPosterUrlThen("https://image.tmdb.org/t/p/w1280/5cZySBvy41eHTD5LyQn48aP444k.jpg")
                .setGenreThen(Genre.COMEDY)
                .setPlotThen("plot")
                .setCastThen("Cast Cable");

        var m5 = new Movie()
               // .setId(5)
                .setNameThen("Alien")
                .setDirectorThen("Ridley Scott")
                .setBudgetThen(190.0)
                .setDurationThen(90)
                .setYearThen(1979)
                .setEarningsThen(275000000)
                .setPosterUrlThen("https://image.tmdb.org/t/p/w1280/vfrQk5IPloGg1v9Rzbh2Eg3VGyM.jpg")
                .setGenreThen(Genre.SCI_FI)
                .setPlotThen("plot")
                .setCastThen("Cast Alien");

        var m6 = new Movie()
                //.setId(6)
                .setNameThen("Boo")
                .setGenreThen(Genre.CHILDREN)
                .setDirectorThen("Another")
                .setBudgetThen(100)
                .setYearThen(2019)
                .setDurationThen(120)
                .setEarningsThen(85000000)
                .setCastThen("Cast")
                .setPlotThen("plot")
                .setPosterUrlThen("https://image.tmdb.org/t/p/w1280/5Lnt9yuLlPwmYW3LLzWmQQWrUmK.jpg")
                .setGenreThen(Genre.ROMANCE)
                .setPlotThen("plot")
                .setCastThen("Cast Boo");

        var m7 = new Movie()
                //.setId(7)
                .setNameThen("Terminator Dark Fate")
                .setDirectorThen("Tim Miller")
                .setBudgetThen(185.0)
                .setDurationThen(128)
                .setYearThen(2019)
                .setEarningsThen(175000000)
                .setPosterUrlThen("https://image.tmdb.org/t/p/w1280/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg")
                .setGenreThen(Genre.SCI_FI)
                .setPlotThen("More than two decades have passed since Sarah Connor prevented Judgment Day, changed the future, and re-wrote the fate of the human race.")
                .setCastThen("Cast Terminator Dark Fate");

        var m8 = new Movie()
               // .setId(8)
                .setNameThen("The Joker")
                .setDirectorThen("Tim Miller")
                .setBudgetThen(55.0)
                .setDurationThen(122)
                .setYearThen(2019)
                .setEarningsThen(375000000)
                .setPosterUrlThen("https://image.tmdb.org/t/p/w1280/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg")
                .setGenreThen(Genre.SCI_FI)
                .setPlotThen("During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.")
                .setCastThen("Joaquin Phoenix");

        var m9 = new Movie()
                // .setId(8)
                .setNameThen("XXX")
                .setDirectorThen("Rob Cohen")
                .setBudgetThen(70.0)
                .setDurationThen(124)
                .setYearThen(2002)
                .setEarningsThen(280)
                .setPosterUrlThen("https://www.themoviedb.org/t/p/w1280/86BnliVDBo2TjKmrgQTJIPHxAKd.jpg")
                .setGenreThen(Genre.SCI_FI)
                .setPlotThen("Xander Cage is your standard adrenaline junkie with no fear and a lousy attitude. When the US Government \"recruits\" him to go on a mission, he's not exactly thrilled. His mission: to gather information on an organization that may just be planning the destruction of the world, led by the nihilistic Yorgi.")
                .setCastThen("Vin Diesel, Samuel L Jackson, Asia Argento");

        service.addMovie(m1);
        service.addReview(new Review().setMovieThen(m1).setNameThen("user1").setCommentThen("excellent").setRatingThen(5));
        service.addReview(new Review().setMovieThen(m1).setNameThen("user2").setCommentThen("best Ever").setRatingThen(5));

        service.addMovie(m2);
        service.addReview(new Review().setMovieThen(m2).setNameThen("user3").setCommentThen("ground breaking").setRatingThen(5));

        service.addMovie(m3);
        service.addMovie(m4);
        service.addMovie(m5);
        service.addMovie(m6);
        service.addReview(new Review().setMovieThen(m6).setNameThen("user3").setCommentThen("for children only").setRatingThen(2));
        service.addMovie(m7);
        service.addMovie(m8);
        service.addMovie(m9);

    }
}
