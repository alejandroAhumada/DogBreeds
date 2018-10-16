package com.alejandro.dogbreeds.ui.ActivityImageBreeds.model;

import com.alejandro.dogbreeds.R;
import com.alejandro.dogbreeds.Retrofit.RetrofitFactory;
import com.alejandro.dogbreeds.Retrofit.Service.ImageBreedsService;
import com.alejandro.dogbreeds.Retrofit.Service.ListBreedsService;
import com.alejandro.dogbreeds.domain.Breeds;
import com.alejandro.dogbreeds.ui.ActivityImageBreeds.InterfaceImageBreeds;
import com.alejandro.dogbreeds.ui.ActivityImageBreeds.view.ActivityImageBreeds;
import com.alejandro.dogbreeds.util.Delegate;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ImageBreedsModel implements InterfaceImageBreeds.Model{

    private InterfaceImageBreeds.Presenter presenter;
    private ActivityImageBreeds activityContext;

    public ImageBreedsModel(InterfaceImageBreeds.Presenter presenter) {
        this.presenter = presenter;
        this.activityContext = presenter.getView().getActivityContext();
    }

    @Override
    public void getListImageBreeds(String nameBreed, final Delegate<ArrayList<String>> delegate) {

        RetrofitFactory retrofitFactory = new RetrofitFactory();
        ImageBreedsService service = retrofitFactory.
                getRetrofitInstance(activityContext.getString(R.string.ENDPOINT)).
                create(ImageBreedsService.class);

        Call<Breeds> call = service.createResponseCall(nameBreed);
        call.enqueue(new Callback<Breeds>() {
            @Override
            public void onResponse(Call<Breeds> call, Response<Breeds> response) {
                if(response.body().getStatus().equalsIgnoreCase(activityContext.getString(R.string.SUCCESS))){
                    delegate.execute(response.body().getMessage(), new Exception());
                }
            }

            @Override
            public void onFailure(Call<Breeds> call, Throwable t) {
                delegate.execute(null, new Exception());
            }
        });

    }
}
