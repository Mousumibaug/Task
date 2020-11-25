package com.example.musictask;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class music extends Fragment {
    private static final String TAG = "Music";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.music, container, false);

        final Intent i = new Intent(getActivity(), album.class);
        Button b = (Button) view.findViewById(R.id.music1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView retro=(TextView)view.findViewById(R.id.retro);
                String title=retro.getText().toString();
                i.putExtra("a",title);
                startActivity(i);
            }
        });

        final Intent i2 = new Intent(getActivity(), album.class);
        Button b2 = (Button) view.findViewById(R.id.music2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView rock=(TextView)view.findViewById(R.id.rock);
                String title2=rock.getText().toString();
                i2.putExtra("a",title2);
                startActivity(i2);
            }
        });

        return view;
    }
}

