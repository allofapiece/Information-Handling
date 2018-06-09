package com.epam.task2.service.parser;

import com.epam.task2.entity.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Specific implementation of {@link BaseParser}
 * where {@code parse} method do parsing of {@link Text}
 * and split final information on {@link Paragraph paragraphs}
 * and {@link CodeBlock code blocks}
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public class TextParser extends BaseParser {

    /**
     * Regular expression patter for finding code blocks
     */
    private String codeBlocksStringPattern;

    /**
     * Regular expression patter for finding paragraphs
     */
    private String paragraphsStringPattern;

    /**
     * Default constructor
     */
    public TextParser() {
        next = new ParagraphParser();
        this.codeBlocksStringPattern = bundle.getString("parser.text.codeblocks"); //Overriding spliting pattern for text
        this.paragraphsStringPattern = bundle.getString("parser.text.paragraphs");
        this.patternString = codeBlocksStringPattern + "|" + paragraphsStringPattern;
    }

    /**
     * {@inheritDoc}
     */
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
