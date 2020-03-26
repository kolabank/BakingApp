package android.example.com.bakingapp;

import android.content.Intent;
import android.example.com.bakingapp.NetworkTools.Ingredients;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class IngredientsFragment extends Fragment {

    //Empty constructor of fragment
    public IngredientsFragment (){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_ingredients, container, false);



    }
}
