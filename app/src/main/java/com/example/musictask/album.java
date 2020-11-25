package com.example.musictask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class album extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);

        TextView tvtitle=(TextView)findViewById(R.id.tvtitle);
        String s=getIntent().getExtras().getString("a");
        tvtitle.setText(" "+s);

    }
}
