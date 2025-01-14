package colections.exercitii.ex20IMDBclone;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Imdb {

    List<Movie> movies;

    public Imdb(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public List<Movie> getAllMoviesByGenre(Genre genre) {
        List<Movie> genreMovies = new ArrayList<>();
        for (Movie movie : movies) {
            //daca genul movi-ului curent este egal cu cel care vine ca parametru
            if (movie.getGenre().equals(genre)){
                genreMovies.add(movie);
            }
        }
        return genreMovies;
    }

    public Map<Genre, List<Movie>> groupAllMoviesByGenre() {
        Map<Genre, List<Movie>> moviesByGenre = new HashMap<>();
        for (Movie movie: movies){
            if (!moviesByGenre.containsKey(movie.getGenre())){
                //punem in mapa o noua pereche : ca si cheie genul filmului curent, ca si valoare o lista care contine filmul curent
                List<Movie> moviesValue = new ArrayList<>();
                moviesValue.add(movie);
                moviesByGenre.put(movie.getGenre(), moviesValue);
            } else{
                //adaugam in mapa filmul curent la lista de filme de la cheia genul filmului
                //Genre key = movie.getGenre();
                //List<Movie> list = moviesByGenre.get(key);
                //list.add(movie);
                moviesByGenre.get(movie.getGenre())    .add(movie);
            }
        }
        return moviesByGenre;
    }

    public List<Actor> findAllActorsByTypeAndGenre(Type type, Genre genre) {
        return null;
    }

    public Actor findMostPopularActor (){
        //pentru fiecare actor de la fiecare film
        Map<Actor,Integer> actorPlayFrequency = generateActorPlayFrequency();
        return getActorWithMostPlays(actorPlayFrequency);
    }

    public Map<Actor,Integer> generateActorPlayFrequency(){
        Map<Actor, Integer> actorPlayFrequency = new HashMap<>();
        for (Movie movie: movies){
            for (Actor actor: movie.getCast()) {
                if (!actorPlayFrequency.containsKey(actor)) {
                    actorPlayFrequency.put(actor, 1);
                } else {
                    //adaugam 1 la valoarea cheii actor curent
                    actorPlayFrequency.put(actor, actorPlayFrequency.get(actor) + 1);
                }
            }
        }
        return actorPlayFrequency;
    }

    public Actor getActorWithMostPlays(Map<Actor,Integer> actorPlayFrequency ) {
        int max = 0;
        Actor mostPopularActor = null;
        for(Actor actor: actorPlayFrequency.keySet()){
            if (actorPlayFrequency.get(actor) > max){
                max = actorPlayFrequency.get(actor);
                mostPopularActor = actor;
            }
        }
        return mostPopularActor;
    }
}

