package com.example.retrofit_t_1;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



import java.util.List;

import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;
    private String token = "Bearer BQBUZu5_Z1dEXDYjQ_T1X-LwkI2YnIDPGZuSSMI6JhpmI1J5TBYEdMO98uN" +
            "vTXMCK4M4uQSjfqsl-Ntj4pEdZgYkH1r0nnDeV24fHaEeZFpbPH19P8OOIt5jldp_ASYTElnoeV" +
            "9pRBAfcmexHHrRzIujNtSLC3uO64LqNTKoAnANEAHm9Rd3ul1nv1o0zA";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.spotify.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<Track> call = jsonPlaceHolderApi.getATrack();

        call.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {

                if(response.code()==401)
                    textViewResult.setText(response.errorBody().toString()+"401");
                else if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                Track track = response.body();

                if(response.body()==null)
                    textViewResult.setText("responce body = null");
                else if(track == null)
                    textViewResult.setText(response.body().toString()+" track = null");
                else
                    textViewResult.setText(track.getName());

            }

            @Override
            public void onFailure(Call<Track> call, Throwable t) {
                textViewResult.setText(t.getMessage()+"failed");
            }
        });


    }
}