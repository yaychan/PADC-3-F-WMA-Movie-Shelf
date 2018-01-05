package xyz.winmyataung.movie_shelf.network.responses;

import java.util.List;

import xyz.winmyataung.movie_shelf.data.vo.MoviesVO;

/**
 * Created by DELL on 1/4/2018.
 */

public class GetMoviesResponses {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<MoviesVO> movies;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<MoviesVO> getMovies() {
        return movies;
    }
}
