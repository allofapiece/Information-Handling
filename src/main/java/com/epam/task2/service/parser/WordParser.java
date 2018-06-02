package com.epam.task2.service.parser;

import com.epam.task2.entity.Composite;
import com.epam.task2.entity.Letter;
import com.epam.task2.entity.Word;

public class WordParser extends BaseParser {

    public WordParser() {
        data = new Word();
        this.pattern = ""; //Overriding spliting pattern for text
    }


}
