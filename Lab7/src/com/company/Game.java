package com.company;

import java.util.*;

public class Game {

    private Board board;
    static int boardSize;
    public List<Player> getPlayersList() {
        return playersList;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    private int arithmeticProgressionLength;

    private int currentPlayer;

    private List<Player> playersList = new ArrayList<>();

    TimeKeeper t;

    public Board getBoard() {
        return board;
    }

    public Game(Board board, List<Player> playerList, int arithmeticProgressionLength,int maxTimeM) {
        this.board = board;
        this.arithmeticProgressionLength = arithmeticProgressionLength;
        this.playersList.addAll(playerList);
        boardSize = board.getTokenList().size();
        t = new TimeKeeper(maxTimeM);
        t.setDaemon(true);

    }

    private void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    private void initPlayers() {
        for (Player p : playersList) {
            new Thread(p).start();
        }
    }

    private void getPlayerInfo(int index) {
        System.out.println("Current player:" + playersList.get(index).getName());
        System.out.println("Current board: ");
        board.printBoard();
        System.out.print("Your current tokens:");
        List<Token> tokenList = playersList.get(index).getTokenList();
        for (Token t : tokenList) {
            System.out.print(t.getValue() + " ");
        }
        System.out.println();
    }

    public boolean isAritmethicProgression0(List<Token> list) {
        if (list.size() >= 2) {
            int ratio = list.get(1).getValue() - list.get(0).getValue();
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).getValue() == 0) {
                    if (i != 0)//daca nu e pe prima poz
                        list.set(i, new Token(list.get(i - 1).getValue() + ratio));
                }

                if (list.get(i + 1).getValue() - list.get(i).getValue() != ratio)
                    if (list.get(i + 1).getValue() != 0 && list.get(i).getValue() != 0)//daca unul din ele e 0
                        return false;

            }
            return true;
        }
        return false;
    }

    private int computePoints(List<Token> tokens) {
        int score = 0;
        if (isAritmethicProgression0(tokens))
            if (tokens.size() == arithmeticProgressionLength)
                score = boardSize;
            else
                score = tokens.size();
        return score;
    }

    private boolean containsBlankToken(List<Token> tokens) {
        for (Token token : tokens)
            if (token.getValue() == 0) {
                return true;
            }
        return false;
    }

    private int computeScore(int index) {
        int bonus = 0;
        if (containsBlankToken(playersList.get(index).getTokenList())) {
            bonus = 1;
        }
        int result = computePoints(playersList.get(index).getTokenList());
        return (bonus + result);
    }

    private void createLeaderboard() {
        int typeOfWin = -1;//1 goala tabla 2 progresie completa
        if (board.getTokenList().size() == 0)
            typeOfWin = 1;
        for (var player : playersList) {
            if (isAritmethicProgression0(player.getTokenList()))
                if (player.getTokenList().size() == arithmeticProgressionLength) {
                    typeOfWin = 2;
                    break;
                }
        }

        if (typeOfWin == 1) {
            for (int i = 0; i < playersList.size(); i++) {
                playersList.get(i).setScore(computeScore(i));
            }
        } else {
            for (int i = 0; i < playersList.size(); i++) {
                if (isAritmethicProgression0(playersList.get(i).getTokenList()) &&
                        playersList.get(i).getTokenList().size() == arithmeticProgressionLength) {
                    playersList.get(i).setScore(computeScore(i));
                } else {
                    playersList.get(i).setScore(0);
                }
            }

        }
        for (Player player : playersList) {
            System.out.println(player.getName() + ": " + player.getScore());

        }
    }

    public boolean gameHasEnded() {
        if (board.getTokenList().size() == 0) {
            return true;
        }
        for (var player : playersList) {
            if (isAritmethicProgression0(player.getTokenList()))
                if (player.getTokenList().size() == arithmeticProgressionLength)//cineva a facut o progresie arimtetica completa
                    return true;
        }
        return false;
    }

    public void update(Token t) {
        this.board.removeToken(t);
        int nextPlayer;
        if (gameHasEnded()) {
            nextPlayer = -1;//not elegant but solving a bug
            System.out.println("The game is over.");
            createLeaderboard();
        } else {
            nextPlayer = (getCurrentPlayer() + 1) % getPlayersList().size();
            getPlayerInfo(nextPlayer);
        }
        setCurrentPlayer(nextPlayer);
    }


    public void start() {
        setCurrentPlayer(0);
        getPlayerInfo(getCurrentPlayer());
        initPlayers();
        t.start();

    }
}
