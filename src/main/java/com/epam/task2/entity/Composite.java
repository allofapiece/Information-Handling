package com.epam.task2.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Composite interface
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public abstract class Composite implements SyntaxUnit {
    protected List<SyntaxUnit> children = new ArrayList<>();

    /**
     * Default constructor
     */
    public Composite() {}

    /**
     * Constructor
     *
     * @param syntaxUnits
     */
    public Composite(List<SyntaxUnit> syntaxUnits) {
        children = syntaxUnits;
    }

    /**
     * @param unit
     */
    public void add(SyntaxUnit unit) {
        children.add(unit);
    }

	/**
	 * @param children
	 */
	public void setChildren(List children) {
		this.children = children;
	}

    /**
     * @return List
     */
    public List<SyntaxUnit> getChildren() {
        return this.children;
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
        for (SyntaxUnit unit : children) {
            unit.print();
        }
        printAfter();
    }

    /**
     * Can be used in {@code print} method as
     * before component printing template
     */
    protected void printBefore() {}

    /**
     * Can be used in {@code print} method as
     * after component printing template
     */
    protected void printAfter() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Composite composite = (Composite) o;

        return children != null ? children.equals(composite.children) : composite.children == null;
    }

    @Override
    public int hashCode() {
        return children != null ? children.hashCode() : 0;
    }
}
