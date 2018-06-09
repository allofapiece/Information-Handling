package com.epam.task2.entity;

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
     * {@inheritDoc}
     */
    @Override
    public void print() {
        System.out.print(" " + word);
    }

    @Override
    public String toString() {
        return word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        return word != null ? word.equals(word1.word) : word1.word == null;
    }

    @Override
    public int hashCode() {
        return word != null ? word.hashCode() : 0;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
