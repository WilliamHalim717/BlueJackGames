package com.example.bluejackgames;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class ProductPageActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "keyname";

    CardView genshin, rox, elden, titanfall, forza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_page);
        setTitle("Product Page");

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        genshin = findViewById(R.id.genshin_card);
        rox = findViewById(R.id.rox_card);
        elden = findViewById(R.id.elden_card);
        titanfall = findViewById(R.id.titanfall_card);
        forza  = findViewById(R.id.forza_card);

        genshin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductPageActivity.this, GameDetailActivity.class);
                intent.putExtra("game", "genshin");
                startActivity(intent);
            }
        });

        rox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductPageActivity.this, GameDetailActivity.class);
                intent.putExtra("game", "rox");
                startActivity(intent);
            }
        });

        elden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductPageActivity.this, GameDetailActivity.class);
                intent.putExtra("game", "elden");
                startActivity(intent);
            }
        });

        titanfall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductPageActivity.this, GameDetailActivity.class);
                intent.putExtra("game", "titanfall");
                startActivity(intent);
            }
        });

        forza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductPageActivity.this, GameDetailActivity.class);
                intent.putExtra("game", "forza");
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.hamburger, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home_page:
                Intent intent1 = new Intent(ProductPageActivity.this, HomePageActivity.class);
                startActivity(intent1);
                return true;
            case R.id.about_page:
                Intent intent2 = new Intent(ProductPageActivity.this, AboutPageActivity.class);
                startActivity(intent2);
                return true;
            case R.id.logout_page:
                Intent intent3 = new Intent(ProductPageActivity.this, MainActivity.class);
                startActivity(intent3);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}