package xyz.winmyataung.movie_shelf.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.EventLog;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.winmyataung.movie_shelf.PopularMoviesApp;
import xyz.winmyataung.movie_shelf.R;
import xyz.winmyataung.movie_shelf.adapters.MoviesAdapter;
import xyz.winmyataung.movie_shelf.data.model.MoviesModel;
import xyz.winmyataung.movie_shelf.delegates.MoviesActionDelegates;
import xyz.winmyataung.movie_shelf.events.LoadedMoviesEvent;

public class MainActivity extends AppCompatActivity implements MoviesActionDelegates {

    public static Intent newIntent(Context context) {
           Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @BindView(R.id.rv_movies)
    RecyclerView rvMovies;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton floatingActionButton;

    @BindView(R.id.rl_movie_details)
    RelativeLayout rlMovieDetails;


    private MoviesAdapter moviesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

       /* btnMovieOverview.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent intent = MoviesDetailsActivity.newIntent(getApplicationContext());
                startActivity(intent);
            }
        });*/

        moviesAdapter = new MoviesAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rvMovies.setLayoutManager(linearLayoutManager);
        rvMovies.setAdapter(moviesAdapter);

        MoviesModel.getObjInstance().loadMovies();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void onTabFab(View view) {
        Snackbar.make(view, "Replace with your own action - ButterKnife", Snackbar.LENGTH_INDEFINITE)
                .setAction("Action", null).show();
    }

    @Override
    public void onTapMoviesItem() {

        Intent intent = new Intent(getApplicationContext(), MoviesDetailsActivity.class);
        startActivity(intent);

    }

    @Override
    public void onTapMoviesOverview() {
    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMoviesLoaded(LoadedMoviesEvent event){

        Log.d(PopularMoviesApp.LOG_TAG,"onMoviesLoaded : "+event.getMoviesList());
        moviesAdapter.setMovies(event.getMoviesList());
    }
}
