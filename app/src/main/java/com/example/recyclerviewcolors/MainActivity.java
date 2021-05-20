package com.example.recyclerviewcolors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    RecyclerView rview;
    // TODO: создать массив с цветами (которые заданы в ресурсах)
    ArrayList<String> colors;

    ArrayList<Integer> numbers = new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors  = new ArrayList<>(Arrays.asList(getResources().getStringArray(R.array.colorNames)));

        rview = findViewById(R.id.rview);
        ColorAdapter adapter = new ColorAdapter(getLayoutInflater());
        adapter.submitList(colors);
        rview.setLayoutManager(new LinearLayoutManager(this));
        // задаём оформление
        rview.addItemDecoration(
                new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        rview.setAdapter(adapter);

    }

    public String getColorResourceByName(String aString) {
        String packageName = getPackageName();
        int resId = getResources().getIdentifier(aString, "string", packageName);
        return getString(resId);
    }
}