package com.company;

import java.util.Objects;

public class Token implements Comparable<Token> {
    private int value;
    public Token(int value) {
        setValue(value);//to make sure no illegal values are inserted
    }

    int getValue() {
        return value;
    }

    public void setValue(int value) {
        try {
            if (value < 0)
                throw new IllegalTokenValueException();
            else {
                this.value = value;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return getValue() == token.getValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue());
    }

    @Override
    public int compareTo(Token token) {
        return Integer.compare(this.value, token.getValue());
    }
}
