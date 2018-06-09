package com.epam.task2.service.parser;

import com.epam.task2.entity.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Specific implementation of {@link BaseParser}
 * where {@code parse} method do parsing of {@link Sentence}
 * and split final information on {@link Word words} and
 * {@link Punctuation punctuation}
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class SentenceParser extends BaseParser {
    
    /**
     * Regular expression pattern for finding words
     */
    private String wordsStringPattern;
    
    /**
     * Regular expression pattern for finding punctuation
     */
    private String punctuationStringPattern;

    /**
     * Default constructor
     */
    public SentenceParser() {
        this.wordsStringPattern = bundle.getString("parser.sentence.words");
        this.punctuationStringPattern = bundle.getString("parser.sentence.punctuation");
        this.patternString = "(" + wordsStringPattern + ")|(" + punctuationStringPattern + ")";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Composite parse(String info) {
        Pattern pattern = Pattern.compile(this.patternString);
        Matcher matcher = pattern.matcher(info);
        data = new Sentence();
        while (matcher.find()) {
            SyntaxUnit unit;
            Pattern punctuationPattern = Pattern.compile(punctuationStringPattern);
            
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
