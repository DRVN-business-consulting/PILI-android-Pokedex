package com.example.pokemonjavatraining;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.pokemonjavatraining.Model.Pokemon;

import java.util.ArrayList;

public class PokemonDetailsActivity extends AppCompatActivity {
    ArrayList<Pokemon> pokemons = new ArrayList<>();
    TextView textName, textDescription, textType;
    LinearLayout linearLayout;
    ImageView imageBig;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pokemondetails);

        textName = findViewById(R.id.textName);
        textDescription = findViewById(R.id.textDescription);
        textType = findViewById(R.id.textType);
        linearLayout = findViewById(R.id.linearLayout);
        imageBig = findViewById(R.id.imageBig);

        int id = getIntent().getIntExtra("id", -1);

        ArrayList<Pokemon> pokemons = new ArrayList<>();

        pokemons.add(new Pokemon(1,"Eevee","Its ability to evolve into many forms allows it to adapt smoothly and perfectly to any environment.",R.drawable.eevee,"Normal"));
        pokemons.add(new Pokemon(2,"Pikachu","When it is angered, it immediately discharges the energy stored in the pouches in its cheeks.",R.drawable.pikachu,"Electric"));
        pokemons.add(new Pokemon(3,"Bulbasaur","For some time after its birth, it uses the nutrients that are packed into the seed on its back in order to grow.",R.drawable.bulbasaur,"Grass"));

        for( int i = 0; i < pokemons.size(); i++){
            if(pokemons.get(i).getId() == id){
                textName.setText(pokemons.get(i).getName());
                textDescription.setText(pokemons.get(i).getDescription());
                textType.setText(pokemons.get(i).getType());

                Drawable drawable = ContextCompat.getDrawable(this, pokemons.get(i).getImage());
                imageBig.setImageDrawable(drawable);

                if (pokemons.get(i).getType().equals("Grass")){
                    linearLayout.setBackgroundColor(Color.GREEN);
                }else if (pokemons.get(i).getType().equals("Electric")){
                    linearLayout.setBackgroundColor(Color.YELLOW);
                }else{
                    linearLayout.setBackgroundColor(Color.TRANSPARENT);
                }
            }
        }

    }
}
