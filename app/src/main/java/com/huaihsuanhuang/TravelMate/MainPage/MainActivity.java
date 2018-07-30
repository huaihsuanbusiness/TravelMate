package com.huaihsuanhuang.TravelMate.MainPage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.huaihsuanhuang.TravelMate.R;


public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    setTitle("Purchase_Home");
                    FragmentHome fragmentHome = new FragmentHome();

                    FragmentTransaction fragmentTransactionhome = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionhome.replace(R.id.fram,fragmentHome, "name");
                    fragmentTransactionhome.commit();

                    return true;

                case R.id.navigation_tools:
                    setTitle("Tools");
                    FragmentTools fragmentTools = new FragmentTools();
                    FragmentTransaction fragmentTransactionTools = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionTools.replace(R.id.fram,fragmentTools, "name");
                    fragmentTransactionTools.commit();
                    return true;

                case R.id.navigation_notifications:
                    setTitle("Notification");
                    FragmentNotification fragmentNotification = new FragmentNotification();
                    FragmentTransaction fragmentTransactionnotification = getSupportFragmentManager().beginTransaction();
                    fragmentTransactionnotification.replace(R.id.fram,fragmentNotification, "name");
                    fragmentTransactionnotification.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage =  findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        setTitle("Purchase_Home");
        FragmentHome fragmentHome = new FragmentHome();
        FragmentTransaction fragmentTransactionhome = getSupportFragmentManager().beginTransaction();
        fragmentTransactionhome.replace(R.id.fram,fragmentHome, "name");
        fragmentTransactionhome.commit();





    }


}
