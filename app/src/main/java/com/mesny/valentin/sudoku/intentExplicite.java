package com.mesny.valentin.sudoku;

import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Valentin on 25/04/2018.
 */

public class intentExplicite extends Activity implements View.OnClickListener {
    /*! * Cette variable permettra de conserver une référence sur le! bouton! */
    private Button mButton;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton = (Button)
                findViewById(R.id.buttonlvl1);
        mButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v == mButton) {
            /* * Nous sommes maintenant sûr que la vue ayant été!!!!!!! cliquée est le bouton * de notre interface.
            Il suffit donc de créer un nouvel Intent pour démarrer * la seconde activité. */
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, "Mot à chercher");
            // query contains search string!!!startActivity(intent);!!}!}
        }
    }
}
