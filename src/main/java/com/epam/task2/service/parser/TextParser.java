package com.epam.task2.service.parser;

import com.epam.task2.entity.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParser extends BaseParser {
    private String codeBlocksStringPattern;
    private String paragraphsStringPattern;
    private String pattern;
    private int lastCodeBlockStart;
    private int lastCodeBlockEnd;

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
        int position = -1;
        while (position == -1 ? matcher.find() : matcher.find(position)) {
            SyntaxUnit unit;
            Pattern codeBlockPattern = Pattern.compile(codeBlocksStringPattern);
            String str = matcher.group();
            if (codeBlockPattern.matcher(matcher.group()).matches()) {
                unit = new CodeBlock(extractCodeBlock(info, matcher.start()));
                data.add(unit);
                position = lastCodeBlockEnd;
            } else {
                data.add(next.parse(matcher.group()));
                position = -1;
            }
        }
        return data;
    }

    private String extractCodeBlock(String string, int start) {

    }
}
