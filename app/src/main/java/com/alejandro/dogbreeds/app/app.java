package com.alejandro.dogbreeds.app;

import android.app.Application;

import com.alejandro.dogbreeds.R;
import com.bumptech.glide.request.target.ViewTarget;

import okhttp3.OkHttpClient;

public class app extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        ViewTarget.setTagId(R.id.glide_tag);
    }

}
