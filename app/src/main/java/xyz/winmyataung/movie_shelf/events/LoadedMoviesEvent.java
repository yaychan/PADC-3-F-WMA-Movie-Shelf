package xyz.winmyataung.movie_shelf.events;

import java.util.List;

import xyz.winmyataung.movie_shelf.data.vo.MoviesVO;

/**
 * Created by DELL on 1/4/2018.
 */

public class LoadedMoviesEvent {

    private List<MoviesVO> moviesList;

    public LoadedMoviesEvent (List<MoviesVO> moviesList){
        this.moviesList = moviesList;
    }

    public List<MoviesVO> getMoviesList() {
        return moviesList;
    }
}
