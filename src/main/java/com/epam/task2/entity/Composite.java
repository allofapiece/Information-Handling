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
