package com.epam.task2.service.parser;

import com.epam.task2.entity.Composite;
import com.epam.task2.entity.SyntaxUnit;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class BaseParser implements ParserInterface {
	protected ParserInterface next;
	protected String patternString;
	protected Composite data;

	/**
	 * Default constructor
	 */
	public BaseParser() {}

	@Override
	public Composite parse(String info) {
		Pattern pattern = Pattern.compile(this.patternString); //Splitting string with regexp pattern
        Matcher matcher = pattern.matcher(info);

        while (matcher.find()) {
            if (this.next != null) {
                data.add(next.parse(matcher.group()));
            }
        }
		return data;
	}
}
