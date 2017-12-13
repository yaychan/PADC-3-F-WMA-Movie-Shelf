package xyz.winmyataung.movie_shelf.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.winmyataung.movie_shelf.R;
import xyz.winmyataung.movie_shelf.adapters.MoviesTrailerAdapter;


/**
 * Created by DELL on 12/12/2017.
 */

public class MoviesDetailsActivity extends AppCompatActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MoviesDetailsActivity.class);
        return intent;
    }


    @BindView(R.id.vp_movies_trailers)
    ViewPager movies_trailers;

    private MoviesTrailerAdapter MoviesTrailerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies_details);

        ButterKnife.bind(this,this);

        MoviesTrailerAdapter =new MoviesTrailerAdapter();
        movies_trailers.setAdapter(MoviesTrailerAdapter);

    }
}
