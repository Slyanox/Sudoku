package com.mesny.valentin.sudoku;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonlvl1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonlvl1 = (Button) findViewById(R.id.buttonlvl1);
        buttonlvl1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openChoixGrille();
            }
        });
    }

    public void openChoixGrille(){
        Intent intent = new Intent(this, ChoixGrille.class);
        startActivity(intent);
    }
}
