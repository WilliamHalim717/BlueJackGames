package com.example.bluejackgames;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class GameDetailActivity extends AppCompatActivity {

    ImageView Image;
    TextView Title, Price, Desc, ReleaseDate;
    EditText Quantity;
    Button Buy_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        Intent intent = getIntent();
        String game = intent.getStringExtra("game");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);

        Image = findViewById(R.id.gameImage);
        Title = findViewById(R.id.txt_title);
        Price = findViewById(R.id.price);
        Desc = findViewById(R.id.desc);
        ReleaseDate = findViewById(R.id.releaseDate);

        Buy_btn = findViewById(R.id.buy_btn);

        if(game.equals("genshin")){
            Image.setImageResource(R.drawable.genshin);
            Title.setText("Genshin Impact");
            Price.setText("Rp 50.000");
            Desc.setText("Genshin Impact is an action role-playing game developed and published by video game company miHoYo. It was released for Microsoft Windows, Playstation 4, iOS, and Android in 2020, and on Playstation 5 in 2021. The game is also set for release on Nintendo Switch. The game features an anime-style open-world environment and an action-based battle system using elemental magic and character-switching.");
            ReleaseDate.setText("September 28, 2020");
        }
        else if(game.equals("rox")){
            Image.setImageResource(R.drawable.rox);
            Title.setText("Ragnarok X: Next Generation");
            Price.setText("Rp 75.000");
            Desc.setText("Ragnarok X: Next Generation is a mobile MMORPG which has been hyped since its launch in China a year ago, and now finally launched in Southeast Asia last month. Publisher Nuverse might be a new name to most, but it has already launched several mobile titles all around Asia. Here, we will take a quick look at what players will experience when they play Ragnarok X: New Generation for the very first time!");
            ReleaseDate.setText("June 18, 2021");
        }
        else if(game.equals("elden")){
            Image.setImageResource(R.drawable.elden);
            Title.setText("ELDEN RING");
            Price.setText("Rp 599.000");
            Desc.setText("Elden Ring is an action role-playing game developed by FromSoftware and published by Bandai Namco Entertainment. The game was directed by Hidetaka Miyazaki and made in collaboration with fantasy novelist George R. R. Martin, who provided material for the game's setting. It was released for Microsoft Windows, PlayStation 4, PlayStation 5, Xbox One, and Xbox Series X/S on February 25, 2022.");
            ReleaseDate.setText("February 25, 2022");
        }
        else if(game.equals("titanfall")){
            Image.setImageResource(R.drawable.titan);
            Title.setText("Titanfall® 2");
            Price.setText("Rp 379.000");
            Desc.setText("Titanfall 2 is a first-person shooter video game, developed by Respawn Entertainment and published by Electronic Arts. A sequel to 2014's Titanfall, the game was released worldwide on October 28, 2016, for Windows, PlayStation 4, and Xbox One. In Titanfall 2, players control Titans, mecha-style exoskeletons and their pilots, who are agile and equipped with a variety of skills ranging from wall-running to cloaking.");
            ReleaseDate.setText("October 28, 2016");
        }
        else if(game.equals("forza")){
            Image.setImageResource(R.drawable.forza5);
            Title.setText("Forza Horizon 5");
            Price.setText("Rp 699.000");
            Desc.setText("Forza Horizon 5 is a 2021 racing video game developed by Playground Games and published by Xbox Game Studios. It is the fifth Forza Horizon title and twelfth main instalment in the Forza series. The game is set in a fictionalised representation of Mexico. It was released on 9 November 2021 for Microsoft Windows, Xbox One, and Xbox Series X/S.");
            ReleaseDate.setText("November 4, 2021");
        }

        Buy_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Quantity = findViewById(R.id.quantity);
                Editable qty = Quantity.getText();
                String qtyNotNull = "";
                if(qty != null){
                    qtyNotNull = qty.toString();
                }
                if(qtyNotNull.equals("")){
                    Toast.makeText(GameDetailActivity.this, "Quantity must be filled", Toast.LENGTH_SHORT).show();
                }
                else if(Integer.parseInt(qtyNotNull) <= 0){
                    AlertDialog.Builder dialog = new AlertDialog.Builder(GameDetailActivity.this);
                    dialog.setTitle("Addition Message");
                    dialog.setMessage("Quantity must be equal or more than 1");
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.show();
                }
                else{
                    AlertDialog.Builder dialog = new AlertDialog.Builder(GameDetailActivity.this);
                    dialog.setTitle("Addition Message");
                    dialog.setMessage("Your purchase was successful");
                    dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    });
                    dialog.show();
                }
            }
        });
    }
}