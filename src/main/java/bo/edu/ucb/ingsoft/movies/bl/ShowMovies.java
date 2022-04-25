package bo.edu.ucb.ingsoft.movies.bl;

import bo.edu.ucb.ingsoft.movies.dto.MovieList;
import java.util.ArrayList;
import java.util.List;

public class ShowMovies {

    public ShowMovies() {
    }

    public List<MovieList> findmovies(Long chatId) {
        List<MovieList> result = new ArrayList<>();
        result.add(new MovieList("1. Star Wars"));
        result.add(new MovieList("2. Mad Max"));
        result.add(new MovieList("3. El Padrino"));
        result.add(new MovieList("4. Scarface"));
        return result;
    }
}

