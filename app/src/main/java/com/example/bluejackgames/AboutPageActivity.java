package com.example.bluejackgames;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class AboutPageActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "keyname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_page);
        setTitle("About Page");

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.hamburger, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent intent = getIntent();
        String username = intent.getStringExtra("username");
        switch (item.getItemId()){
            case R.id.home_page:
                Intent intent1 = new Intent(AboutPageActivity.this, HomePageActivity.class);
                //intent1.putExtra("username", username);
                startActivity(intent1);
                return true;
            case R.id.about_page:
                Intent intent2 = new Intent(AboutPageActivity.this, AboutPageActivity.class);
                //intent2.putExtra("username", username);
                startActivity(intent2);
                return true;
            case R.id.logout_page:
                Intent intent3 = new Intent(AboutPageActivity.this, MainActivity.class);
                startActivity(intent3);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
}