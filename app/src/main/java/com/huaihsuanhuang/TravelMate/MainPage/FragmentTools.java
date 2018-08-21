package com.huaihsuanhuang.TravelMate.MainPage;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.huaihsuanhuang.TravelMate.Account.Auth;
import com.huaihsuanhuang.TravelMate.Feedback.Feedback;
import com.huaihsuanhuang.TravelMate.MapsActivityWifi;
import com.huaihsuanhuang.TravelMate.Purchase.Purchase_entrance;
import com.huaihsuanhuang.TravelMate.Currency.Tools_Currency;
import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.TRAActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTools extends Fragment {


    public FragmentTools() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View myfragment = inflater.inflate(R.layout.fragment_tools, container, false);

        LinearLayout linearLayout_taipeiwifi = myfragment.findViewById(R.id.id_text_taipeiwifi);
        linearLayout_taipeiwifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsActivityWifi.class);
                startActivity(intent);
            }
        });

        LinearLayout linearLayout_metro = myfragment.findViewById(R.id.id_text_currency);
        linearLayout_metro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Tools_Currency.class);
                startActivity(intent);
            }
        });

        LinearLayout linearLayout_tra = myfragment.findViewById(R.id.id_text_tra);
        linearLayout_tra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), TRAActivity.class);
                startActivity(intent);
            }
        });
        LinearLayout linearLayout_login = myfragment.findViewById(R.id.id_text_login);
        linearLayout_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Auth.class);
                startActivity(intent);
            }
        });
        LinearLayout linearLayout_database = myfragment.findViewById(R.id.id_text_database);
        linearLayout_database.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Feedback.class);
                startActivity(intent);
            }
        });

        LinearLayout linearLayout_purchase = myfragment.findViewById(R.id.id_text_purchase);
        linearLayout_purchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Purchase_entrance.class);
                startActivity(intent);
            }
        });
        // Inflate the layout for this fragment
        View view =myfragment.findViewById(R.id.layout_tools);
        view.getBackground().setAlpha(60);

        return myfragment;
    }




}
