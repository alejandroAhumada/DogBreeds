package com.alejandro.dogbreeds.ui.ActivityListBreeds;

import android.content.Intent;
import android.view.ViewGroup;

import com.alejandro.dogbreeds.ui.ActivityListBreeds.view.ActivityListBreeds;
import com.alejandro.dogbreeds.ui.ActivityListBreeds.view.RecyclerView.RecyclerViewHolder;
import com.alejandro.dogbreeds.util.Delegate;

import java.util.ArrayList;

public interface InterfaceListBreeds {

    interface View{

        ActivityListBreeds getActivityContext();

        void startActivities(Intent intent);
        void notifyDataSetChanged();
        void initProgressBar();
        void stopProgressBar();
    }

    interface Presenter{

        void setView(InterfaceListBreeds.View view);
        void setModel(InterfaceListBreeds.Model model);
        void getListBreeds();

        InterfaceListBreeds.View getView();

        RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i);
        void onBindViewHolder(RecyclerViewHolder recyclerViewHolder, int i);
        int getItemCount();
    }

    interface Model{

        void getListBreeds(Delegate<ArrayList<String>> delegate);
    }

}
