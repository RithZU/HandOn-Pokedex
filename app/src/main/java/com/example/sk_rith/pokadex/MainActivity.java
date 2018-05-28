package com.example.sk_rith.pokadex;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;


public class MainActivity extends AppCompatActivity {
    private static final int FRAME_DETAIL_ID = 10101010;

    private PokedexFragment pokedexFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pokedexFragment = new PokedexFragment();
        setFragment(pokedexFragment);
    }
    public void setFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.pokedex_frame,fragment);
        fragmentTransaction.commit();
    }
    public void PokemonDetail(View view)
    {
        String pokedexName = view.getTag().toString();


        //check current orientation of the screen
        //if it is in portrait
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
        {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("pokedexName",pokedexName);
            startActivity(intent);
        }
        
    }


}
