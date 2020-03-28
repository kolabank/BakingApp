package android.example.com.bakingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.example.com.bakingapp.NetworkTools.Api;
import android.example.com.bakingapp.NetworkTools.Ingredients;
import android.example.com.bakingapp.NetworkTools.RecipeClass;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.AEADBadTagException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements PastryAdapter.Listener, Serializable{

    RecyclerView rv_pastry;
    public static List<RecipeClass> recipe1 = new ArrayList<RecipeClass>();
    ArrayList<String> recipeName = new ArrayList<String>();
    ArrayList<ArrayList<Ingredients>> ingredientsArray = new ArrayList<ArrayList<Ingredients>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Call method that implements JSON parsing using Retrofit Library
        jsonParsing();

    }


        public void jsonParsing () {

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

           Api api = retrofit.create(Api.class);

            Call<List<RecipeClass>> call = api.getRecipe();

            call.enqueue(new Callback<List<RecipeClass>>() {

                @Override
                public void onResponse(Call<List<RecipeClass>> call, Response<List<RecipeClass>> response) {

                //List of JSON Data
                    List<RecipeClass>  recipes = response.body();
                    recipe1 = recipes;
                    rv_pastry = findViewById(R.id.rv_pastry);
                 //   ArrayList recipeName = new ArrayList();

                    for (int i=0; i<recipes.size();i++){
                      recipeName.add(recipes.get(i).getName());
                      ingredientsArray.add (recipes.get(i).getIngredients());

                    //Log.i("tag", ingredientSArray.get(i).getIngredient());
                    }

                    PastryAdapter pastryAdapter = new PastryAdapter(recipeName, MainActivity.this);
                    rv_pastry.setAdapter(pastryAdapter);
                    LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
                    rv_pastry.setLayoutManager(layoutManager);

                }

                @Override
                public void onFailure(Call<List<RecipeClass>> call, Throwable t) {

                    Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                    Log.i("comment", t.getMessage());
                }

            });

        }

    @Override
    public void onClick(int position) {

        Toast.makeText(getApplicationContext(), position+"", Toast.LENGTH_LONG).show();
        //ingredientsArray.get(position).get(position);

        Intent intent = new Intent(MainActivity.this, DetailedActivity.class);
        intent.putExtra("pass", position);
        startActivity (intent);

    }
}
