package com.epam.task2.entity;

/**
 * Class, that describes punctuation in sentence.
 * Keep attention {@link Punctuation} and {@link Word} classes are
 * located on the same level of class hierarchy
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class Punctuation extends SentenceUnit {

    char symbol;

    /**
     * @param symbol
     */
    public Punctuation(char symbol) {
        this.symbol = symbol;
    }

    @Override
    protected void printBefore() {
        System.out.println(symbol);
    }
}
