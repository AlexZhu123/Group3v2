package com.example.infs3605group3application;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.infs3605group3application.Fragments.ContactFragment;
import com.example.infs3605group3application.Fragments.ContactListFragment;
import com.example.infs3605group3application.Fragments.CrisisFragment;
import com.example.infs3605group3application.Fragments.LoginFragment;
import com.example.infs3605group3application.Fragments.NewsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Button tester;
    private Button Contact;

    BottomNavigationView bottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigation = findViewById(R.id.nav_bar);

        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.login:
                        startFragmentPage(new LoginFragment());
                        return true;
                    case R.id.crisis:
                        startFragmentPage(new CrisisFragment());
                        return true;
                    case R.id.news:
                        startFragmentPage(new NewsFragment());
                        return true;
                    case R.id.contact:
                        startFragmentPage(new ContactFragment());
                        return true;
                    case R.id.contact_list:
                        startFragmentPage(new ContactListFragment());
                        return true;
                    default:
                        return false;
                }

            }
        });


        if (savedInstanceState == null) {
            bottomNavigation.setSelectedItemId(R.id.news);
            startFragmentPage(new NewsFragment());
        }


//        tester = findViewById(R.id.MakePost);
//        tester.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), MakePost.class);
//                startActivity(intent);
//            }
//        });
//        Contact = findViewById(R.id.Contact);
//        Contact.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), Contact.class);
//                startActivity(intent);
//            }
//        });
    }


    public void startFragmentPage(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction(); // Start transaction/transition manager
        transaction.replace(R.id.container, fragment); // replace current container fragment with another fragment
        transaction.addToBackStack(null);
        transaction.commit(); // Do it
    }

}
