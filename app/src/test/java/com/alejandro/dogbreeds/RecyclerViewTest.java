package com.alejandro.dogbreeds;

import com.alejandro.dogbreeds.ui.ActivityListBreeds.model.ListBreedsModel;
import com.alejandro.dogbreeds.ui.ActivityListBreeds.presenter.ListBreedsPresenter;
import com.alejandro.dogbreeds.ui.ActivityListBreeds.view.ActivityListBreeds;
import com.alejandro.dogbreeds.util.Delegate;

import org.junit.Test;

import java.util.ArrayList;

public class RecyclerViewTest {

    @Test
    public void testCountData(){
        ActivityListBreeds activityListBreeds = new ActivityListBreeds();
        ListBreedsPresenter listBreedsPresenter = new ListBreedsPresenter();
        ListBreedsModel listBreedsModel = new ListBreedsModel();

        listBreedsPresenter.setView(activityListBreeds);
        listBreedsPresenter.setModel(listBreedsModel);

        listBreedsModel.getListBreeds(new Delegate<ArrayList<String>>() {
            @Override
            public void execute(ArrayList<String> objectValue, Exception e) {


            }
        });

    }

    private ArrayList<String> getList(){

        ArrayList<String> strings = new ArrayList<>();

        strings.add("affenpinscher");
        strings.add("african");
        strings.add("airedale");
        strings.add("akita");

        return strings;
    }



}
