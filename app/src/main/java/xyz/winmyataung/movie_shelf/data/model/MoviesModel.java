package xyz.winmyataung.movie_shelf.data.model;

import xyz.winmyataung.movie_shelf.network.HttpUrlConnectionDataAgent;
import xyz.winmyataung.movie_shelf.network.MoviesDataAgent;

/**
 * Created by DELL on 1/5/2018.
 */

public class MoviesModel {

    private static MoviesModel sObjInstance;                    // s = static

    private MoviesDataAgent mDataAgent;

    private MoviesModel(){

        mDataAgent = HttpUrlConnectionDataAgent.getObjInstance();

    }
    public static MoviesModel getObjInstance(){
        if(sObjInstance==null){                              //factory logic
            sObjInstance=new MoviesModel();
        }
        return sObjInstance;
    }
    /*
    load news from network api
    */
    public void loadMovies(){
        mDataAgent.loadMovies();

    }
}
