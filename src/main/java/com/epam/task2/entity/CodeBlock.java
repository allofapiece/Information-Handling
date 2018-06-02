package com.epam.task2.entity;

/**
 * Class, that describes code in text
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class CodeBlock implements SyntaxUnit {
    private String code;

    @Override
    public void print() {
        System.out.println(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
