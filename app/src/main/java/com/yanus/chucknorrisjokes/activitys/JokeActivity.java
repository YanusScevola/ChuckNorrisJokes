package com.yanus.chucknorrisjokes.activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.yanus.chucknorrisjokes.model.JokesModel;
import com.yanus.chucknorrisjokes.R;
import com.yanus.chucknorrisjokes.service.Service;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//3. Activity с шутками.
public class JokeActivity extends AppCompatActivity {
    String joke;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_list);

        textView = findViewById(R.id.textJoke);
        String s = getIntent().getStringExtra("category");

        if (savedInstanceState != null) {
            joke = savedInstanceState.getString("joke");
            textView.setText(savedInstanceState.getString("joke"));

        }

        Service.getRetrofitApi().getJokeByCategory(s).enqueue(new Callback<JokesModel>() {
            @Override
            public void onResponse(Call<JokesModel> call, Response<JokesModel> response) {
                if (savedInstanceState == null) {
                    joke = response.body().getValue();
                    textView.setText(joke);
                }

            }

            @Override
            public void onFailure(Call<JokesModel> call, Throwable t) {

            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("joke", joke);

    }
}