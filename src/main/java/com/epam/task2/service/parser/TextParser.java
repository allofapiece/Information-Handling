package com.epam.task2.service.parser;

import com.epam.task2.entity.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser extends BaseParser {
    private String codeBlocksStringPattern;
    private String paragraphsStringPattern;
    private String pattern;

    public TextParser() {
        next = new ParagraphParser();
        this.codeBlocksStringPattern = bundle.getString("parser.text.codeblocks"); //Overriding spliting pattern for text
        this.paragraphsStringPattern = bundle.getString("parser.text.paragraphs");
        this.patternString = codeBlocksStringPattern + "|" + paragraphsStringPattern;
    }

    @Override
    public Composite parse(String info) {
        Pattern pattern = Pattern.compile(this.patternString);
        Matcher matcher = pattern.matcher(info);
        data = new Text();
        while (matcher.find()) {
            SyntaxUnit unit;
            Pattern codeBlocksPattern = Pattern.compile(codeBlocksStringPattern);
            if (codeBlocksPattern.matcher(matcher.group()).matches()) {
                unit = new CodeBlock(matcher.group());
                data.add(unit);
            } else {
                data.add(next.parse(matcher.group()));
            }
        }
        return data;
    }
}
