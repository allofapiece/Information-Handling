package com.epam.task2.service.parser;

import com.epam.task2.entity.Composite;
import com.epam.task2.entity.SyntaxUnit;

import java.util.List;
import java.util.ArrayList;

public abstract class BaseParser implements ParserInterface {
	protected ParserInterface next;
	protected String pattern;
	protected Composite data;

	/**
	 * Default constructor
	 */
	public BaseParser() {}

	@Override
	public Composite parse(String info) {
		String[] parts = info.split(pattern); //Splitting string with regexp pattern
		if (this.next != null) {
			for (String part : parts) {
				data.add(next.parse(part));
			}
		}
		return data;
	}
}
