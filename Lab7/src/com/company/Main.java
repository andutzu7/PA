package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static List<Player> generatePlayers(int numberOfPlayer) {
        List<Player> result = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < numberOfPlayer; i++) {
            System.out.print("Player " + (i + 1) + " name: ");
            String name = scanner.nextLine();
            result.add(new Player(name));
        }
        return result;
    }

    public static List<Integer> generatePermutation(int lowerBound, int upperBound) {
        List<Integer> permutation = IntStream.rangeClosed(lowerBound, upperBound).boxed().collect(Collectors.toList());
        Collections.shuffle(permutation);
        return permutation;
    }

    public static List<Token> generateTokens(int numberOfTokens, int maximumValueOfToken) {

        List<Token> tokens = new ArrayList<>();
        List<Integer> permutation = generatePermutation(0, maximumValueOfToken);

        for (int i = 0; i < numberOfTokens; i++) {
            tokens.add(new Token(permutation.get(i)));
        }

        return tokens;
    }

    public static void main(String[] args) {
        List<Token> tokens = generateTokens(6, 10);
        List<Player> players = generatePlayers(2);
        Board board = new Board(tokens);
        Game game = new Game(board, players, 3, 1);
        for (Player p : players) {
            p.setGame(game);
        }
        game.start();

    }
}


