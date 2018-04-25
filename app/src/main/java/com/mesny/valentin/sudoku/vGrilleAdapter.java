package com.mesny.valentin.sudoku;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Valentin on 25/04/2018.
 */

public class vGrilleAdapter extends ArrayAdapter<vGrille> {

    private final Context context;

    public vGrilleAdapter(Context context, ArrayList<vGrille> grilles) {
        super(context, 0, grilles);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_grille,parent, false);
        }

        ListViewHolder viewHolder = (ListViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ListViewHolder();
            viewHolder.id_grille = (TextView) convertView.findViewById(R.id.id_grille);
            viewHolder.level = (TextView) convertView.findViewById(R.id.level);
            viewHolder.pourcentage = (TextView) convertView.findViewById(R.id.pourcentage);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position]
        vGrille grille = getItem(position);

        //il ne reste plus qu'à remplir la vue
        assert grille != null;
        viewHolder.id_grille.setText("Sudoku : " + grille.getNum());
        viewHolder.level.setText("Level : " + grille.getLevel());
        viewHolder.pourcentage.setText("" + grille.getDone() + " %");
        if(grille.getDone() > 40){
            viewHolder.pourcentage.setTextColor(Color.GREEN);
        }
        else { viewHolder.pourcentage.setTextColor(Color.RED); }

        return convertView;
    }

    public class ListViewHolder {
        public TextView id_grille;
        public TextView level;
        public TextView pourcentage;
    }
}
