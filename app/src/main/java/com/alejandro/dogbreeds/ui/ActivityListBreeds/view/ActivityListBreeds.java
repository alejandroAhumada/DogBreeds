package com.alejandro.dogbreeds.ui.ActivityListBreeds.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.alejandro.dogbreeds.R;
import com.alejandro.dogbreeds.ui.ActivityListBreeds.InterfaceListBreeds;
import com.alejandro.dogbreeds.ui.ActivityListBreeds.model.ListBreedsModel;
import com.alejandro.dogbreeds.ui.ActivityListBreeds.presenter.ListBreedsPresenter;
import com.alejandro.dogbreeds.ui.ActivityListBreeds.view.RecyclerView.RecyclerViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityListBreeds extends AppCompatActivity implements InterfaceListBreeds.View{

    @BindView(R.id.recycler_view_list_name) RecyclerView recycler_view_list_name;
    @BindView(R.id.progress_bar) ProgressBar progress_bar;


    private RecyclerViewAdapter recyclerViewAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_breeds);

        initComponent();

    }

    private void initComponent(){

        ButterKnife.bind(this);

        initProgressBar();

        ListBreedsPresenter presenter = new ListBreedsPresenter();
        presenter.setView(this);

        ListBreedsModel model = new ListBreedsModel(presenter);
        presenter.setModel(model);

        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerViewAdapter = new RecyclerViewAdapter(presenter);

        recycler_view_list_name.setLayoutManager(mLinearLayoutManager);
        recycler_view_list_name.setAdapter(recyclerViewAdapter);

        presenter.getListBreeds();
    }

    @Override
    public ActivityListBreeds getActivityContext() {
        return ActivityListBreeds.this;
    }

    @Override
    public void startActivities(Intent intent) {

        startActivity(intent);

    }

    @Override
    public void notifyDataSetChanged() {
        recyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void initProgressBar() {
        progress_bar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopProgressBar() {
        progress_bar.setVisibility(View.INVISIBLE);
    }
}
