package com.example.recyclerview_hw33;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    public static final ArrayList<Menu_item> recipeList = new ArrayList<>();
    public static final String EXTRA_POSITION = "MainActivity.extra.holder.position";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        populateRecipeList();
        //  View.OnClickListener listener = view -> onClickViewHolderAction(view);

        MenuListAdapter menu_adapter = new MenuListAdapter(recipeList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(menu_adapter);

        menu_adapter.setMenuViewClickListener(new MenuViewClickListener() {
            @Override
            public void onClick(int position) {

                Toast.makeText(getApplicationContext(), "Position: " + position + " clicked.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getApplicationContext(), Menu_Detailed.class);
                intent.putExtra(EXTRA_POSITION, position);
                startActivity(intent);
            }
        });

    }

    public void populateRecipeList() {
        String[] foodNames = getResources().getStringArray(R.array.food_names);
        String[] foodIntros = getResources().getStringArray(R.array.food_intros);
        String recipeLongText = getResources().getString(R.string.whole_recipe_sample);
        String[] imageTitles = getResources().getStringArray(R.array.food_images);

        for (int i = 0; i < foodNames.length; i++) {
            int imageId = getResources().getIdentifier(imageTitles[i], "drawable", getPackageName());
            recipeList.add(new Menu_item(foodNames[i], foodIntros[i], recipeLongText, imageId));
        }
    }
}