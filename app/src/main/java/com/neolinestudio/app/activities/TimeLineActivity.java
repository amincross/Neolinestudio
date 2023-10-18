package com.neolinestudio.app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.neolinestudio.app.R;
import com.neolinestudio.app.adapters.ImageAdapter;
import com.neolinestudio.app.adapters.MainPostAdapter;
import com.neolinestudio.app.models.MyData;

import java.util.ArrayList;
import java.util.List;

public class TimeLineActivity extends AppCompatActivity {

    private LinearLayout homeButton, discoverButton, nftMarket, moreButton, profileButton;
    private ImageView ibHomeButton, ibDiscoverButton, ibNftMarket, ibMore, ibProfile;
    private LinearLayout[] buttons;
    private TextView homeTv, discoverTv, nftTv, moreTv,profileTv;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);

        setupStories();
        setupBottomNavigation();
        setupPosts();

    }

    private void setupPosts() {
        RecyclerView storiesRv = findViewById(R.id.recyclerView);

        // Create dummy data
        List<MyData> dataList = new ArrayList<>();
        dataList.add(new MyData(R.drawable.ic_story, "Albert901", "5m",
                getResources().getString(R.string.long_text), R.drawable.big_image, 20000,245000,12,256000,"Created 30 Jun 2023",false));

        dataList.add(new MyData(R.drawable.ic_story, "Delsa", "5m",
                getResources().getString(R.string.long_text), R.drawable.big_image, 20000,245000,12,256000,"Created 30 Jun 2023",true));
        // Add more data...

        // Set up RecyclerView
        storiesRv.setLayoutManager(new LinearLayoutManager(this));

        FragmentManager fragmentManager = getSupportFragmentManager();

        MainPostAdapter adapter = new MainPostAdapter(dataList,fragmentManager);
        storiesRv.setAdapter(adapter);
    }

    private void setupBottomNavigation() {
        //Initialize TextViews
        homeTv = findViewById(R.id.homeTv);
        discoverTv = findViewById(R.id.discoverTv);
        nftTv = findViewById(R.id.nftTv);
        moreTv = findViewById(R.id.moreTv);
        profileTv = findViewById(R.id.profileTv);

        //initilize image button
        ibHomeButton = findViewById(R.id.IbHomeButton);
        ibDiscoverButton = findViewById(R.id.IbDiscoverButton);
        ibNftMarket = findViewById(R.id.IbNftMarket);
        ibMore = findViewById(R.id.IbMore);
        ibProfile = findViewById(R.id.IbProfile);

        // Initialize buttons
        homeButton = findViewById(R.id.homeButton);
        discoverButton = findViewById(R.id.discoverButton);
        nftMarket = findViewById(R.id.nftMarket);
        moreButton = findViewById(R.id.moreButton);
        profileButton = findViewById(R.id.profileButton);

        buttons = new LinearLayout[]{homeButton, discoverButton, nftMarket, moreButton, profileButton};

        setSelectedButton(homeButton, ibHomeButton, homeTv);

        // Set click listeners for buttons
        homeButton.setOnClickListener(v -> setSelectedButton(homeButton, ibHomeButton, homeTv));
        discoverButton.setOnClickListener(v -> setSelectedButton(discoverButton, ibDiscoverButton, discoverTv));
        nftMarket.setOnClickListener(v -> setSelectedButton(nftMarket, ibNftMarket, nftTv));
        moreButton.setOnClickListener(v -> setSelectedButton(moreButton, ibMore, moreTv));
        profileButton.setOnClickListener(v -> setSelectedButton(profileButton, ibProfile, profileTv));

    }

    private void setSelectedButton(LinearLayout selectedButton, ImageView selectedImageButton, TextView textView) {

        homeTv.setTextColor(Color.WHITE);
        discoverTv.setTextColor(Color.WHITE);
        nftTv.setTextColor(Color.WHITE);
        moreTv.setTextColor(Color.WHITE);
        profileTv.setTextColor(Color.WHITE);

        ibHomeButton.setColorFilter(Color.WHITE);
        ibDiscoverButton.setColorFilter(Color.WHITE);
        ibNftMarket.setColorFilter(Color.WHITE);
        ibMore.setColorFilter(Color.WHITE);
        ibProfile.setColorFilter(Color.WHITE);

        for (LinearLayout button : buttons) {
            if (button == selectedButton) {
                button.setBackgroundResource(R.drawable.circle_background); // Apply the white circle background to the selected button

                selectedImageButton.setColorFilter(Color.parseColor("#F37382")); // White Tint
                textView.setTextColor(Color.parseColor("#F37382"));

            } else {
                button.setBackground(null);
            }
        }
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

        ImageAdapter adapter = new ImageAdapter(imageList, texts, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }
}