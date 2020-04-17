package com.company;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Token> tokenList= new ArrayList<>();

    public Board(List<Token> tokens) {
        tokenList.addAll(tokens);
    }
    public void printBoard(){
        for (var i:tokenList) {
            System.out.print(i.getValue()+" ");
        }
        System.out.println();
    }
    public List<Token> getTokenList() {
        return tokenList;
    }

    public void removeToken(Token token){
        tokenList.remove(token);
    }
}
