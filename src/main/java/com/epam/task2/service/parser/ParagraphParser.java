package com.epam.task2.service.parser;

import com.epam.task2.entity.Composite;
import com.epam.task2.entity.Paragraph;
import com.epam.task2.entity.Text;

public class ParagraphParser extends BaseParser {
    public ParagraphParser() {
        next = new SentenceParser();
        this.patternString = bundle.getString("parser.paragraph.sentences"); //Overriding spliting pattern for text
    }

    @Override
    public Composite parse(String info) {
        data = new Paragraph();
        return super.parse(info);
    }
}
