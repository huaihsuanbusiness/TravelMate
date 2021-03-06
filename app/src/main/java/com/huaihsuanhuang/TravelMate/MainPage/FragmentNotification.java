package com.huaihsuanhuang.TravelMate.MainPage;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
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
import com.huaihsuanhuang.TravelMate.Adapter.RecyclerviewAdapterNotification;
import com.huaihsuanhuang.TravelMate.R;
import com.huaihsuanhuang.TravelMate.model.Notifications;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentNotification extends Fragment {
    private FirebaseAnalytics mFirebaseAnalytics;

    private ArrayList<Notifications> notilist = new ArrayList<>();
    private ArrayList<String> contentlist;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference reference_note;
    RecyclerView recyclerview_notification;
    RecyclerView.LayoutManager layoutManager_notification;
    RecyclerviewAdapterNotification myAdapter;


    public FragmentNotification() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this.getContext());
        // Write a message to the database

        View rootView = inflater.inflate(R.layout.fragment_notification, container, false);
        //used by firebaserecyclerviewadapter
        firebaseDatabase = FirebaseDatabase.getInstance();
        reference_note = firebaseDatabase.getReference("note");
        recyclerview_notification = rootView.findViewById(R.id.recyclerview_notification);
        recyclerview_notification.setHasFixedSize(true);
        layoutManager_notification = new LinearLayoutManager(this.getContext());
        recyclerview_notification.setLayoutManager(layoutManager_notification);

        //used by recyclerviewadapter

        firebasetask();
        RecyclerView myRecyclerView = rootView.findViewById(R.id.recyclerview_notification);
        myRecyclerView.setHasFixedSize(true);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        myAdapter = new RecyclerviewAdapterNotification(this.getContext(), notilist);
        myRecyclerView.setAdapter(myAdapter);


        View view = rootView.findViewById(R.id.layout_notification);
        view.getBackground().setAlpha(60);
        return rootView;
    }

    private void firebasetask() {
        DatabaseReference myRef = FirebaseDatabase.getInstance().getReference("notification");
        myRef.child("0").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    contentlist = new ArrayList<>();
                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                        contentlist.add(String.valueOf(dsp.getValue()));
                    }
                    String sub0 = contentlist.get(0);
                    String con0 = contentlist.get(1);
                    String upd0 = contentlist.get(2);
                    notilist.add(new Notifications(sub0, con0, upd0));
                    myAdapter.notifyDataSetChanged();
                    contentlist = new ArrayList<>();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        myRef.child("1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    contentlist = new ArrayList<>();
                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                        contentlist.add(String.valueOf(dsp.getValue()));
                    }
                    String sub1 = contentlist.get(0);
                    String con1 = contentlist.get(1);
                    String upd1 = contentlist.get(2);
                    notilist.add(new Notifications(sub1, con1, upd1));
                    myAdapter.notifyDataSetChanged();
                    contentlist = new ArrayList<>();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        myRef.child("2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    contentlist = new ArrayList<>();
                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                        contentlist.add(String.valueOf(dsp.getValue()));
                    }
                    String sub2 = contentlist.get(0);
                    String con2 = contentlist.get(1);
                    String upd2 = contentlist.get(2);
                    notilist.add(new Notifications(sub2, con2, upd2));
                    myAdapter.notifyDataSetChanged();
                    contentlist = new ArrayList<>();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        myRef.child("3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    contentlist = new ArrayList<>();
                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                        contentlist.add(String.valueOf(dsp.getValue()));
                    }
                    String sub3 = contentlist.get(0);
                    String con3 = contentlist.get(1);
                    String upd3 = contentlist.get(2);
                    notilist.add(new Notifications(sub3, con3, upd3));
                    myAdapter.notifyDataSetChanged();
                    contentlist = new ArrayList<>();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

        myRef.child("4").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    contentlist = new ArrayList<>();
                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                        contentlist.add(String.valueOf(dsp.getValue()));
                    }
                    String sub4 = contentlist.get(0);
                    String con4 = contentlist.get(1);
                    String upd4 = contentlist.get(2);
                    notilist.add(new Notifications(sub4, con4, upd4));
                    myAdapter.notifyDataSetChanged();
                    contentlist = new ArrayList<>();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        myRef.child("5").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    contentlist = new ArrayList<>();
                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                        contentlist.add(String.valueOf(dsp.getValue()));
                    }
                    String sub5 = contentlist.get(0);
                    String con5 = contentlist.get(1);
                    String upd5 = contentlist.get(2);
                    notilist.add(new Notifications(sub5, con5, upd5));
                    myAdapter.notifyDataSetChanged();
                    contentlist = new ArrayList<>();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        myRef.child("6").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    contentlist = new ArrayList<>();
                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                        contentlist.add(String.valueOf(dsp.getValue()));
                    }
                    String sub6 = contentlist.get(0);
                    String con6 = contentlist.get(1);
                    String upd6 = contentlist.get(2);
                    notilist.add(new Notifications(sub6, con6, upd6));
                    myAdapter.notifyDataSetChanged();
                    contentlist = new ArrayList<>();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        myRef.child("7").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    contentlist = new ArrayList<>();
                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                        contentlist.add(String.valueOf(dsp.getValue()));
                    }
                    String sub7 = contentlist.get(0);
                    String con7 = contentlist.get(1);
                    String upd7 = contentlist.get(2);
                    notilist.add(new Notifications(sub7, con7, upd7));
                    myAdapter.notifyDataSetChanged();
                    contentlist = new ArrayList<>();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        myRef.child("8").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    contentlist = new ArrayList<>();
                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                        contentlist.add(String.valueOf(dsp.getValue()));
                    }
                    String sub8 = contentlist.get(0);
                    String con8 = contentlist.get(1);
                    String upd8 = contentlist.get(2);
                    notilist.add(new Notifications(sub8, con8, upd8));
                    myAdapter.notifyDataSetChanged();
                    contentlist = new ArrayList<>();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
        myRef.child("9").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    contentlist = new ArrayList<>();
                    for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                        contentlist.add(String.valueOf(dsp.getValue()));
                    }
                    String sub9 = contentlist.get(0);
                    String con9 = contentlist.get(1);
                    String upd9 = contentlist.get(2);
                    notilist.add(new Notifications(sub9, con9, upd9));
                    myAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });


    }


}
