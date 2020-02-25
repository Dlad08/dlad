package com.example.recylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class RecylerView extends AppCompatActivity {
    int[] images;
    String[] names;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyler_view);
        recyclerView = findViewById(R.id.RecyclerView);
        images = new int[]{R.drawable.gd, R.drawable.dg, R.drawable.dd, R.drawable.pp, R.drawable.dg};
        names = new String[]{"gd", "dg", "dd", "pp", "pn"};
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(RecylerView.this);
        NautureName adapter = new NautureName(RecylerView.this,getList(images,names));

        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);

    }

    private List<AndroidVersion> getList(int[] images, String[] names) {
        List<AndroidVersion> list = new ArrayList<>();
        for (int i = 0; i < images.length; i++){
        AndroidVersion version = new AndroidVersion();
        version.setImage(images[i]);
        version.setName(names[i]);
        list.add(version);

    }
        return list;


}}


