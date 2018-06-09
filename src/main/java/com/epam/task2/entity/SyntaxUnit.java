package com.epam.task2.entity;

/**
 * Class is parent for {@link Composite}, {@link CodeBlock},
 * {@link Word} and {@link Punctuation} classes. SyntaxUnit class
 * is a part of composite pattern
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public interface SyntaxUnit {

    /**
     * Method prints main information of class
     */
    void print();
}
