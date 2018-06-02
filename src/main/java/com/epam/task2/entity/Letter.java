package com.epam.task2.entity;

public class Letter implements SyntaxUnit {
    private char letter;

    public Letter(char letter) {
        this.letter = letter;
    }

    @Override
    public void print() {
        System.out.println(letter);
    }
}
