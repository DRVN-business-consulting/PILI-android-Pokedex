package com.example.pokemonjavatraining;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemonjavatraining.Adapter.PokemonListAdapter;
import com.example.pokemonjavatraining.Model.Pokemon;
import com.google.android.material.tabs.TabItem;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity {
    private RecyclerView pokemonListRecyclerView;
    ArrayList<Pokemon> pokemonList = new ArrayList<>();
    @SuppressLint({"MissingInflatedId", "NotifyDataSetChanged"})
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_homepage);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        pokemonListRecyclerView = findViewById(R.id.pokemonListRecyclerView);


        displayReplacement();


    }

    public void displayReplacement() {

        pokemonList.add(new Pokemon(1,"Eevee","Its ability to evolve into many forms allows it to adapt smoothly and perfectly to any environment.",R.drawable.eevee,"Normal"));
        pokemonList.add(new Pokemon(2,"Pikachu","When it is angered, it immediately discharges the energy stored in the pouches in its cheeks.",R.drawable.pikachu,"Electric"));
        pokemonList.add(new Pokemon(3,"Bulbasaur","For some time after its birth, it uses the nutrients that are packed into the seed on its back in order to grow.",R.drawable.bulbasaur,"Grass"));

        Log.e("POKEMONLIST", String.valueOf(pokemonList.size()));

        pokemonListRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        pokemonListRecyclerView.setItemAnimator(new DefaultItemAnimator());
        PokemonListAdapter pokemonListAdapter = new PokemonListAdapter(this, pokemonList);
        pokemonListAdapter.notifyDataSetChanged();
        pokemonListRecyclerView.setAdapter(pokemonListAdapter);
    }
}
