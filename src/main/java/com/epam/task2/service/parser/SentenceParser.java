package com.epam.task2.service.parser;

import com.epam.task2.entity.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenceParser extends BaseParser {
    private String wordsStringPattern;
    private String punctutionStringPattern;

    public SentenceParser() {
        this.wordsStringPattern = bundle.getString("parser.sentence.words");
        this.punctutionStringPattern = bundle.getString("parser.sentence.punctuation");
        this.patternString = "(" + wordsStringPattern + ")|(" + punctutionStringPattern + ")";
    }

    @Override
    public Composite parse(String info) {
        Pattern pattern = Pattern.compile(this.patternString);
        Matcher matcher = pattern.matcher(info);
        data = new Sentence();
        while (matcher.find()) {

            SyntaxUnit unit;
            Pattern punctuationPattern = Pattern.compile(punctutionStringPattern);
            String str = matcher.group();
            if (punctuationPattern.matcher(matcher.group()).matches()) {
                unit = new Punctuation(matcher.group());
            } else {
                unit = new Word(matcher.group());
            }
            
            data.add(unit);
        }
        return data;
    }
}
