package android.example.com.bakingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.example.com.bakingapp.NetworkTools.Ingredients;
import android.example.com.bakingapp.NetworkTools.RecipeClass;
import android.example.com.bakingapp.NetworkTools.Steps;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DetailedActivity extends AppCompatActivity {

    ArrayList <Ingredients> ingArray;
    public static ArrayList<Steps> stepsArray;



    ArrayList<String> ingLine = new ArrayList<String>(  );
    ArrayList<String> stepLine = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);



        //This segment takes care of the Ingredients Fragment

        IngredientsFragment ingredientsFragment = new IngredientsFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();

        fragmentManager.beginTransaction().add(R.id.ingredients_container, ingredientsFragment)
        .commit();

        List<RecipeClass> recipeDetail = MainActivity.recipe1;
        Intent intent = getIntent();
        int recipeReference= intent.getIntExtra("pass", 0);

        int ingredientsArraySize = recipeDetail.get(recipeReference).getIngredients().size();

        setTitle(recipeDetail.get(recipeReference).getName());

        for (int i = 0; i<ingredientsArraySize; i++){

           ingArray = recipeDetail.get(recipeReference).getIngredients();

           String ingDetail = ingArray.get(i).getIngredient();
           String measure = ingArray.get(i).getMeasure();
           float quantity = ingArray.get(i).getQuantity();

            ingLine.add(ingDetail + " - " + quantity + " (" + measure + ")" );

        }

        ingredientsFragment.setTxtIngredients(ingLine);

        //This segment takes care of the Recipe Fragment


        StepsFragment stepsFragment = new StepsFragment();

        FragmentManager fragmentManagerSteps = getSupportFragmentManager();

        fragmentManagerSteps.beginTransaction().add(R.id.recipe_container, stepsFragment)
                .commit();

        int recipeArraySize = recipeDetail.get(recipeReference).getSteps().size();

        for (int i = 0; i<recipeArraySize;i++){

            stepsArray = recipeDetail.get(recipeReference).getSteps();

            String shortDescription = stepsArray.get(i).getShortDescription();

            stepLine.add(shortDescription);
        }



        stepsFragment.setDetailRecipes(stepLine);

    }


    public ArrayList<Steps> getStepsArray() {
        return stepsArray;
    }



}
