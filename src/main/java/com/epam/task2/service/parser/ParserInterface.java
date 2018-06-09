package com.epam.task2.service.parser;

import com.epam.task2.entity.Composite;

import java.util.ResourceBundle;

/**
 * Used for parsing information and spliting it
 * on {@link Composite Composites}
 *
 * @author Listratsenka Stanislau
 * @version 1.0
 */
public interface ParserInterface {

	/**
	 * Store regular expressions for parsing
	 */
	ResourceBundle bundle = ResourceBundle.getBundle("resources");

	/**
	 * Do parse of string with specific rules
	 *
	 * @param info String for parsing
	 * @return Composite
	 */
	Composite parse(String info);
}
