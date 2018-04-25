package com.mesny.valentin.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Valentin on 25/04/2018.
 */

public class Grille extends View{

    private Rect rectangle;
    private Paint paint;

    public Grille(Context context, AttributeSet attrs) {
        super(context, attrs);
        int x = 0;
        int y = 0;
        int sideLength = 500;

        // create a rectangle that we'll draw later
        rectangle = new Rect(x, y, sideLength, sideLength);

        // create the Paint and set its color
        paint = new Paint();
        paint.setColor(Color.GRAY);


    }

    @Override
    public void onDraw(Canvas canvas){
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        /*canvas.drawRect(rectangle, paint);*/
        String listeChiffres = "096040001100060004504810390007950043030080000405023018010630059059070830003590007";


        int left = 10; // initial start position of rectangles (50 pixels from left)
        int top = 10; // 50 pixels from the top
        int width = 150;
        int height = 150;
        int compteur = 0;

        for (int row = 0; row < 9; row++) { // draw 2 rows
            for(int col = 0; col < 9; col++) { // draw 4 columns
                paint.setColor(Color.parseColor("#000000"));
                paint.setTextSize(80);
                if(listeChiffres.charAt(compteur) != '0'){
                    canvas.drawText("" + listeChiffres.charAt(compteur), left + 55, top + 100, paint);
                }
                canvas.drawRect(left, top, left+width, top+height, paint);
                left = (left + width + 5); // set new left co-ordinate + 10 pixel gap
                // Do other things here
                compteur++;
            }
            top = top + height + 5; // move to new row by changing the top co-ordinate
            left = 10;
        }
        //Permet de dessiner les lignes derrière
        Paint line = new Paint();
        line.setStyle(Paint.Style.STROKE);
        line.setStrokeWidth(10);
        canvas.drawLine(6, 470,1400, 470, line);
        canvas.drawLine(6, 940,1400, 940, line);
        canvas.drawLine(470, 6,470, 1400, line);
        canvas.drawLine(940, 6,940, 1400, line);
    }
}
