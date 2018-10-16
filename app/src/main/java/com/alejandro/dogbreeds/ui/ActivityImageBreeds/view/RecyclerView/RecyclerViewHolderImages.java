package com.alejandro.dogbreeds.ui.ActivityImageBreeds.view.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alejandro.dogbreeds.R;

public class RecyclerViewHolderImages extends RecyclerView.ViewHolder{

    public ImageView image;
    public ProgressBar progress_bar;

    public RecyclerViewHolderImages(@NonNull View itemView) {
        super(itemView);

        image = itemView.findViewById(R.id.image);
        progress_bar = itemView.findViewById(R.id.progress_bar);
    }
}
