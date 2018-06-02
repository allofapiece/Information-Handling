package com.epam.task2.service.parser;

import com.epam.task2.entity.Paragraph;
import com.epam.task2.entity.Text;

public class ParagraphParser extends BaseParser {
    public ParagraphParser() {
        data = new Paragraph();
        next = new SentenceParser();
        this.pattern = ""; //Overriding spliting pattern for text
    }
}
