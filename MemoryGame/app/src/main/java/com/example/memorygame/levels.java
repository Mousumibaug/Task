package com.example.memorygame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class levels extends AppCompatActivity {

    EditText etpn1;
    Spinner sp;
    String SpinnerValue;
    Button btnok;
    Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        etpn1 = (EditText) findViewById(R.id.etpn1);
        sp = (Spinner) findViewById(R.id.level);
        btnok=(Button)findViewById(R.id.btnok);

        ArrayAdapter adp = ArrayAdapter.createFromResource(this, R.array.level, android.R.layout.simple_spinner_item);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adp);

        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerValue=(String)sp.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etpn1 = (EditText) findViewById(R.id.etpn1);
                final String p = etpn1.getText().toString();

                if(p.length()==0)
                {
                    etpn1.requestFocus();
                    etpn1.setError("Please enter name");
                }
                else if(!p.matches("[a-zA-Z]+"))
                {
                    etpn1.requestFocus();
                    etpn1.setError("Enter only alphabetical characters");
                }
                else {

                    switch (SpinnerValue) {
                        case "EASY":
                            in = new Intent(levels.this, MainActivity.class);
                            in.putExtra("namesp", p);
                            startActivity(in);
                            break;
                        case "MEDIUM":
                            in = new Intent(levels.this, medium.class);
                            in.putExtra("namesp", p);
                            startActivity(in);
                            break;
                        case "HARD":
                            in = new Intent(levels.this, hard.class);
                            in.putExtra("namesp", p);
                            startActivity(in);
                            break;
                    }
                }
            }
        });
    }
}