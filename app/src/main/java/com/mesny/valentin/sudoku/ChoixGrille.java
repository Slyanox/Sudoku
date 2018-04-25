package com.mesny.valentin.sudoku;

import android.content.DialogInterface;
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

public class ChoixGrille extends AppCompatActivity {

    ListView listView;
    private String[] prenoms = new String[]{
            "Antoine", "Benoit", "Cyril", "David", "Eloise", "Florent",
            "Gerard", "Hugo", "Ingrid", "Jonathan", "Kevin", "Logan",
            "Mathieu", "Noemie", "Olivia", "Philippe", "Quentin", "Romain",
            "Sophie", "Tristan", "Ulric", "Vincent", "Willy", "Xavier",
            "Yann", "Zoé"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_grille);

        /*
        // Construct the data source
        ArrayList<vGrille> arrayOfGrilles = new ArrayList<vGrille>();
        // Create the adapter to convert the array to views
        vGrilleAdapter adapter = new vGrilleAdapter(this, arrayOfGrilles);
        vGrille newGrille = new vGrille(1, 2, 3);
        adapter.add(newGrille);
        // Attach the adapter to a ListView
        listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);*/

        /*listView = (ListView) findViewById(R.id.listView);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(ChoixGrille.this,
                android.R.layout.simple_list_item_1, prenoms);
        listView.setAdapter(adapter);*/


        listView = (ListView) findViewById(R.id.listView);



        ArrayList<vGrille> grilles = genererGrilles();

        vGrilleAdapter adapter = new vGrilleAdapter(ChoixGrille.this, grilles);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                vGrille selectedGrille = (vGrille) listView.getItemAtPosition(position);
                AlertDialog alertDialog = new AlertDialog.Builder(ChoixGrille.this).create();
                alertDialog.setTitle("Alert");
                alertDialog.setMessage("" + selectedGrille.getNum() + " -- " + selectedGrille.getDone() + " %");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Start",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }
        });
    }

    private ArrayList<vGrille> genererGrilles(){
        ArrayList<vGrille> grilles = new ArrayList<vGrille>();
        grilles.add(new vGrille(1,1,3));
        grilles.add(new vGrille(1,2,3));
        grilles.add(new vGrille(1,2,3));
        grilles.add(new vGrille(1,2,3));
        grilles.add(new vGrille(1,2,3));
        grilles.add(new vGrille(1,2,3));
        return grilles;
    }


}
