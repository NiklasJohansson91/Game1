package com.company;

public class Monster {

    private int x;
    private int y;

    public char getMonster() {
        return monster;
    }

    public void setMonster(char monster) {
        this.monster = monster;
    }

    private char monster = '\255';

    public Monster(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x += x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y += y;
    }

    public void lubbeSearch(int x, int y) {

        if (x != getX()) {
            if (x > getX())
                setX(1);
            else
                setX(-1);
        }
        if (y != getY()) {
            if (y > getY())
                setY(1);
            else
                setY(-1);
        }


    }


}
