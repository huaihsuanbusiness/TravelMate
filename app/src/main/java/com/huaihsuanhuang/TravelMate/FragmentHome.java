package com.huaihsuanhuang.TravelMate;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.huaihsuanhuang.TravelMate.model.City;
import com.huaihsuanhuang.TravelMate.Adapter.RecyclerviewAdapter;

import java.util.ArrayList;
import java.util.List;


public class FragmentHome extends Fragment {

    private FirebaseAnalytics mFirebaseAnalytics;
    List<City> cityList;
    private ArrayList<String> container_list;

    String title_taipei,intro_taiepi,access_taipei,tour_taipei,image_taipei,
            title_taoyuan,intro_taoyuan,access_taoyuan,tour_taoyuan,image_taoyuan,
            title_hsinchu,intro_hsinchu,access_hsinchu,tour_hsinchu,image_hsinchu,
            title_keelung,intro_keelung,access_keelung,tour_keelung,image_keelung,
            title_miaoli,intro_miaoli,access_miaoli,tour_miaoli,image_miaoli,
            title_newtaipei,intro_newtaipei,access_newtaipei,tour_newtaipei,image_newtaipei,
            title_taichung,intro_taichung,access_taichung,tour_taichung,image_taichung,
            title_tainan,intro_tainan,access_tainan,tour_tainan,image_tainan,
            title_changhua,intro_changhua,access_changhua,tour_changhua,image_changhua,
            title_yunlin,intro_yunlin,access_yunlin,tour_yunlin,image_yunlin,
            title_chiayi,intro_chiayi,access_chiayi,tour_chiayi,image_chiayi,
            title_kaohsiung,intro_kaohsiung,access_kaohsiung,tour_kaohsiung,image_kaohsiung,
            title_pingtung,intro_pingtung,access_pingtung,tour_pingtung,image_pingtung,
            title_kinmen,intro_kinmen,access_kinmen,tour_kinmen,image_kinmen,
            title_lienchiang,intro_lienchiang,access_lienchiang,tour_lienchiang,image_lienchiang,
            title_yilan,intro_yilan,access_yilan,tour_yilan,image_yilan,
            title_hualien,intro_hualien,access_hualien,tour_hualien,image_hualien,
            title_taitung,intro_taitung,access_taitung,tour_taitung,image_taitung,
            title_nantou,intro_nantou,access_nantou,tour_nantou,image_nantou,
            title_penghu,intro_penghu,access_penghu,tour_penghu,image_penghu;
    RecyclerviewAdapter myAdapter;
    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_home,container,false);
        // Obtain the FirebaseAnalytics instance.
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this.getContext());
        cityList =new ArrayList<>();

        Firebasetask();

        RecyclerView myRecyclerView = rootView.findViewById(R.id.recyclerview_id);
         myAdapter = new RecyclerviewAdapter(this.getActivity(),cityList);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager( new GridLayoutManager(this.getContext(),1));
        myRecyclerView.setAdapter(myAdapter);

        return rootView;
    }

    private void Firebasetask() {
        DatabaseReference myRef =FirebaseDatabase.getInstance().getReference("city");
        myRef.child("Taipei").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_taipei= container_list.get(0);
                intro_taiepi = container_list.get(1);
                access_taipei = container_list.get(2);
                tour_taipei= container_list.get(3);
                image_taipei= container_list.get(4);
                cityList.add(new City(title_taipei,intro_taiepi,access_taipei,tour_taipei,image_taipei));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Taoyuan").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_taoyuan= container_list.get(0);
                intro_taoyuan = container_list.get(1);
                access_taoyuan = container_list.get(2);
                tour_taoyuan= container_list.get(3);
                image_taoyuan= container_list.get(4);
                cityList.add(new City(title_taoyuan,intro_taoyuan,access_taoyuan,tour_taoyuan,image_taoyuan));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Penghu").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_penghu= container_list.get(0);
                intro_penghu = container_list.get(1);
                access_penghu = container_list.get(2);
                tour_penghu= container_list.get(3);
                image_penghu= container_list.get(4);
                cityList.add(new City(title_penghu,intro_penghu,access_penghu,tour_penghu,image_penghu));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Hsinchu").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_hsinchu= container_list.get(0);
                intro_hsinchu = container_list.get(1);
                access_hsinchu = container_list.get(2);
                tour_hsinchu= container_list.get(3);
                image_hsinchu= container_list.get(4);
                cityList.add(new City(title_hsinchu,intro_hsinchu,access_hsinchu,tour_hsinchu,image_hsinchu));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Keelung").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_keelung= container_list.get(0);
                intro_keelung = container_list.get(1);
                access_keelung = container_list.get(2);
                tour_keelung= container_list.get(3);
                image_keelung= container_list.get(4);
                cityList.add(new City(title_keelung,intro_keelung,access_keelung,tour_keelung,image_keelung));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Miaoli").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_miaoli= container_list.get(0);
                intro_miaoli = container_list.get(1);
                access_miaoli = container_list.get(2);
                tour_miaoli= container_list.get(3);
                image_miaoli= container_list.get(4);
                cityList.add(new City(title_miaoli,intro_miaoli,access_miaoli,tour_miaoli,image_miaoli));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Newtaipei").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_newtaipei= container_list.get(0);
                intro_newtaipei = container_list.get(1);
                access_newtaipei = container_list.get(2);
                tour_newtaipei= container_list.get(3);
                image_newtaipei= container_list.get(4);
                cityList.add(new City(title_newtaipei,intro_newtaipei,access_newtaipei,tour_newtaipei,image_newtaipei));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Taichung").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_taichung= container_list.get(0);
                intro_taichung = container_list.get(1);
                access_taichung = container_list.get(2);
                tour_taichung= container_list.get(3);
                image_taichung= container_list.get(4);
                cityList.add(new City(title_taichung,intro_taichung,access_taichung,tour_taichung,image_taichung));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Tainan").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_tainan= container_list.get(0);
                intro_tainan = container_list.get(1);
                access_tainan = container_list.get(2);
                tour_tainan= container_list.get(3);
                image_tainan= container_list.get(4);
                cityList.add(new City(title_tainan,intro_tainan,access_tainan,tour_tainan,image_tainan));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Changhua").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_changhua= container_list.get(0);
                intro_changhua= container_list.get(1);
                access_changhua= container_list.get(2);
                tour_changhua= container_list.get(3);
                image_changhua= container_list.get(4);
                cityList.add(new City(title_changhua,intro_changhua,access_changhua,tour_changhua,image_changhua));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Yunlin").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_yunlin= container_list.get(0);
                intro_yunlin= container_list.get(1);
                access_yunlin= container_list.get(2);
                tour_yunlin= container_list.get(3);
                image_yunlin= container_list.get(4);
                cityList.add(new City(title_yunlin,intro_yunlin,access_yunlin,tour_yunlin,image_yunlin));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Chiayi").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_chiayi= container_list.get(0);
                intro_chiayi= container_list.get(1);
                access_chiayi= container_list.get(2);
                tour_chiayi= container_list.get(3);
                image_chiayi= container_list.get(4);
                cityList.add(new City(title_chiayi,intro_chiayi,access_chiayi,tour_chiayi,image_chiayi));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Kaohsiung").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_kaohsiung= container_list.get(0);
                intro_kaohsiung= container_list.get(1);
                access_kaohsiung= container_list.get(2);
                tour_kaohsiung= container_list.get(3);
                image_kaohsiung= container_list.get(4);
                cityList.add(new City(title_kaohsiung,intro_kaohsiung,access_kaohsiung,tour_kaohsiung,image_kaohsiung));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Pingtung").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_pingtung= container_list.get(0);
                intro_pingtung= container_list.get(1);
                access_pingtung= container_list.get(2);
                tour_pingtung= container_list.get(3);
                image_pingtung= container_list.get(4);
                cityList.add(new City(title_pingtung,intro_pingtung,access_pingtung,tour_pingtung,image_pingtung));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Kinmen").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_kinmen= container_list.get(0);
                intro_kinmen= container_list.get(1);
                access_kinmen= container_list.get(2);
                tour_kinmen= container_list.get(3);
                image_kinmen= container_list.get(4);
                cityList.add(new City(title_kinmen,intro_kinmen,access_kinmen,tour_kinmen,image_kinmen));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Lienchiang").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_lienchiang= container_list.get(0);
                intro_lienchiang= container_list.get(1);
                access_lienchiang= container_list.get(2);
                tour_lienchiang= container_list.get(3);
                image_lienchiang= container_list.get(4);
                cityList.add(new City(title_lienchiang,intro_lienchiang,access_lienchiang,tour_lienchiang,image_lienchiang));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Yilan").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_yilan= container_list.get(0);
                intro_yilan= container_list.get(1);
                access_yilan= container_list.get(2);
                tour_yilan= container_list.get(3);
                image_yilan= container_list.get(4);
                cityList.add(new City(title_yilan,intro_yilan,access_yilan,tour_yilan,image_yilan));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Hualien").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_hualien= container_list.get(0);
                intro_hualien= container_list.get(1);
                access_hualien= container_list.get(2);
                tour_hualien= container_list.get(3);
                image_hualien= container_list.get(4);
                cityList.add(new City(title_hualien,intro_hualien,access_hualien,tour_hualien,image_hualien));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Taitung").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_taitung= container_list.get(0);
                intro_taitung= container_list.get(1);
                access_taitung= container_list.get(2);
                tour_taitung= container_list.get(3);
                image_taitung= container_list.get(4);
                cityList.add(new City(title_taitung,intro_taitung,access_taitung,tour_taitung,image_taitung));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
        myRef.child("Nantou").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                container_list = new ArrayList<>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    container_list.add(String.valueOf(dsp.getValue())); }
                title_nantou= container_list.get(0);
                intro_nantou= container_list.get(1);
                access_nantou= container_list.get(2);
                tour_nantou= container_list.get(3);
                image_nantou= container_list.get(4);
                cityList.add(new City(title_nantou,intro_nantou,access_nantou,tour_nantou,image_nantou));
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
    }

}

