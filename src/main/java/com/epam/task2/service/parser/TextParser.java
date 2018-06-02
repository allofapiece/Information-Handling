package com.epam.task2.service.parser;

import com.epam.task2.entity.Text;

public class TextParser extends BaseParser {
    public TextParser() {
        data = new Text();
        next = new ParagraphParser();
        this.pattern = ""; //Overriding spliting pattern for text
    }
}
