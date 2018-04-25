package com.mesny.valentin.sudoku;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChoixGrille extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_grille);

        listView = (ListView) findViewById(R.id.listView);

        ArrayList<vGrille> grilles = genererGrilles();

        vGrilleAdapter adapter = new vGrilleAdapter(ChoixGrille.this, grilles);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                vGrille selectedGrille = (vGrille) listView.getItemAtPosition(position);
                AlertDialog alertDialog = new AlertDialog.Builder(ChoixGrille.this).create();
                alertDialog.setTitle("Game");
                alertDialog.setMessage("" + selectedGrille.getNum() + " -- " + selectedGrille.getDone() + " %");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Start",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                openGrille();
                            }
                        });
                alertDialog.show();
            }
        });
    }

    private ArrayList<vGrille> genererGrilles(){
        ArrayList<vGrille> grilles = new ArrayList<vGrille>();
        Random random = new Random();
        grilles.add(new vGrille(1,1, random.nextInt(100)));
        grilles.add(new vGrille(1,2, random.nextInt(100)));
        grilles.add(new vGrille(1,3, random.nextInt(100)));
        grilles.add(new vGrille(1,4, random.nextInt(100)));
        grilles.add(new vGrille(1,5, random.nextInt(100)));
        grilles.add(new vGrille(1,6, random.nextInt(100)));
        return grilles;
    }

    public void openGrille(){
        Intent intent = new Intent(this, SudokuGrille.class);
        startActivity(intent);
    }

}
