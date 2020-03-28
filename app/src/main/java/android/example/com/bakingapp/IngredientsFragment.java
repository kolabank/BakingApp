package android.example.com.bakingapp;

import android.content.Intent;
import android.example.com.bakingapp.NetworkTools.Ingredients;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class IngredientsFragment extends Fragment {

    ListView txtIngredientsList;
    ArrayList<String> detailIngredients;
    int noOfIngredients;
    //Empty constructor of fragment
    public IngredientsFragment (){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_ingredients, container, false);

       txtIngredientsList= rootView.findViewById(R.id.ingredientsListView);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, detailIngredients);

        txtIngredientsList.setAdapter(arrayAdapter);

        return rootView;


    }

    void setNoOfIngredients (int ingredientsNo){

        noOfIngredients = ingredientsNo;
    }

    void setTxtIngredients (ArrayList ingredientsText){

        detailIngredients =  ingredientsText;
    }
}
