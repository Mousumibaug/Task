package com.example.memorygame;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class multiname extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiname);
    }

    public void ok(View v){
        EditText etp1=(EditText)findViewById(R.id.etp1);
        EditText etp2=(EditText)findViewById(R.id.etp2);
        final String p1=etp1.getText().toString();
        final String p2=etp2.getText().toString();

        if(p1.length()==0)
        {
            etp1.requestFocus();
            etp1.setError("Please enter name");
        }
        else if(!p1.matches("[a-zA-Z]+"))
        {
            etp1.requestFocus();
            etp1.setError("Enter only alphabetical characters");
        }
        else if(p2.length()==0)
        {
            etp2.requestFocus();
            etp2.setError("Please enter name");
        }
        else if(!p2.matches("[a-zA-Z]+"))
        {
            etp2.requestFocus();
            etp2.setError("Enter only alphabetical characters");
        }
        else {
            Intent in = new Intent(this, multiplayergame.class);
            in.putExtra("name1", p1);
            in.putExtra("name2", p2);
            startActivity(in);
        }
    }
}
