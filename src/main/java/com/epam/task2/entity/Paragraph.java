package com.epam.task2.entity;

/**
 * Entity, that is part of the text.
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class Paragraph extends Composite{

    /**
     * {@inheritDoc}
     */
    @Override
    protected void printAfter() {
        System.out.print("\n\t");
    }
}
