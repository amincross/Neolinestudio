package com.neolinestudio.app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.neolinestudio.app.R;
import com.neolinestudio.app.adapters.ImageAdapter;

import java.util.ArrayList;
import java.util.List;

public class TimeLineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);

        setupStories();
    }

    private void setupStories() {

        RecyclerView recyclerView = findViewById(R.id.stories_rv);

        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.ic_add);
        imageList.add(R.drawable.ic_story);
        imageList.add(R.drawable.ic_story);
        imageList.add(R.drawable.ic_story);

        List<String> texts = new ArrayList<>();
        texts.add("Damla");
        texts.add("ErkanG");
        texts.add("OrcXXX");
        texts.add("DDED");

        ImageAdapter adapter = new ImageAdapter(imageList,texts, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }
}