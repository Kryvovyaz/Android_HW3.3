package com.example.recyclerview_hw33;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MenuListAdapter extends RecyclerView.Adapter<MenuListAdapter.MenuViewHolder> {
    private MenuViewClickListener menuViewClickListener;

    private ArrayList<Menu_item> recipeList = new ArrayList<>();

    public MenuListAdapter(ArrayList<Menu_item>recipeList) {
        this.recipeList = recipeList;
    }

    public void setMenuViewClickListener(MenuViewClickListener menuViewClickListener) {
        this.menuViewClickListener = menuViewClickListener;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_short, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.textViewFoodName.setText(MainActivity.recipeList.get(position).foodName);
        holder.textViewFoodIntro.setText(MainActivity.recipeList.get(position).foodIntroText);
        holder.imageView.setImageResource(MainActivity.recipeList.get(position).imageId);

    }

    @Override
    public int getItemCount() {
        return MainActivity.recipeList.size();
    }

    public class MenuViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textViewFoodName;
        TextView textViewFoodIntro;

        public MenuViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textViewFoodIntro =itemView.findViewById(R.id.food_intro_label);
            textViewFoodName = itemView.findViewById(R.id.food_name_label);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   // Toast.makeText(view.getContext(),"Position: " + getAdapterPosition() + " clicked." , Toast.LENGTH_SHORT).show();
                   menuViewClickListener.onClick(getAdapterPosition());

                }
            });
        }
    }
}


