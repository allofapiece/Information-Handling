package com.epam.task2.entity;

import java.util.List;

/**
 * Class that describes all text in document
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class Text extends UnitComposite {

    /**
     * Constructor
     *
     * @param textUnits Parts of whole text (Paragraphs and Code blocks)
     */
    public Text(List<TextUnit> textUnits) {
        for (TextUnit unit : textUnits) {
            this.add(unit);
        }
    }
}
