package com.epam.task2.service.parser;

import com.epam.task2.entity.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends BaseParser {

    public SentenceParser() {
        data = new Sentence();
        next = new WordParser();
        this.pattern = bundle.getString("parser.sentence.total"); //Overriding spliting pattern for text
    }

    @Override
    public Composite parse(String info) {
        Pattern pattern = Pattern.compile(this.pattern);
        Matcher matcher = pattern.matcher(info);

        while (matcher.find()) {
            SyntaxUnit unit;
            
            Pattern punctuationPattern = Pattern.compile("\\d+");
            Matcher punctuationMatcher = punctuationPattern.matcher(matcher.toString()); 
            
            if (punctuationMatcher.matches()) {
                unit = new Punctuation(matcher.toString());
            } else {
                unit = new Word(matcher.toString());
            }
            
            data.add(unit);
        }
        return data;
    }
}
