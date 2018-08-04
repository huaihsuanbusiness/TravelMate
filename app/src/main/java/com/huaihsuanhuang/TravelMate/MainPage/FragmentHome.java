package com.huaihsuanhuang.TravelMate.MainPage;


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
import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.model.City;
import com.huaihsuanhuang.TravelMate.Adapter.RecyclerviewAdapter;

import java.util.ArrayList;
import java.util.List;


public class FragmentHome extends Fragment {

    private FirebaseAnalytics mFirebaseAnalytics;
    List<City> cityList;
    private ArrayList<String> container_list;

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
    //    myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager( new GridLayoutManager(this.getContext(),2));
        myRecyclerView.setAdapter(myAdapter);
        View view =rootView.findViewById(R.id.layout_home);
        view.getBackground().setAlpha(60);
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
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
                cityList.add(new City(
                        container_list.get(0),
                        container_list.get(1),
                        container_list.get(2),
                        container_list.get(3),
                        container_list.get(4),
                        container_list.get(5),
                        container_list.get(6),
                        container_list.get(7),
                        container_list.get(8),
                        container_list.get(9),
                        container_list.get(10),
                        container_list.get(11),
                        container_list.get(12))
                );
                myAdapter.notifyDataSetChanged();
                container_list = new ArrayList<>();}
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) { }});
    }

}

