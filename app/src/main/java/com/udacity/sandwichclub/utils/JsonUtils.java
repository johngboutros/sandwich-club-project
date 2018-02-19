package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        // Declare variables for Sandwich data
        String mainName = null;
        List<String> alsoKnownAs = new ArrayList<String>();
        String placeOfOrigin = null;
        String description = null;
        String image = null;
        List<String> ingredients = new ArrayList<String>();

        try {

            JSONObject jsonObject = new JSONObject(json);

            // Populate Name data
            JSONObject nameObject = jsonObject.getJSONObject("name");

            if (nameObject != null) {

                mainName = nameObject.getString("mainName");

                JSONArray alsoKnownAsJsArray = nameObject.getJSONArray("alsoKnownAs");

                if (alsoKnownAs != null) {
                    for (int i = 0; i < alsoKnownAsJsArray.length(); i++) {
                        alsoKnownAs.add(alsoKnownAsJsArray.getString(i));
                    }
                }
            }

            // Populate Other data
            placeOfOrigin = jsonObject.getString("placeOfOrigin");
            description = jsonObject.getString("description");
            image = jsonObject.getString("image");

            // Populate Ingredients
            JSONArray ingredientsJsArray = jsonObject.getJSONArray("ingredients");

            if (ingredientsJsArray != null) {
                for (int i = 0; i < ingredientsJsArray.length(); i++) {
                    ingredients.add(ingredientsJsArray.getString(i));
                }
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
    }
}
