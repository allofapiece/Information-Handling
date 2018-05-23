package com.epam.task2.entity;

import java.util.List;

/**
 * Entity, that is part of the text
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class Paragraph extends TextUnit {

    /**
     * @param paragraphUnits List of paragraph parts(sentences)
     */
    public Paragraph(List<ParagraphUnit> paragraphUnits) {
        for (ParagraphUnit unit : paragraphUnits) {
            this.add(unit);
        }
    }
}
