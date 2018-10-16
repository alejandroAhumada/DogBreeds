package com.alejandro.dogbreeds.ui.ActivityListBreeds.presenter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alejandro.dogbreeds.R;
import com.alejandro.dogbreeds.ui.ActivityImageBreeds.view.ActivityImageBreeds;
import com.alejandro.dogbreeds.ui.ActivityListBreeds.InterfaceListBreeds;
import com.alejandro.dogbreeds.ui.ActivityListBreeds.view.RecyclerView.RecyclerViewHolder;
import com.alejandro.dogbreeds.util.Delegate;

import java.util.ArrayList;

public class ListBreedsPresenter implements InterfaceListBreeds.Presenter{

    private InterfaceListBreeds.View view;
    private InterfaceListBreeds.Model model;

    private ArrayList<String> listNameBreeds;

    @Override
    public void setView(InterfaceListBreeds.View view) {
        if(this.view == null){
            this.view = view;
        }
    }

    @Override
    public void setModel(InterfaceListBreeds.Model model) {
        if(this.model == null){
            this.model = model;
        }
    }

    @Override
    public void getListBreeds() {
        model.getListBreeds(delegate);
    }

    Delegate<ArrayList<String>> delegate = new Delegate<ArrayList<String>>() {
        @Override
        public void execute(ArrayList<String> response, Exception e) {

            if(response != null){
                setListBreeds(response);
            }
        }
    };

    public void setListBreeds(ArrayList<String> response){
        listNameBreeds = response;
        view.notifyDataSetChanged();
        view.stopProgressBar();
    }

    @Override
    public InterfaceListBreeds.View getView() {
        return view;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_name_breeds, viewGroup, false);
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int i) {

        holder.tv_name_breed.setText(listNameBreeds.get(i));
        holder.lyt_card_view.setOnClickListener(clickListener(i));
    }

    private View.OnClickListener clickListener(final int position){

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View views) {

                Intent intent = new Intent(view.getActivityContext(),ActivityImageBreeds.class);
                intent.putExtra(view.getActivityContext().getString(R.string.NAME), listNameBreeds.get(position));

                view.startActivities(intent);
            }
        };

        return onClickListener;
    }

    @Override
    public int getItemCount() {
        if(listNameBreeds == null){
            return 0;
        }

        return listNameBreeds.size();
    }
}
