package xyz.winmyataung.movie_shelf.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.winmyataung.movie_shelf.R;
import xyz.winmyataung.movie_shelf.data.vo.MoviesVO;
import xyz.winmyataung.movie_shelf.delegates.MoviesActionDelegates;

/**
 * Created by DELL on 12/3/2017.
 */

public class ItemMoviesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.iv_movie_poster)
    ImageView ivMoviePoster;

    @BindView(R.id.tv_movie_title)
    TextView tvMovieTitle;

    @BindView(R.id.tv_movie_genre)
    TextView tvMovieGenre;

    @BindView(R.id.tv_vote_average)
    TextView tvVoteAverage;



    private MoviesActionDelegates mMoviesActionDelegates;

    public ItemMoviesViewHolder(View itemView, MoviesActionDelegates moviesActionDelegates) {

        super(itemView);

        ButterKnife.bind(this, itemView);

        mMoviesActionDelegates = moviesActionDelegates;

    }

    @OnClick(R.id.cv_movies_item)
    public void onTapMoviesItem(View view) {
        mMoviesActionDelegates.onTapMoviesItem();
    }

    public void setMovies(MoviesVO movies){
        tvMovieTitle.setText(movies.getTitle());
      /*  tvMovieGenre.setText(String.valueOf(movies.getGenreIds()));
        tvVoteAverage.setText(String.valueOf(movies.getVoteAverage()));*/

        Glide.with(ivMoviePoster.getContext())
                .load(movies.getPosterPath())
                .into(ivMoviePoster);
    }
}
