package com.epam.task2.entity;

import java.util.List;

/**
 * This class describes sentences of paragraphs
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class Sentence extends UnitComposite {

    /**
     * @param sentenceUnits
     */
    public Sentence(List<SentenceUnit> sentenceUnits) {
        for (SentenceUnit unit : sentenceUnits) {
            this.add(unit);
        }
    }
}
