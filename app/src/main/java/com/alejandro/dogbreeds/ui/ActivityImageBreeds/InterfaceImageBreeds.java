package com.alejandro.dogbreeds.ui.ActivityImageBreeds;

import android.view.ViewGroup;

import com.alejandro.dogbreeds.ui.ActivityImageBreeds.view.ActivityImageBreeds;
import com.alejandro.dogbreeds.ui.ActivityImageBreeds.view.RecyclerView.RecyclerViewHolderImages;
import com.alejandro.dogbreeds.ui.ActivityListBreeds.InterfaceListBreeds;
import com.alejandro.dogbreeds.util.Delegate;

import java.util.ArrayList;

public interface InterfaceImageBreeds {

    interface View{

        ActivityImageBreeds getActivityContext();
        String getName_breed();

        void notifyDataSetChanged();
    }

    interface Presenter{

        void setView(InterfaceImageBreeds.View view);
        void setModel(InterfaceImageBreeds.Model model);
        void getImagesBreeds();

        InterfaceImageBreeds.View getView();

        RecyclerViewHolderImages onCreateViewHolder(ViewGroup viewGroup, int i);

        void onBindViewHolder(RecyclerViewHolderImages recyclerViewHolderImages, int i);

        int getItemCount();
    }

    interface Model{

        void getListImageBreeds(String nameBreed, Delegate<ArrayList<String>> delegate);
    }
}
