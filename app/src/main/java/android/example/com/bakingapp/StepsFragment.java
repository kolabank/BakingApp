package android.example.com.bakingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class StepsFragment extends Fragment {

    RecyclerView rv_Recipe;
    ArrayList<String> detailRecipes;

    //Empty constructor of fragment

   public StepsFragment(){

           }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.recipe_fragment, container, false);

       rv_Recipe = view.findViewById(R.id.rv_recipe);


        PastryAdapter pastryAdapter = new PastryAdapter(detailRecipes,getActivity());
        rv_Recipe.setAdapter(pastryAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rv_Recipe.setLayoutManager(layoutManager);

       return view;



    }

    public void setDetailRecipes(ArrayList<String> recipeList){

       detailRecipes=recipeList;

    }

 /*  @Override
  public void onClick(int position) {

        Toast.makeText(getActivity(), position+"", Toast.LENGTH_LONG).show();

      Intent intent = new Intent(getContext(), PlayerActivity.class);
        intent.putExtra("position", position);


    startActivity(intent);
  }
*/

}
