package com.example.recyclerview_hw33;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Menu_Detailed extends AppCompatActivity {
    private ImageView image;
    private TextView recipeText;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu__detailed);
        image = findViewById(R.id.recipe_image);
        recipeText = findViewById(R.id.recipe_text);

        Intent intent = getIntent();
        position = intent.getIntExtra(MainActivity.EXTRA_POSITION, 0);

            image.setImageResource(MainActivity.recipeList.get(position).imageId);
            recipeText.setText(MainActivity.recipeList.get(position).recipeLongText);

    }
}