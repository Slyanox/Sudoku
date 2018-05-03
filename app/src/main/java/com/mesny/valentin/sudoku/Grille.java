package com.mesny.valentin.sudoku;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by Valentin on 25/04/2018.
 */

public class Grille extends View {

    private Rect rectangle;
    private Paint paint;
    private Context contexttoast;

    public Grille(Context context, AttributeSet attrs) {
        super(context, attrs);
        int x = 0;
        int y = 0;
        int sideLength = 500;
        this.contexttoast = context;

        // create a rectangle that we'll draw later
        rectangle = new Rect(x, y, sideLength, sideLength);

        // create the Paint and set its color
        paint = new Paint();
        paint.setColor(Color.GRAY);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int)event.getX();
        int y = (int)event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                CharSequence text = "" + getValueText(x, y);
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(contexttoast, text, duration);
                toast.show();
            case MotionEvent.ACTION_MOVE:
                System.out.println("Move");
        }
        this.invalidate();
        return true;
    }

    public int getValueText(int x, int y){
        int ret = 0;
        if(x > 25 && x < 175 && y > 1525 && y < 1675){
            ret = 1;
        }
        else if(x > 175 && x < 325 && y > 1525 && y < 1675){
            ret = 2;
        }
        else if(x > 325 && x < 475 && y > 1525 && y < 1675){
            ret = 3;
        }
        else if(x > 475 && x < 625 && y > 1525 && y < 1675){
            ret = 4;
        }
        else if(x > 625 && x < 775 && y > 1525 && y < 1675){
            ret = 5;
        }
        else if(x > 775 && x < 925 && y > 1525 && y < 1675){
            ret = 6;
        }
        else if(x > 925 && x < 1075 && y > 1525 && y < 1675){
            ret = 7;
        }
        else if(x > 1075 && x < 1225 && y > 1525 && y < 1675){
            ret = 8;
        }
        else if(x > 1225 && x < 1375 && y > 1525 && y < 1675){
            ret = 9;
        }

        return ret;
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
                    canvas.drawText("" + listeChiffres.charAt(compteur), left + 50, top + 100, paint);
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
        //Permet de créer les chiffres pour le drag'n drop
        canvas.drawText("1", 100, 1600, paint);
        canvas.drawText("2", 250, 1600, paint);
        canvas.drawText("3", 400, 1600, paint);
        canvas.drawText("4", 550, 1600, paint);
        canvas.drawText("5", 700, 1600, paint);
        canvas.drawText("6", 850, 1600, paint);
        canvas.drawText("7", 1000, 1600, paint);
        canvas.drawText("8", 1150, 1600, paint);
        canvas.drawText("9", 1300, 1600, paint);
    }
}
