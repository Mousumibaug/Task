package com.example.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class playertype extends AppCompatActivity {

    Button singleplayer,multiplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playertype);

        singleplayer=findViewById(R.id.singleplayer);
        multiplayer=findViewById(R.id.multiplayer);

        singleplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(playertype.this,levels.class);
                startActivity(in);
            }
        });

        multiplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(playertype.this,multiname.class);
                startActivity(in);
            }
        });
    }
}
