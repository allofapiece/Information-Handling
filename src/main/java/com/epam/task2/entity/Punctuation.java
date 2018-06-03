package com.epam.task2.entity;

/**
 * Class, that describes punctuation in sentence.
 * Keep attention {@link Punctuation} and {@link Word} classes are
 * located on the same level of class hierarchy
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class Punctuation implements SyntaxUnit {

    String punctuation;

    /**
     * Constructor
     *
     * @param punctuation
     */
    public Punctuation(String punctuation) {
        this.punctuation = punctuation;
    }

    @Override
    public void print() {
        System.out.print(punctuation);
    }
}
