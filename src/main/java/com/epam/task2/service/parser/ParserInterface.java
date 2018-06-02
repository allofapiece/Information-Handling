package com.epam.task2.service.parser;

import java.util.List;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.epam.task2.entity.Composite;
import com.epam.task2.entity.SyntaxUnit;

public interface ParserInterface {
	ResourceBundle bundle = ResourceBundle.getBundle("resources");
	public Composite parse(String info);
}
