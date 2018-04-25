package com.mesny.valentin.sudoku;

import android.content.Context;
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
        // Get the data item for this position
        /*vGrille grille = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_grille, parent, false);
        }
        // Lookup view for data population
        TextView tvName = (TextView) convertView.findViewById(R.id.tvName);
        TextView tvHome = (TextView) convertView.findViewById(R.id.tvHome);
        // Populate the data into the template view using the data object
        tvName.setText(grille.level);
        tvHome.setText(grille.num);
        // Return the completed view to render on screen
        return convertView;
*/
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

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        vGrille grille = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        assert grille != null;
        viewHolder.id_grille.setText("Sudoku : " + grille.getNum());
        viewHolder.level.setText("Level : " + grille.getLevel());
        viewHolder.pourcentage.setText("" + grille.getDone() + " %");

        return convertView;
    }

    public class ListViewHolder {
        public TextView id_grille;
        public TextView level;
        public TextView pourcentage;
    }
}
