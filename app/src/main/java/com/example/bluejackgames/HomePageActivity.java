package com.example.bluejackgames;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomePageActivity extends AppCompatActivity {

    TextView product, about, logout;
    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "keyname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        String username = sharedPreferences.getString(KEY_NAME,null);
        if(username==null){
            Intent intent = new Intent(HomePageActivity.this,MainActivity.class);
            startActivity(intent);
        }

        //Toast.makeText(HomePageActivity.this, username , Toast.LENGTH_SHORT).show();
        //Intent intent = getIntent();
        //String username = intent.getStringExtra("username");
        setTitle("Welcome, " + username);

        product = findViewById(R.id.product_page);
        about = findViewById(R.id.about_page);
        logout = findViewById(R.id.logout_page);

        product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, ProductPageActivity.class);
                //intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, AboutPageActivity.class);
                //intent.putExtra("username", username);
                startActivity(intent);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomePageActivity.this, MainActivity.class);
                startActivity(intent);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
            }
        });
    }
}