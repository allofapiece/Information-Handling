package com.epam.task2.entity;

/**
 * Class, that describes code in text. {@code CodeBlock}
 * class is a 'leaf' of composite pattern and doesn't
 * contain children list.
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class CodeBlock implements SyntaxUnit {
    private String code;

    /**
     * Default constructor
     */
    public CodeBlock() {}

    /**
     * Constructor
     *
     * @param code
     */
    public CodeBlock(String code) {
        this.code = code;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void print() {
        System.out.println(code);
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (o == null || o.getClass() != getClass()) return false;

        CodeBlock codeBlock = (CodeBlock) o;

        return codeBlock.code != null ? code.equals(codeBlock.code) : code == null;
    }

    @Override
    public int hashCode() {
        return code != null ? code.hashCode() : 0;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
