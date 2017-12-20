package xyz.winmyataung.movie_shelf.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.winmyataung.movie_shelf.R;
import xyz.winmyataung.movie_shelf.delegates.MoviesActionDelegates;

/**
 * Created by DELL on 12/3/2017.
 */

public class itemNewsViewHolder extends RecyclerView.ViewHolder {

    private MoviesActionDelegates mMoviesActionDelegates;

    public itemNewsViewHolder(View itemView, MoviesActionDelegates moviesActionDelegates) {

        super(itemView);

        ButterKnife.bind(this,itemView);

        mMoviesActionDelegates = moviesActionDelegates;

    }
    @OnClick(R.id.cv_movies_item)
    public void onTapMoviesItem(View view){
        mMoviesActionDelegates.onTapMoviesItem();
    }

}
