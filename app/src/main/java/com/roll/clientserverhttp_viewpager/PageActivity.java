package com.roll.clientserverhttp_viewpager;

import android.*;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;
import com.roll.clientserverhttp_viewpager.adapters.PagerAdapter;
import com.roll.clientserverhttp_viewpager.entities.Contacts;

/**
 * Created by RDL on 05/03/2017.
 */

public class PageActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private PagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);

        SharedPreferences sharedPreferences = getSharedPreferences("AUTH", Context.MODE_PRIVATE);
        String usersJson = sharedPreferences.getString("CONTACTS", "");
        Contacts contacts = new Gson().fromJson(usersJson, Contacts.class);

        viewPager = (ViewPager) findViewById(R.id.container_pager);
        adapter = new PagerAdapter(getSupportFragmentManager(), contacts);
        viewPager.setAdapter(adapter);
    }
}
