package android.example.com.bakingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.example.com.bakingapp.NetworkTools.Ingredients;
import android.os.Bundle;

import java.util.ArrayList;

public class DetailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
    IngredientsFragment ingredientsFragment = new IngredientsFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.ingredients_container, ingredientsFragment)
        .commit();

     /*   Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("Bundle");
        ArrayList<Ingredients> ing = (ArrayList<Ingredients>) args.getSerializable("ArrayList");
*/


    }
}
