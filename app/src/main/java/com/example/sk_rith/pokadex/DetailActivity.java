package com.example.sk_rith.pokadex;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;

public class DetailActivity extends AppCompatActivity {

    private DetailFragment detailFragment;
    private TextView pokemon_name;
    private TextView pokemon_detail;
    private ImageView pokemon_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("Detail Activity");
        detailFragment = new DetailFragment();
        setFragment(detailFragment);


        Intent intent = getIntent();
        String pokedexName = intent.getStringExtra("pokedexName");
        Bundle b = new Bundle();
        b.putString("name",pokedexName);
        detailFragment.setArguments(b);
//        pokemon_image = (ImageView) findViewById(R.id.pokedex_image);
//        pokemon_name = (TextView) findViewById(R.id.pokedex_name);
//        pokemon_detail = (TextView) findViewById(R.id.pokedex_detail);
//        Log.d("Pokedex Name","Hello");
//        pokemon_name.setText(pokedexName);
//        int pokemonId = getResources().getIdentifier(pokedexName.toLowerCase(),"drawable",getPackageName());
//        int fileId = getResources().getIdentifier(pokedexName.toLowerCase(),"raw",getPackageName());
//
//        String pokemonDetail = "";
//        InputStream source = getResources().openRawResource(fileId);
//        Scanner scan = new Scanner(source);
//
//        pokemon_image.setImageResource(pokemonId);
//        while(scan.hasNextLine()){
//            String line = scan.nextLine();
//            pokemonDetail += line;
//
//        }
//        pokemon_detail.setText(pokemonDetail);

    }
    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.detail_frame,fragment);
        fragmentTransaction.commit();

    }
}
