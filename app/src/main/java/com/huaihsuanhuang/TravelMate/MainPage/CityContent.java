package com.huaihsuanhuang.TravelMate.MainPage;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.model.City;
import com.novoda.dropcap.DropCapView;
import com.squareup.picasso.Picasso;

public class CityContent extends AppCompatActivity {


    private TextView cityintro,city_data1, city_data2, city_data3, city_data4, city_data5, city_data6, city_data7, city_data8, city_data9, city_data10;
    private ImageView thumbnail;
    private CardView home_city_data1_card, home_city_data2_card, home_city_data3_card, home_city_data4_card, home_city_data5_card,
            home_city_data6_card, home_city_data7_card, home_city_data8_card, home_city_data9_card, home_city_data10_card;
    CollapsingToolbarLayout home_city_collapsing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.city_content);


        cityintro = findViewById(R.id.home_city_description);
        thumbnail = findViewById(R.id.home_city_thumbnail);
        city_data1 = findViewById(R.id.home_city_data1);
        city_data2 = findViewById(R.id.home_city_data2);
        city_data3 = findViewById(R.id.home_city_data3);
        city_data4 = findViewById(R.id.home_city_data4);
        city_data5 = findViewById(R.id.home_city_data5);
        city_data6 = findViewById(R.id.home_city_data6);
        city_data7 = findViewById(R.id.home_city_data7);
        city_data8 = findViewById(R.id.home_city_data8);
        city_data9 = findViewById(R.id.home_city_data9);
        city_data10 = findViewById(R.id.home_city_data10);
        home_city_data1_card = findViewById(R.id.home_city_data1_card);
        home_city_data2_card = findViewById(R.id.home_city_data2_card);
        home_city_data3_card = findViewById(R.id.home_city_data3_card);
        home_city_data4_card = findViewById(R.id.home_city_data4_card);
        home_city_data5_card = findViewById(R.id.home_city_data5_card);
        home_city_data6_card = findViewById(R.id.home_city_data6_card);
        home_city_data7_card = findViewById(R.id.home_city_data7_card);
        home_city_data8_card = findViewById(R.id.home_city_data8_card);
        home_city_data9_card = findViewById(R.id.home_city_data9_card);
        home_city_data10_card = findViewById(R.id.home_city_data10_card);
        home_city_collapsing = findViewById(R.id.home_city_collapsing);
        home_city_collapsing.setExpandedTitleTextAppearance(R.style.CityExpand);
        home_city_collapsing.setCollapsedTitleTextAppearance(R.style.CollapseAppbar);

        City city = getIntent().getParcelableExtra("City");
        home_city_collapsing.setTitle(city.getTitle());
        Picasso.get().load(city.getThumbnail()).into(thumbnail);

        cityintro.setText(city.getDescription());

        if (!(city.getCity_data1().equals("null"))) {
            city_data1.setText(city.getCity_data1());
            home_city_data1_card.setVisibility(View.VISIBLE);
        } else {
            home_city_data1_card.setVisibility(View.INVISIBLE);
        }
        if (!(city.getCity_data2().equals("null"))) {
            city_data2.setText(city.getCity_data2());
            home_city_data2_card.setVisibility(View.VISIBLE);
        } else {
            home_city_data2_card.setVisibility(View.INVISIBLE);
        }
        if (!(city.getCity_data3().equals("null"))) {
            city_data3.setText(city.getCity_data3());
            home_city_data3_card.setVisibility(View.VISIBLE);
        } else {
            home_city_data3_card.setVisibility(View.INVISIBLE);
        }
        if (!(city.getCity_data4().equals("null"))) {
            city_data4.setText(city.getCity_data4());
            home_city_data4_card.setVisibility(View.VISIBLE);
        } else {
            home_city_data4_card.setVisibility(View.INVISIBLE);
        }
        if (!(city.getCity_data5().equals("null"))) {
            city_data5.setText(city.getCity_data5());
            home_city_data5_card.setVisibility(View.VISIBLE);
        } else {
            home_city_data5_card.setVisibility(View.INVISIBLE);
        }
        if (!(city.getCity_data6().equals("null"))) {
            city_data6.setText(city.getCity_data6());
            home_city_data6_card.setVisibility(View.VISIBLE);
        } else {
            home_city_data6_card.setVisibility(View.INVISIBLE);
        }
        if (!(city.getCity_data7().equals("null"))) {
            city_data7.setText(city.getCity_data7());
            home_city_data7_card.setVisibility(View.VISIBLE);
        } else {
            home_city_data7_card.setVisibility(View.INVISIBLE);
        }
        if (!(city.getCity_data8().equals("null"))) {
            city_data8.setText(city.getCity_data8());
            home_city_data8_card.setVisibility(View.VISIBLE);
        } else {
            home_city_data8_card.setVisibility(View.INVISIBLE);
        }
        if (!(city.getCity_data9().equals("null"))) {
            city_data9.setText(city.getCity_data9());
            home_city_data9_card.setVisibility(View.VISIBLE);
        } else {
            home_city_data9_card.setVisibility(View.INVISIBLE);
        }
        if (!(city.getCity_data10().equals("null"))) {
            city_data10.setText(city.getCity_data10());
            home_city_data10_card.setVisibility(View.VISIBLE);
        } else {
            home_city_data10_card.setVisibility(View.INVISIBLE);
        }


    }
}
