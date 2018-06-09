package com.epam.task2.service.parser;

import com.epam.task2.entity.Composite;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Implementation of {@link ParserInterface} and
 * contains the default parse method
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public abstract class BaseParser implements ParserInterface {
	protected ParserInterface next;
	protected String patternString;
	protected Composite data;

	/**
	 * Default constructor
	 */
	public BaseParser() {}

	/**
	 * Used pattern string from {@link ResourceBundle},
	 * that can be defined in the child classes
	 *
	 * @param info String for parsing
	 * @return Composite
	 */
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
