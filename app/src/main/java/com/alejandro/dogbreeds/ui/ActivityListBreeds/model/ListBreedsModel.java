package com.alejandro.dogbreeds.ui.ActivityListBreeds.model;

import com.alejandro.dogbreeds.R;
import com.alejandro.dogbreeds.Retrofit.RetrofitFactory;
import com.alejandro.dogbreeds.Retrofit.Service.ListBreedsService;
import com.alejandro.dogbreeds.domain.Breeds;
import com.alejandro.dogbreeds.ui.ActivityListBreeds.InterfaceListBreeds;
import com.alejandro.dogbreeds.ui.ActivityListBreeds.view.ActivityListBreeds;
import com.alejandro.dogbreeds.util.Delegate;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListBreedsModel implements InterfaceListBreeds.Model{

    private InterfaceListBreeds.Presenter presenter;
    private ActivityListBreeds  activityContext;

    public ListBreedsModel(InterfaceListBreeds.Presenter presenter) {
        this.presenter = presenter;
        this.activityContext = presenter.getView().getActivityContext();
    }

    public ListBreedsModel() {
    }

    @Override
    public void getListBreeds(final Delegate<ArrayList<String>> delegate) {

        RetrofitFactory retrofitFactory = new RetrofitFactory();
        ListBreedsService service = retrofitFactory.
                //getRetrofitInstance(activityContext.getString(R.string.ENDPOINT)).
                getRetrofitInstance("https://dog.ceo/").
                create(ListBreedsService.class);

        Call<Breeds> call = service.createResponseCall();
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
