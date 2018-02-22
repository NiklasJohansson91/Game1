package com.company;

public class Player {

    private int x;
    private int y;

    public char getLubbe() {
        return lubbe;
    }

    public void setLubbe(char lubbe) {
        this.lubbe = lubbe;
    }

    private char lubbe = '\u263a';

    public Player(int x, int y) {
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
}
