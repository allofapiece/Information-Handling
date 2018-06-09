package com.epam.task2.entity;

/**
 * Class, that describes punctuation in sentence.
 * Keep attention {@link Punctuation} and {@link Word} classes are
 * located on the same level of class hierarchy. {@code Punctuation}
 * class is a 'leaf' of composite pattern and doesn't
 * contain children list.
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class Punctuation implements SyntaxUnit {

    /**
     * Field contains values of punctuation:
     * '?', '!', '.' and etc.
     */
    private String punctuation;

    /**
     * Default constructor
     */
    public Punctuation(){}

    /**
     * Constructor
     *
     * @param punctuation
     */
    public Punctuation(String punctuation) {
        this.punctuation = punctuation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void print() {
        System.out.print(punctuation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Punctuation that = (Punctuation) o;

        return punctuation != null ? punctuation.equals(that.punctuation) : that.punctuation == null;
    }

    @Override
    public int hashCode() {
        return punctuation != null ? punctuation.hashCode() : 0;
    }

    public String getPunctuation() {
        return punctuation;
    }

    public void setPunctuation(String punctuation) {
        this.punctuation = punctuation;
    }
}
