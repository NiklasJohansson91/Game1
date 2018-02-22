package com.company;

import com.googlecode.lanterna.TerminalFacade;
import com.googlecode.lanterna.input.Key;
import com.googlecode.lanterna.terminal.Terminal;

import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Terminal terminal = TerminalFacade.createTerminal(System.in,
                System.out, Charset.forName("UTF8"));
        terminal.enterPrivateMode();
        terminal.setCursorVisible(false);
        terminal.applyBackgroundColor(Terminal.Color.CYAN);

        Player player = new Player(50, 15);

        Monster monster1 = new Monster(0, 0);
        Monster monster2 = new Monster(0, 30);
        Monster monster3 = new Monster(99, 0);
        Monster monster4 = new Monster(99, 30);

        String message = "GAME OVER!";
        int x = 45;
        int y = 15;

        Monster[] monster = {monster1, monster2, monster3, monster4};

        boolean gameState = true;

        while (gameState) {
//Wait for a key to be pressed
            Key key;
            do {
                Thread.sleep(5);
                key = terminal.readInput();
            }
            while (key == null);
            System.out.println(key.getCharacter() + " " + key.getKind());
            terminal.clearScreen();

            keyCommand(player, key);


            terminal.moveCursor(player.getX(), player.getY());
            terminal.putCharacter(player.getLubbe());


            for (int i = 0; i < monster.length; i++) {


                terminal.moveCursor(monster[i].getX(), monster[i].getY());
                terminal.putCharacter(monster[i].getMonster());

                if (monster[i].getX() == player.getX() &&
                        monster[i].getY() == player.getY()) {
                    terminal.clearScreen();

                    writeMessage(terminal, message, x, y);

                    gameState=false;
                    x = 45;
                    break;
                }
                monster[i].lubbeSearch(player.getX(), player.getY());

                monsterCollision(monster, i);

            }

        }

    }

    private static void keyCommand(Player player, Key key) {
        switch (key.getKind()) {
            case ArrowDown:
                player.setY(1);
                break;
            case ArrowUp:
                player.setY(-1);
                break;
            case ArrowLeft:
                player.setX(-1);
                break;
            case ArrowRight:
                player.setX(1);
                break;
        }
    }

    private static void monsterCollision(Monster[] monster, int i) {
        for (int j = 0; j < monster.length; j++) {
            if (i != j) {
                if (monster[i].getX() == monster[j].getX() &&
                        monster[i].getY() == monster[j].getY()) {
                    monster[i].setX(1);
                    monster[i].setY(1);
                    j = 0;
                }
            }
        }
    }

    private static void writeMessage(Terminal terminal, String message, int x, int y) {
        for (int k = 0; k < message.length(); k++) {
            terminal.moveCursor(x, y);
            terminal.putCharacter(message.charAt(k));
            x += 1;
        }
    }
}

