package com.epam.task2.entity;

import javafx.concurrent.WorkerStateEvent;

/**
 * That class describes words of sentence.
 * Keep attention {@link Punctuation} and {@link Word} classes are
 * located on the same level of class hierarchy
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class Word implements SyntaxUnit {
    private String word;

    /**
     * Default constructor
     */
    public Word() {}

    /**
     * Constructor
     *
     * @param word
     */
    public Word(String word) {
        this.word = word;
    }

    /**
     * Method print whitespace before each word
     */
    /*@Override
    public void printBefore() {
        System.out.println(" " + word);
    }*/

    @Override
    public void print() {
        System.out.print(" " + word);
    }

    @Override
    public String toString() {
        return word;
    }
}
