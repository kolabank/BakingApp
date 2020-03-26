package android.example.com.bakingapp.NetworkTools;

import java.io.Serializable;

public class Ingredients implements Serializable {

    private float quantity;
    private String measure;
    private String ingredient;

    public Ingredients(int quantity, String measure, String ingredient) {
        this.quantity = quantity;
        this.measure = measure;
        this.ingredient = ingredient;
    }

    public float getQuantity() {
        return quantity;
    }

    public String getMeasure() {
        return measure;
    }

    public String getIngredient() {
        return ingredient;
    }
}
