package xyz.winmyataung.movie_shelf.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.winmyataung.movie_shelf.R;
import xyz.winmyataung.movie_shelf.viewholders.itemNewsViewHolder;



/**
 * Created by DELL on 12/7/2017.
 */

public class MoviesAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context=parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View moviesView=inflater.inflate(R.layout.movies_list,parent,false);
        itemNewsViewHolder MoviesViewHolder=new itemNewsViewHolder(moviesView);
        return MoviesViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 16;
    }
}
