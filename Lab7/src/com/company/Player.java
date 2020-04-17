package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player implements Runnable {
    private String name;
    private Game game;
    private List<Token> tokenList = new ArrayList<>();
    //public AtomicBoolean over=new AtomicBoolean(false);
    private volatile boolean over = false;
    int score=-1;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Player(String name) {
        this.name = name;
    }

    public int chooseToken() {
        try {
            System.out.print("Choose a token from the board: ");
            Scanner s = new Scanner(System.in);
            int value = s.nextInt();
            if (value < 0)
                throw new IllegalTokenValueException();
            else {
                return value;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return -1;
        }
    }

    private Token extractToken() {
        return new Token(this.chooseToken());
    }

    private void waitTurn(int index) throws InterruptedException {
        synchronized (game) {
            this.game.notifyAll();

            while (this.game.getCurrentPlayer() != index && game.getCurrentPlayer() != -1) {
                this.game.wait();
            }

        }
    }

    @Override
    public void run() {
        int index = this.game.getPlayersList().indexOf(this);
        while (!over) { //de adaugat conditie de oprire
            try {
                if (game.getCurrentPlayer() == -1) {
                    synchronized (game) {
                        this.game.notifyAll();
                        over = true;
                    }
                } else {
                    waitTurn(index);//makes all the threads except the current one wait
                    if (!game.gameHasEnded()) {
                        Token t = extractToken();
                        if (game.getBoard().getTokenList().contains(t)) {
                            tokenList.add(t);
                        } else {
                            System.out.println("You tried to choose an inexistent token and lost the turn");
                        }
                        this.game.update(t);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
