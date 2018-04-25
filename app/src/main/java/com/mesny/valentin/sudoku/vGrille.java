package com.mesny.valentin.sudoku;

/**
 * Created by Valentin on 25/04/2018.
 */

public class vGrille {

    public int level;
    public int num;
    public int done;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDone() {
        return done;
    }

    public void setDone(int done) {
        this.done = done;
    }

    public vGrille(int level, int num, int done){
        this.level = level;
        this.num = num;
        this.done = done;
    }

}
