package com.yanus.chucknorrisjokes.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.yanus.chucknorrisjokes.R;
import com.yanus.chucknorrisjokes.RecyclerListCategoryAdapter;
import com.yanus.chucknorrisjokes.service.Service;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//2. Activity со списком категорий шуток.
public class ListJokeCategoriesActivity extends AppCompatActivity implements RecyclerListCategoryAdapter.OnNoteListener{
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_joke_categories);
        recyclerView = findViewById(R.id.recyclerCategory);

        Service.getRetrofitApi().getJokeCategory().enqueue(new Callback<ArrayList<String>>() {
            @Override
            public void onResponse(Call<ArrayList<String>> call, Response<ArrayList<String>> response) {
                ArrayList<String> arrayList = response.body();
                recyclerView.setLayoutManager(new LinearLayoutManager(ListJokeCategoriesActivity.this));
                recyclerView.setAdapter(new RecyclerListCategoryAdapter(ListJokeCategoriesActivity.this, arrayList, ListJokeCategoriesActivity.this));
            }

            @Override
            public void onFailure(Call<ArrayList<String>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onNoteClick(String category) {
        Intent intent = new Intent(ListJokeCategoriesActivity.this, JokeActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);

    }


}