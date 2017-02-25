package com.example.lenovo.okhttp;

import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

/**
 * Created by lenovo on 2017/2/25.
 */
public class OkHttpHandler extends AsyncTask {

    OkHttpClient client=new OkHttpClient();

    @Override
    protected Object doInBackground(Object[] params) {
        Request.Builder builder=new Request.Builder();
        builder.url((String) params[0]);
        Request request=builder.build();
        Response response= null;
        try {
            response = client.newCall(request).execute();
            return response.body().bytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
