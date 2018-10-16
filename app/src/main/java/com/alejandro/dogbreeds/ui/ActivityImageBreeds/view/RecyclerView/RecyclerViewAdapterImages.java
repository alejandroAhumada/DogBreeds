package com.alejandro.dogbreeds.ui.ActivityImageBreeds.view.RecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.alejandro.dogbreeds.ui.ActivityImageBreeds.InterfaceImageBreeds;

public class RecyclerViewAdapterImages extends RecyclerView.Adapter<RecyclerViewHolderImages> {

    private InterfaceImageBreeds.Presenter presenter;

    public RecyclerViewAdapterImages(InterfaceImageBreeds.Presenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public RecyclerViewHolderImages onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return presenter.onCreateViewHolder(viewGroup, i);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolderImages recyclerViewHolderImages, int i) {
        presenter.onBindViewHolder(recyclerViewHolderImages, i);
    }

    @Override
    public int getItemCount() {
        return presenter.getItemCount();
    }
}
