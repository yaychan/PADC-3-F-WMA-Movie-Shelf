package xyz.winmyataung.movie_shelf.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import xyz.winmyataung.movie_shelf.R;
import xyz.winmyataung.movie_shelf.data.vo.MoviesVO;
import xyz.winmyataung.movie_shelf.delegates.MoviesActionDelegates;
import xyz.winmyataung.movie_shelf.viewholders.ItemMoviesViewHolder;


/**
 * Created by DELL on 12/7/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter<ItemMoviesViewHolder> {

    private MoviesActionDelegates mMoviesActionDelegates;

    private List<MoviesVO> mMoviesList;

    public MoviesAdapter(MoviesActionDelegates moviesActionDelegates){
        mMoviesActionDelegates = moviesActionDelegates;

        mMoviesList = new ArrayList<>();
    }
    @Override
    public ItemMoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View moviesView=inflater.inflate(R.layout.item_movies,parent,false);
        ItemMoviesViewHolder MoviesViewHolder=new ItemMoviesViewHolder(moviesView,mMoviesActionDelegates);
        return MoviesViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemMoviesViewHolder holder, int position) {
        holder.setMovies(mMoviesList.get(position));
    }

    @Override
    public int getItemCount() {

        return mMoviesList.size();
    }

    public void setMovies(List<MoviesVO> moviesList){

    mMoviesList=moviesList;
    notifyDataSetChanged();
    }
}
