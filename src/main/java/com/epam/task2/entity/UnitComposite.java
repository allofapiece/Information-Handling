package com.epam.task2.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite interface
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public abstract class UnitComposite {
    private List<UnitComposite> children = new ArrayList<>();

    /**
     * @param unit
     */
    public void add(UnitComposite unit) {
        children.add(unit);
    }

    /**
     * @return int
     */
    public int count() {
        return children.size();
    }

    /**
     * Method uses recursion for displaying all children's
     * in composite hierarchy
     */
    public void print() {
        printBefore();
        for (UnitComposite unit : children) {
            unit.print();
        }
        printAfter();
    }

    /**
     * Can be used in {@code print} method how
     * template before component printing
     */
    protected void printBefore() {}

    /**
     * Can be used in {@code print} method how
     * template after component printing
     */
    protected void printAfter() {}
}
