package com.epam.task2.service.parser;

import com.epam.task2.entity.Composite;
import com.epam.task2.entity.Paragraph;

/**
 * Specific implementation of {@link BaseParser}
 * where {@code parse} method do parsing of {@link Paragraph}
 * and split final information on {@link com.epam.task2.entity.Sentence sentencies}
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class ParagraphParser extends BaseParser {

    /**
     * Default constructor
     */
    public ParagraphParser() {
        next = new SentenceParser();
        this.patternString = bundle.getString("parser.paragraph.sentences");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Composite parse(String info) {
        data = new Paragraph();
        return super.parse(info);
    }
}
