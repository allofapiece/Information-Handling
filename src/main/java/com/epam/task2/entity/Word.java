package com.epam.task2.entity;

/**
 * That class describes words of sentence.
 * Keep attention {@link Punctuation} and {@link Word} classes are
 * located on the same level of class hierarchy
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class Word extends SentenceUnit {

    private String word;

    /**
     * @param word
     */
    public Word(String word) {
        this.word = word;
    }

    /**
     * Method print whitespace before each word
     */
    @Override
    public void printBefore() {
        System.out.println(" ");
    }

}
