package com.example.sk_rith.pokadex;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.Scanner;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private String name;
    private ImageView pokemon_image;
    private TextView pokemon_name,pokemon_detail;
    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        name = getArguments().getString("name");
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        pokemon_image = (ImageView) getActivity().findViewById(R.id.pokedex_image);
        pokemon_name = (TextView) getActivity().findViewById(R.id.pokedex_name);
        pokemon_detail = (TextView) getActivity().findViewById(R.id.pokedex_detail);

        Intent intent = getActivity().getIntent();
        String pokedexName = intent.getStringExtra("pokedexName");
        Log.d("Pokedex Name","Hello");
        pokemon_name.setText(pokedexName);
        int pokemonId = getResources().getIdentifier(name.toLowerCase(),"drawable",getActivity().getPackageName());
        int fileId = getResources().getIdentifier(name.toLowerCase(),"raw",getActivity().getPackageName());

        String pokemonDetail = "";
        InputStream source = getResources().openRawResource(fileId);
        Scanner scan = new Scanner(source);

        pokemon_image.setImageResource(pokemonId);
        while(scan.hasNextLine()){
            String line = scan.nextLine();
            pokemonDetail += line;

        }
        pokemon_detail.setText(pokemonDetail);
    }
}
