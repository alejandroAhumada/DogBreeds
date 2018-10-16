package com.alejandro.dogbreeds.ui.ActivityImageBreeds.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.alejandro.dogbreeds.R;
import com.alejandro.dogbreeds.ui.ActivityImageBreeds.InterfaceImageBreeds;
import com.alejandro.dogbreeds.ui.ActivityImageBreeds.model.ImageBreedsModel;
import com.alejandro.dogbreeds.ui.ActivityImageBreeds.presenter.ImageBreedsPresenter;
import com.alejandro.dogbreeds.ui.ActivityImageBreeds.view.RecyclerView.RecyclerViewAdapterImages;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ActivityImageBreeds extends AppCompatActivity implements InterfaceImageBreeds.View{

    @BindView(R.id.recycler_view_image_breeds) RecyclerView recycler_view_list_name;

    private RecyclerViewAdapterImages recyclerViewAdapter;
    private LinearLayoutManager mLinearLayoutManager;

    private String name_breed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_breeds);

        initComponent();

    }

    @Override
    public String getName_breed() {
        return name_breed;
    }

    private void initComponent(){
        ButterKnife.bind(this);

        name_breed = getIntent().getStringExtra(getString(R.string.NAME));
        setTitle(name_breed);
        ImageBreedsPresenter presenter = new ImageBreedsPresenter();
        presenter.setView(this);

        ImageBreedsModel model = new ImageBreedsModel(presenter);
        presenter.setModel(model);

        mLinearLayoutManager = new LinearLayoutManager(this);
        recyclerViewAdapter = new RecyclerViewAdapterImages(presenter);

        recycler_view_list_name.setLayoutManager(mLinearLayoutManager);
        recycler_view_list_name.setAdapter(recyclerViewAdapter);

        recycler_view_list_name.setDrawingCacheEnabled(false);
        recycler_view_list_name.setHasFixedSize(true);
        recycler_view_list_name.setItemAnimator(new DefaultItemAnimator());

        presenter.getImagesBreeds();
    }

    @Override
    public ActivityImageBreeds getActivityContext() {
        return ActivityImageBreeds.this;
    }

    @Override
    public void notifyDataSetChanged() {
        recyclerViewAdapter.notifyDataSetChanged();
    }
}
