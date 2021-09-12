package com.example.dashboarddesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupMoviesViewPager();
    }

    private void setupMoviesViewPager(){
        ViewPager2 moviesViewPager=findViewById(R.id.moviesViewPager);
        moviesViewPager.setClipChildren(false);
        moviesViewPager.setClipToPadding(false);
        moviesViewPager.setOffscreenPageLimit(3);
        moviesViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
        CompositePageTransformer compositePageTransformer=new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
        compositePageTransformer.addTransformer((page, position) -> {
            float r=1- Math.abs(position);
            page.setScaleY(0.85f + r * 0.15f);
        });
        moviesViewPager.setPageTransformer(compositePageTransformer);
        moviesViewPager.setAdapter(new MoviesAdapter(getMovies()));
    }

    private List<Movie> getMovies(){
        List<Movie> movies= new ArrayList<>();

        Movie passengers= new Movie();
        passengers.poster=R.drawable.photo;
        passengers.name="Pasta";
        passengers.category="starter";
        passengers.releaseDate="15 min";
        passengers.rating=4.6f;
        movies.add(passengers);

        Movie food2= new Movie();
        food2.poster=R.drawable.photo2;
        food2.name="Briano";
        food2.category="BreakFast";
        food2.releaseDate="10 min";
        food2.rating=4.6f;
        movies.add(food2);

        Movie food3= new Movie();
        food3.poster=R.drawable.photo3;
        food3.name="Shiani";
        food3.category="BreakFast";
        food3.releaseDate="10 min";
        food3.rating=4.8f;
        movies.add(food3);

        Movie food4= new Movie();
        food4.poster=R.drawable.photo4;
        food4.name="Lichino";
        food4.category="lunch";
        food4.releaseDate="20 min";
        food4.rating=3.5f;
        movies.add(food4);

        Movie food5= new Movie();
        food5.poster=R.drawable.photo;
        food5.name="Pasta";
        food5.category="starter";
        food5.releaseDate="15 min";
        food5.rating=4.6f;
        movies.add(food5);

        return movies;
    }
}