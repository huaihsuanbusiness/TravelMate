package com.huaihsuanhuang.TravelMate;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.huaihsuanhuang.TravelMate.model.City;
import com.squareup.picasso.Picasso;

public class City_Content extends AppCompatActivity {



    private TextView cityintro, cityassess, citytourism;
    private ImageView thumbnail;
    CollapsingToolbarLayout home_city_collapsing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_content);


        cityintro = findViewById(R.id.home_city_description);
        cityassess = findViewById(R.id.home_city_access);
        citytourism = findViewById(R.id.home_city_tourism);
        thumbnail = findViewById(R.id.home_city_thumbnail);
        City city = getIntent().getParcelableExtra("City");
        home_city_collapsing=findViewById(R.id.home_city_collapsing);
        home_city_collapsing.setExpandedTitleTextAppearance(R.style.CityExpand);
        home_city_collapsing.setCollapsedTitleTextAppearance(R.style.CollapseAppbar);



        String CityIntro = city.getIntroduction();
        String CityAssess = city.getAccess();
        String CityTourism = city.getTourism();
        String image = city.getThumbnail();
        Picasso.get().load(image).into(thumbnail);
        home_city_collapsing.setTitle(city.getTitle());
        cityintro.setText(CityIntro);
        cityassess.setText(CityAssess);
        citytourism.setText(CityTourism);



    }
}
