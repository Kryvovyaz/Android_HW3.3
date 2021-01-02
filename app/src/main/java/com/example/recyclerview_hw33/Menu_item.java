package com.example.recyclerview_hw33;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu_item extends AppCompatActivity {

    public String foodName;
    public String foodIntroText;
    public String recipeLongText;
    public int imageId;

    public Menu_item(String foodName, String foodIntroText, String recipeLongText, int imageId) {
        this.foodName = foodName;
        this.foodIntroText = foodIntroText;
        this.recipeLongText = recipeLongText;
        this.imageId = imageId;
    }
}

