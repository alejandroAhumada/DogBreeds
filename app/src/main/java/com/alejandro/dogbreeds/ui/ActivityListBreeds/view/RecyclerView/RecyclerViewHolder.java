package com.alejandro.dogbreeds.ui.ActivityListBreeds.view.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.alejandro.dogbreeds.R;

public class RecyclerViewHolder extends RecyclerView.ViewHolder{

    public CardView lyt_card_view;
    public TextView tv_name_breed;

    public RecyclerViewHolder(@NonNull View itemView) {
        super(itemView);

        lyt_card_view = itemView.findViewById(R.id.lyt_card_view);
        tv_name_breed = itemView.findViewById(R.id.tv_name_breed);
    }
}
