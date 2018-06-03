package com.epam.task2.main;

import com.epam.task2.entity.Paragraph;
import com.epam.task2.entity.Sentence;
import com.epam.task2.entity.Text;
import com.epam.task2.service.parser.ParagraphParser;
import com.epam.task2.service.parser.SentenceParser;
import com.epam.task2.service.parser.TextParser;
import com.epam.task2.service.reader.WholeTextFileReader;

import java.io.*;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Start {
    public static void main(String[] args) {
        WholeTextFileReader reader = new WholeTextFileReader(new File("test.txt"));
        String par = reader.readAll();
        String str = "1.\tEsfse fes fes se\r\n";
        //String str = "Lorem ipsum sdf e esf. eo eoj oejsfj es! esfjljeslkf? esfse, fsef ?";
        //Sentence sentence = (Sentence) new SentenceParser().parse(str);
        //Paragraph sentence = (Paragraph) new ParagraphParser().parse(str);
        Text text = (Text) new TextParser().parse(par);

        Pattern pattern = Pattern.compile(ResourceBundle.getBundle("resources").getString("parser.paragraph.sentences"));
        Matcher matcher = pattern.matcher(par);
        text.print();
        /*while (matcher.find()) {
            String str = matcher.group();
            Sentence sentence = (Sentence) new SentenceParser().parse(str);
            System.out.println(matcher.group());
        }*/
    }
}
