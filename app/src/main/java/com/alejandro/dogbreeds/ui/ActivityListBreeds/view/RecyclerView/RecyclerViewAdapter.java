package com.alejandro.dogbreeds.ui.ActivityListBreeds.view.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.alejandro.dogbreeds.ui.ActivityListBreeds.InterfaceListBreeds;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder>{

    private InterfaceListBreeds.Presenter presenter;

    public RecyclerViewAdapter(InterfaceListBreeds.Presenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return presenter.onCreateViewHolder(viewGroup, i);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder recyclerViewHolder, int i) {
        presenter.onBindViewHolder(recyclerViewHolder, i);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemCount();
    }
}
