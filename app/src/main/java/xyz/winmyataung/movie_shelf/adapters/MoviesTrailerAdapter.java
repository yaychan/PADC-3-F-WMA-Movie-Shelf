package xyz.winmyataung.movie_shelf.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.winmyataung.movie_shelf.R;
import xyz.winmyataung.movie_shelf.viewitems.MoviesTrailerViewItem;

/**
 * Created by DELL on 12/12/2017.
 */

public class MoviesTrailerAdapter extends PagerAdapter {

    @Override
    public int getCount() {
        return 6;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
       /* if (object instanceof View)
            return true;
        else
            return false;*/
/*
       return (object instanceof View);
*/

        return (view == (View) object);
    }

   @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Context context = container.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        MoviesTrailerViewItem view = (MoviesTrailerViewItem) layoutInflater.inflate(R.layout.item_movies_details_trailors, container, false);
     //   View view=layoutInflater.inflate(R.layout.item_news_details_images, container, false)
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);  //removeView ကobject type ကိုလက္မခံဘူး
    }
}
