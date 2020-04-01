package android.example.com.bakingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.example.com.bakingapp.NetworkTools.RecipeClass;
import android.example.com.bakingapp.NetworkTools.Steps;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);


        PlayerFragment playerFragment = new PlayerFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.player_container, playerFragment)
                .commit();

        Intent intent = getIntent();
        int recipeReference = intent.getIntExtra("position",0);


      //  DetailedActivity detailedActivity = new DetailedActivity();
       // ArrayList<Steps> steps = detailedActivity.getStepsArray();

        ArrayList<Steps> steps= DetailedActivity.stepsArray;
        String videoString = steps.get(recipeReference).getVideoURL();

        playerFragment.setStringUri(videoString);

    }
}
