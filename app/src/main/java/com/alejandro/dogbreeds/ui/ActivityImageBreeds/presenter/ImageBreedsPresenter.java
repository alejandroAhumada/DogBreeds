package com.alejandro.dogbreeds.ui.ActivityImageBreeds.presenter;

import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alejandro.dogbreeds.R;
import com.alejandro.dogbreeds.app.GlideApp;
import com.alejandro.dogbreeds.ui.ActivityImageBreeds.InterfaceImageBreeds;
import com.alejandro.dogbreeds.ui.ActivityImageBreeds.view.RecyclerView.RecyclerViewHolderImages;
import com.alejandro.dogbreeds.util.Delegate;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.ArrayList;

public class ImageBreedsPresenter implements InterfaceImageBreeds.Presenter {

    private InterfaceImageBreeds.View view;
    private InterfaceImageBreeds.Model model;

    private ArrayList<String> listImagesBreeds;

    @Override
    public void setView(InterfaceImageBreeds.View view) {
        if (this.view == null) {
            this.view = view;
        }
    }

    @Override
    public void setModel(InterfaceImageBreeds.Model model) {
        if (this.model == null) {
            this.model = model;
        }
    }

    @Override
    public void getImagesBreeds() {
        model.getListImageBreeds(view.getName_breed(), delegate);
    }

    Delegate<ArrayList<String>> delegate = new Delegate<ArrayList<String>>() {
        @Override
        public void execute(ArrayList<String> response, Exception e) {

            if (response != null) {
                listImagesBreeds = response;
                view.notifyDataSetChanged();
            }
        }
    };

    @Override
    public InterfaceImageBreeds.View getView() {
        return view;
    }

    @Override
    public RecyclerViewHolderImages onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_image_breeds, viewGroup, false);
        RecyclerViewHolderImages viewHolder = new RecyclerViewHolderImages(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewHolderImages holder, int position) {


        GlideApp.with(view.getActivityContext())
                .load(listImagesBreeds.get(position))
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {

                        holder.progress_bar.setVisibility(View.INVISIBLE);

                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {

                        holder.progress_bar.setVisibility(View.INVISIBLE);
                        holder.image.setVisibility(View.VISIBLE);

                        return false;
                    }
                })
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        if (listImagesBreeds == null) {
            return 0;
        }

        return listImagesBreeds.size();
    }
}
